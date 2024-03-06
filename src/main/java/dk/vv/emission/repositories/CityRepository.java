package dk.vv.emission.repositories;

import dk.vv.emission.dtos.*;
import dk.vv.emission.pojos.City;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CityRepository {

    private EntityManager masterEntityManager;
    private EntityManager slaveEntityManager;


    public CityRepository(EntityManager masterEntityManager, EntityManager slaveEntityManager) {
        this.masterEntityManager = masterEntityManager;
        this.slaveEntityManager = slaveEntityManager;
    }

    public List<CityDTO> getCitiesWithAvgTemp(){
        return slaveEntityManager.createQuery("Select new dk.vv.emission.dtos.CityDTO(c.id,c.cityName,c.averageAnnualTemperature) " +
                "From City c where c.averageAnnualTemperature is not null", CityDTO.class).getResultList();
    }

    public List<CountryAvgEmissionInfo> getAverageEmissionsByCountry(){
        return slaveEntityManager.createQuery("SELECT new dk.vv.emission.dtos.CountryAvgEmissionInfo( co.countryName,\n" +
                "    avg(e.totalEmissions) )" +
                "   FROM City c\n" +
                "     JOIN Emission e ON c.id = e.city.id\n" +
                "     JOIN Country co ON c.country.id = co.id\n" +
                "  GROUP BY co.countryName\n" +
                "  ORDER BY (avg(e.totalEmissions))", CountryAvgEmissionInfo.class).getResultList();
    }

    public List<CityTargetInformation> getCitiesWithCO2NeutralTargets(){
        return slaveEntityManager.createQuery("SELECT new dk.vv.emission.dtos.CityTargetInformation(et.percentageReductionTarget, ci.cityName,et.targetYear) from City ci\n" +
                "  join EmissionTarget et on ci.id = et.city.id\n" +
                "  where et.percentageReductionTarget = 100", CityTargetInformation.class).getResultList();
    }

    public List<AvgTargetInformation> getAverageForCitesAndIsC40(){
        return slaveEntityManager.createQuery("SELECT new dk.vv.emission.dtos.AvgTargetInformation(c.c40,AVG(et.percentageReductionTarget))\n" +
                "FROM EmissionTarget et\n" +
                "JOIN City c ON et.city.id = c.id\n" +
                "GROUP BY c.c40\n", AvgTargetInformation.class).getResultList();
    }

    public List<CityPopulationEmissionInfo> getCityEmissionsAndPopulation(){
        return slaveEntityManager.createQuery("select new dk.vv.emission.dtos.CityPopulationEmissionInfo(c.c40, cp.populationAmount, e.totalEmissions)\n" +
                "from City c\n" +
                "join Emission e on c.id = e.city.id \n" +
                "JOIN CityPopulation cp ON c.id = cp.city.id\n" +
                "where e.totalEmissions is not null", CityPopulationEmissionInfo.class).getResultList();
    }

    public List<CountryAvgTargetInfo> getCountryAvgTargetInfos(){
        return slaveEntityManager.createQuery("SELECT new dk.vv.emission.dtos.CountryAvgEmissionInfo(co.countryName, AVG(e.percentageReductionTarget))\n" +
                "FROM City ci\n" +
                "JOIN EmissionTarget e ON e.city.id = ci.id\n" +
                "JOIN Country co ON ci.country.id = co.id\n" +
                "WHERE e.percentageReductionTarget IS NOT NULL\n" +
                "GROUP BY co.countryName",CountryAvgTargetInfo.class).getResultList();
    }


    public List<LandAreaEmissionInfo> getLandAreaEmissionInfos(){
        return slaveEntityManager.createQuery("\n" +
                "SELECT new dk.vv.emission.dtos.LandAreaEmissionInfo(ci.landArea, MAX(e.totalEmissions)) \n" +
                "FROM City ci\n" +
                "JOIN Emission e ON e.city.id = ci.id\n" +
                "WHERE ci.landArea IS NOT NULL AND e.totalEmissions IS NOT NULL \n" +
                "GROUP BY ci.id, ci.landArea",LandAreaEmissionInfo.class).getResultList();
    }

}
