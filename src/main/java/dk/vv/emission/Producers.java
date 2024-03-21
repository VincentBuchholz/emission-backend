package dk.vv.emission;
//
import com.mongodb.client.MongoClient;
import dk.vv.emission.repositories.CityService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
//import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceUnit;

@ApplicationScoped
public class Producers {


    @Inject
    MongoClient mongoClient;

    @Produces
    CityService getCityService(){
        return new CityService(mongoClient);
    }

//    @Inject
//    EntityManager masterEntityManager;
//
//    @Inject
//    @PersistenceUnit(name = "slave")
//    EntityManager slaveEntityManager;
//
//
//    @Produces
//    public CityRepository getCityRepo() {
//        return new CityRepository(masterEntityManager,slaveEntityManager);
//    }
//
//    @Produces
//    public CityGDPRepository getCityGDPRepo() {
//        return new CityGDPRepository(masterEntityManager,slaveEntityManager);
//    }
//
//    @Produces
//    public EmissionRepository getEmissionRepo() {
//        return new EmissionRepository(masterEntityManager,slaveEntityManager);
//    }
//
//
//    @Produces
//    public EmissionTargetRepository getEmissionTargetRepo() {
//        return new EmissionTargetRepository(masterEntityManager,slaveEntityManager);
//    }
//
}
