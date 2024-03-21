//package dk.vv.emission.repositories;
//
//import dk.vv.emission.dtos.AvgReductionSectorInfo;
//import dk.vv.emission.dtos.CountryAvgEmissionInfo;
//import dk.vv.emission.pojos.City;
//import dk.vv.emission.pojos.EmissionTarget;
//import io.quarkus.hibernate.orm.panache.PanacheRepository;
//import jakarta.persistence.EntityManager;
//
//import java.util.List;
//
//public class EmissionTargetRepository{
//
//
//    private EntityManager masterEntityManager;
//    private EntityManager slaveEntityManager;
//
//    public EmissionTargetRepository(EntityManager masterEntityManager, EntityManager slaveEntityManager) {
//        this.masterEntityManager = masterEntityManager;
//        this.slaveEntityManager = slaveEntityManager;
//    }
//
//    public List<AvgReductionSectorInfo> getSectorsWithAvgReductionTarget(){
//        return slaveEntityManager.createQuery("SELECT new dk.vv.emission.dtos.AvgReductionSectorInfo( s.sectorName,\n" +
//                "    avg(et.percentageReductionTarget) )" +
//                "   FROM EmissionTarget et\n" +
//                "JOIN Sector s ON et.sectorId = s.id\n" +
//                "where et.percentageReductionTarget is not null\n" +
//                "GROUP BY s.id", AvgReductionSectorInfo.class).getResultList();
//    }
//
//}
