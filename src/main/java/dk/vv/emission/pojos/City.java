//package dk.vv.emission.pojos;
//
//
//
//import io.quarkus.mongodb.panache.PanacheMongoEntity;
//import io.quarkus.mongodb.panache.common.MongoEntity;
//import org.bson.types.ObjectId;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@MongoEntity(collection = "cities")
//public class City extends PanacheMongoEntity {
//    public ObjectId id;
//    public String cityName;
//    public ObjectId countryId;
//    public String cityLocation;
//    public Double averageAnnualTemperature;
//    public Boolean c40;
//    public Integer landArea;
//    public Boolean gcom;
//    public List<EmissionTarget> emissionTargets;
//    public List<Emission> emissions;
//    public List<GDP> gdps;
//    public List<Population> populations;
//    // You may need to add more fields as per your document structure
//
//
//    public City() {
//    }
//
//    public ObjectId getId() {
//        return id;
//    }
//
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    public String getCityName() {
//        return cityName;
//    }
//
//    public void setCityName(String cityName) {
//        this.cityName = cityName;
//    }
//
//    public ObjectId getCountryId() {
//        return countryId;
//    }
//
//    public void setCountryId(ObjectId countryId) {
//        this.countryId = countryId;
//    }
//
//    public String getCityLocation() {
//        return cityLocation;
//    }
//
//    public void setCityLocation(String cityLocation) {
//        this.cityLocation = cityLocation;
//    }
//
//    public Double getAverageAnnualTemperature() {
//        return averageAnnualTemperature;
//    }
//
//    public void setAverageAnnualTemperature(Double averageAnnualTemperature) {
//        this.averageAnnualTemperature = averageAnnualTemperature;
//    }
//
//    public Boolean getC40() {
//        return c40;
//    }
//
//    public void setC40(Boolean c40) {
//        this.c40 = c40;
//    }
//
//    public Integer getLandArea() {
//        return landArea;
//    }
//
//    public void setLandArea(Integer landArea) {
//        this.landArea = landArea;
//    }
//
//    public Boolean getGcom() {
//        return gcom;
//    }
//
//    public void setGcom(Boolean gcom) {
//        this.gcom = gcom;
//    }
//
//    public List<EmissionTarget> getEmissionTargets() {
//        return emissionTargets;
//    }
//
//    public void setEmissionTargets(List<EmissionTarget> emissionTargets) {
//        this.emissionTargets = emissionTargets;
//    }
//
//    public List<Emission> getEmissions() {
//        return emissions;
//    }
//
//    public void setEmissions(List<Emission> emissions) {
//        this.emissions = emissions;
//    }
//
//    public List<GDP> getGdps() {
//        return gdps;
//    }
//
//    public void setGdps(List<GDP> gdps) {
//        this.gdps = gdps;
//    }
//
//    public List<Population> getPopulations() {
//        return populations;
//    }
//
//    public void setPopulations(List<Population> populations) {
//        this.populations = populations;
//    }
//}