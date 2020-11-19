package se.iths.util;
import se.iths.entity.Actor;
import se.iths.entity.Director;
import se.iths.entity.Movie;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {
        entityManager.persist(new Movie("The Fast and the Furious", "Action", "160 min", 2001));
        entityManager.persist(new Movie("Fight Club", "Drama",  "139 min", 1999));
        entityManager.persist(new Movie("Pulp Fiction", "Crime", "154 min", 1994));
        entityManager.persist(new Movie("Matrix", "Sci-Fi", "136 min", 1999));
        entityManager.persist(new Movie("Parasite", "Drama", "132 min", 2019));
        entityManager.persist(new Actor("Paul", " Walker", "September 12"));
        entityManager.persist(new Actor("Vin", " Diesel", "July 18"));
        entityManager.persist(new Director("Rob","Cohen"," March 12"));
    }


}