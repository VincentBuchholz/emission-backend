//package dk.vv.emission.repositories;
//
//import dk.vv.emission.dtos.EmissionDTO;
//import dk.vv.emission.dtos.EmissionStatusInfo;
//import dk.vv.emission.pojos.City;
//import dk.vv.emission.pojos.Emission;
//import io.quarkus.hibernate.orm.panache.PanacheRepository;
//import jakarta.persistence.EntityManager;
//
//import java.util.List;
//
//public class EmissionRepository {
//
//    private EntityManager masterEntityManager;
//    private EntityManager slaveEntityManager;
//
//    public EmissionRepository(EntityManager masterEntityManager, EntityManager slaveEntityManager) {
//        this.masterEntityManager = masterEntityManager;
//        this.slaveEntityManager = slaveEntityManager;
//    }
//
//    public List<EmissionDTO> getEmissionAndCityId(){
//        return slaveEntityManager.createQuery("select new dk.vv.emission.dtos.EmissionDTO(e.totalEmissions,e.city.id) from Emission e " +
//                "where e.totalEmissions is not null", EmissionDTO.class).getResultList();
//    }
//
//
//    public List<EmissionStatusInfo> getEmissionStatusInfo() {
//        return slaveEntityManager.createQuery("SELECT new dk.vv.emission.dtos.EmissionStatusInfo(" +
//                "    e.reportingYear," +
//                "    COUNT(*)," +
//                "    COUNT(*) FILTER (WHERE e.emissionStatus.id = 2)," +
//                "    COUNT(*) FILTER (WHERE e.emissionStatus.id = 3))" +
//                "\n" +
//                "FROM \n" +
//                "    Emission e\n" +
//                "JOIN \n" +
//                "    EmissionStatus es ON e.emissionStatus.id = es.id\n" +
//                "GROUP BY \n" +
//                "    e.reportingYear\n" +
//                "ORDER BY \n" +
//                "    e.reportingYear", EmissionStatusInfo.class).getResultList();
//    }
//}
