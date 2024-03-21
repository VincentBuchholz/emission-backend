package dk.vv.emission.repositories;


import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.*;
//import dk.vv.emission.dtos.CityDTO;
import dk.vv.emission.dtos.*;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


public class CityService {



    MongoClient mongoClient;

    MongoCollection<Document> cityCollection;

    public CityService(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
        this.cityCollection = mongoClient.getDatabase("ola_2").getCollection("cities");
    }

    public List<TempEmissionInformation> getCitiesWithAvgTemp(){

        AggregateIterable<Document> aggregationResult = cityCollection.aggregate(Arrays.asList(
                new Document("$match", new Document("averageAnnualTemperature", new Document("$exists", true).append("$ne", null))
                        .append("emissions.totalEmissions", new Document("$exists", true).append("$ne", null))),
                new Document("$sort",new Document("emissions.reportingYear",-1)),
                new Document("$project", new Document("cityId", "$_id")
                        .append("avgAnnualTemp", "$averageAnnualTemperature")
                        .append("cityName", "$cityName")
                        .append("totalEmissions", new Document("$first","$emissions.totalEmissions")))
        ));

        List<TempEmissionInformation> tempEmissionInformations = new ArrayList<>();

        for (Document doc : aggregationResult) {
            ObjectId cityId = doc.getObjectId("cityId");

            String cityName = doc.getString("cityName");

            Object avgAnnualTempObj = doc.get("avgAnnualTemp");
            double avgAnnualTemp = 0.0;
            if (avgAnnualTempObj instanceof Integer) {
                avgAnnualTemp = ((Integer) avgAnnualTempObj).doubleValue();
            } else if (avgAnnualTempObj instanceof Double) {
                avgAnnualTemp = (Double) avgAnnualTempObj;
            }
            Object totalEmissionsObj = doc.get("totalEmissions");
            double totalEmissions = 0.0;
            if (totalEmissionsObj instanceof Integer) {
                totalEmissions = ((Integer) totalEmissionsObj).doubleValue();
            } else if (totalEmissionsObj instanceof Double) {
                totalEmissions = (Double) totalEmissionsObj;
            }

            tempEmissionInformations.add(new TempEmissionInformation(cityId,avgAnnualTemp, cityName,totalEmissions));
        }

        return tempEmissionInformations;
    }


    public List<CountryAvgEmissionInfo> getAverageEmissionsByCountry(){

        List<CountryAvgEmissionInfo> countryAvgEmissionInfos = new ArrayList<>();

        cityCollection.aggregate(Arrays.asList(
                Aggregates.unwind("$emissions"),
                Aggregates.match(Filters.exists("emissions.totalEmissions")),
                Aggregates.group(
                        "$countryId",
                        Accumulators.avg("avgEmissions", "$emissions.totalEmissions")
                ),
                Aggregates.lookup("countries", "_id", "_id", "country"),
                Aggregates.unwind("$country"),
                Aggregates.project(new Document("countryName", "$country.countryName")
                        .append("avgEmissions", "$avgEmissions"))
        )).forEach(document -> {
            String countryName = document.getString("countryName");
            double avgEmissions = document.getDouble("avgEmissions");

            CountryAvgEmissionInfo countryAvgEmissionInfo = new CountryAvgEmissionInfo(countryName, avgEmissions);
            countryAvgEmissionInfos.add(countryAvgEmissionInfo);
        });

        return countryAvgEmissionInfos;
    }

    public List<CityTargetInformation> getCitiesWithCO2NeutralTargets(){

        List<CityTargetInformation> cityTargetInformations = new ArrayList<>();

        cityCollection.aggregate(Arrays.asList(
                Aggregates.match(Filters.eq("emissionTargets.percentageReductionTarget", 100)),
                Aggregates.unwind("$emissionTargets"),
                Aggregates.match(Filters.eq("emissionTargets.percentageReductionTarget", 100)),
                Aggregates.project(new Document("_id", 0)
                        .append("cityName", "$cityName")
                        .append("percentageReductionTarget", "$emissionTargets.percentageReductionTarget")
                        .append("targetYear", "$emissionTargets.targetYear")
                )
        )).forEach(document -> {
            String cityName = document.getString("cityName");
            int percentageReductionTarget = document.getInteger("percentageReductionTarget");
            int targetYear = document.getInteger("targetYear");

            CityTargetInformation cityTargetInformation = new CityTargetInformation(percentageReductionTarget, cityName, targetYear);
            cityTargetInformations.add(cityTargetInformation);
        });

        return cityTargetInformations;
    }

    public List<AvgTargetInformation> getAverageForCitesAndIsC40(){
        List<AvgTargetInformation> avgTargetInformations = new ArrayList<>();

        cityCollection.aggregate(Arrays.asList(
                Aggregates.unwind("$emissionTargets"),
                Aggregates.group("$c40",
                        Accumulators.avg("avgPercentageReductionTarget", "$emissionTargets.percentageReductionTarget")
                ),
                Aggregates.project(Projections.fields(
                        Projections.excludeId(),
                        Projections.computed("c40", "$_id"),
                        Projections.include("avgPercentageReductionTarget")
                ))
        )).forEach(document ->{
            boolean c40 = document.getBoolean("c40");

            double percentageReductionTarget = document.getDouble("avgPercentageReductionTarget");
            avgTargetInformations.add(new AvgTargetInformation(c40,percentageReductionTarget));
        });

        return avgTargetInformations;
    }

    public List<CountryAvgTargetInfo> getCountryAvgTargetInfos() {
        List<CountryAvgTargetInfo> countryAvgEmissionInfos = new ArrayList<>();

        cityCollection.aggregate(Arrays.asList(
                Aggregates.unwind("$emissionTargets"),
                Aggregates.match(Filters.ne("emissionTargets.percentageReductionTarget",null)),
                Aggregates.group(
                        "$countryId",
                        Accumulators.avg("avgReduction", "$emissionTargets.percentageReductionTarget")
                ),
                Aggregates.lookup("countries", "_id", "_id", "country"),
                Aggregates.unwind("$country"),
                Aggregates.project(new Document("countryName", "$country.countryName")
                        .append("avgReduction", "$avgReduction"))
        )).forEach(document -> {
            String countryName = document.getString("countryName");
            double avgReduction = document.getDouble("avgReduction");

            CountryAvgTargetInfo countryAvgTargetInfo = new CountryAvgTargetInfo(countryName, avgReduction);
            countryAvgEmissionInfos.add(countryAvgTargetInfo);
        });

        return countryAvgEmissionInfos;
    }

    public List<AvgReductionSectorInfo> getAverageReductionBySector() {

        List<AvgReductionSectorInfo> avgReductionSectorInfos = new ArrayList<>();

       cityCollection.aggregate(Arrays.asList(
               Aggregates.unwind("$emissionTargets"),
               Aggregates.match(Filters.and(
                       Filters.exists("emissionTargets.percentageReductionTarget", true),
                       Filters.ne("emissionTargets.percentageReductionTarget", null)
               )),
               Aggregates.group("$emissionTargets.sector",
                       Accumulators.avg("avgPercentageReductionTarget", "$emissionTargets.percentageReductionTarget")
               ),
               Aggregates.project(Projections.fields(
                       Projections.excludeId(),
                       Projections.computed("sector", "$_id"),
                       Projections.include("avgPercentageReductionTarget")
               ))
        )).forEach(document -> {

           String sectorName = document.getString("sector");
           Object avgReductionTargetTempObj = document.get("avgPercentageReductionTarget");
           double avgReductionTarget = 0.0;
           if (avgReductionTargetTempObj instanceof Integer) {
               avgReductionTarget = ((Integer) avgReductionTargetTempObj).doubleValue();
           } else if (avgReductionTargetTempObj instanceof Double) {
               avgReductionTarget = (Double) avgReductionTargetTempObj;
           }

           AvgReductionSectorInfo avgReductionSectorInfo = new AvgReductionSectorInfo(sectorName, avgReductionTarget);
           avgReductionSectorInfos.add(avgReductionSectorInfo);
       });
       return avgReductionSectorInfos;
    }

    public List<EmissionStatusInfo> getEmissionStatusInfo() {
        List<EmissionStatusInfo> emissionStatusInfos = new ArrayList<>();

        List<BsonDocument> pipeline = Arrays.asList(
                BsonDocument.parse("{ \"$unwind\": \"$emissions\" }"),
                BsonDocument.parse("{\n" +
                        "    \"$group\": {\n" +
                        "      \"_id\": \"$emissions.reportingYear\",\n" +
                        "      \"count\": { \"$sum\": 1 },\n" +
                        "      \"increased\": {\n" +
                        "        \"$sum\": {\n" +
                        "          \"$cond\": [\n" +
                        "            { \"$eq\": [\"$emissions.status\", \"Increased\"] },\n" +
                        "            1,\n" +
                        "            0\n" +
                        "          ]\n" +
                        "        }\n" +
                        "      },\n" +
                        "      \"decreased\": {\n" +
                        "        \"$sum\": {\n" +
                        "          \"$cond\": [\n" +
                        "            { \"$eq\": [\"$emissions.status\", \"Decreased\"] },\n" +
                        "            1,\n" +
                        "            0\n" +
                        "          ]\n" +
                        "        }\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }"),
                BsonDocument.parse("{\n" +
                        "    \"$project\": {\n" +
                        "      \"year\": \"$_id\",\n" +
                        "      \"_id\": 0,\n" +
                        "      \"count\": 1,\n" +
                        "      \"increased\": 1,\n" +
                        "      \"decreased\": 1\n" +
                        "    }\n" +
                        "  }")
        );


        cityCollection.aggregate(pipeline).forEach(document -> {
            int year = document.getInteger("year");
            long count = document.getInteger("count");
            long increased = ((Number) document.get("increased")).longValue();
            long decreased = ((Number) document.get("decreased")).longValue();
            emissionStatusInfos.add(new EmissionStatusInfo(year, count, increased, decreased));
        });

        return emissionStatusInfos;
    }

    public List<LandAreaEmissionInfo> getLandAreaEmissionInfos(){
        List<LandAreaEmissionInfo> landAreaEmissionInfos = new ArrayList<>();
        List<BsonDocument> pipeline = Arrays.asList(
                BsonDocument.parse("{ $unwind: \"$emissions\" }"),
                BsonDocument.parse("{ $group: { _id: \"$cityName\", landArea: { $first: \"$landArea\" }, latestReportingYear: { $max: \"$emissions.reportingYear\" }, totalEmissions: { $sum: { $cond: [ { $eq: [ \"$emissions.reportingYear\", { $max: \"$emissions.reportingYear\" } ] }, \"$emissions.totalEmissions\", 0 ] } } } }"),
                BsonDocument.parse("{ $project: { _id: 0, landArea: 1, totalEmissions: 1 } }")
        );

        cityCollection.aggregate(pipeline).forEach(document -> {
            Object landAreaTemp = document.get("landArea");

            double landArea = 0.0;

            if (landAreaTemp instanceof Integer) {
                landArea = ((Integer) landAreaTemp).doubleValue();
            } else if (landAreaTemp instanceof Double) {
                landArea = (Double) landAreaTemp;
            }
            Object totalEmissionsTemp = document.get("totalEmissions");

            double totalEmissions = 0.0;
            if (totalEmissionsTemp instanceof Integer) {
                totalEmissions = ((Integer) totalEmissionsTemp).doubleValue();
            } else if (totalEmissionsTemp instanceof Double) {
                totalEmissions = (Double) totalEmissionsTemp;
            }

            landAreaEmissionInfos.add(new LandAreaEmissionInfo(landArea,totalEmissions));
        });
        return landAreaEmissionInfos;

    }


    public AvgEmissionPerCitizenInfo getAvgEmissionsPerCitizenInfo(){
        List<CityPopulationEmissionInfo> cityPopulationEmissionInfos = new ArrayList<>();

        AtomicReference<Double> totalNonC40 = new AtomicReference<>(0.0);
        AtomicReference<Double> totalC40 = new AtomicReference<>(0.0);

        List<BsonDocument> pipeline = Arrays.asList(
                BsonDocument.parse("{\n" +
                        "        $match: {\n" +
                        "            $or: [\n" +
                        "                { c40: true },\n" +
                        "                { c40: false }\n" +
                        "            ]\n" +
                        "        }\n" +
                        "    }"),
                BsonDocument.parse("{\n" +
                        "        $group: {\n" +
                        "            _id: \"$c40\",\n" +
                        "            totalEmissions: { $sum: { $last: \"$emissions.totalEmissions\" } },\n" +
                        "            totalPopulation: { $sum: { $last: \"$populations.amount\" } }\n" +
                        "        }\n" +
                        "    }")
        );

        cityCollection.aggregate(pipeline)
        .forEach(document ->{
            boolean c40 = document.getBoolean("_id");

            Object totalEmissionsTemp = document.getDouble("totalEmissions");
            double totalEmissions = 0.0;
            if (totalEmissionsTemp instanceof Integer) {
                totalEmissions = ((Integer) totalEmissionsTemp).doubleValue();
            } else if (totalEmissionsTemp instanceof Double) {
                totalEmissions = (Double) totalEmissionsTemp;
            }

            double totalPopulation = document.getInteger("totalPopulation").doubleValue();


            if(c40){
                totalC40.set(totalEmissions / totalPopulation);
            }else{
                totalNonC40.set( totalEmissions / totalPopulation);
            }
        });


        return new AvgEmissionPerCitizenInfo(totalC40.get(),totalNonC40.get());
    }


}
