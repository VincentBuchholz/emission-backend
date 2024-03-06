package dk.vv.emission.repositories;

import dk.vv.emission.pojos.City;
import dk.vv.emission.pojos.CityGDP;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CityGDPRepository {

    private EntityManager masterEntityManager;
    private EntityManager slaveEntityManager;


    public CityGDPRepository(EntityManager masterEntityManager, EntityManager slaveEntityManager) {
        this.masterEntityManager = masterEntityManager;
        this.slaveEntityManager = slaveEntityManager;
    }

    List<CityGDP> getNewestGdps(){

        var query = slaveEntityManager.createQuery("SELECT c\n" +
                "FROM CityGDP c\n" +
                "WHERE (c.city.id, c.gdpYear) IN (\n" +
                "    SELECT cg.city.id, MAX(cg.gdpYear)\n" +
                "    FROM CityGDP cg\n" +
                "    GROUP BY cg.city.id\n" +
                ")\n" +
                "ORDER BY c.city.id, c.gdpYear DESC", CityGDP.class);

        return query.getResultList();
    }


}
