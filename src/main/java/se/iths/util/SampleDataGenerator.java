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

        Movie movie1 = new Movie("The Fast and the Furious", "Action", "160 min", 2001);
        Movie movie2 = new Movie("Fight Club", "Drama",  "139 min", 1999);
        Movie movie3 = new Movie("Pulp Fiction", "Crime", "154 min", 1994);
        Movie movie4 = new Movie("Matrix", "Sci-Fi", "136 min", 1999);
        Movie movie5 = new Movie("Parasite", "Drama", "132 min", 2019);

        Actor actor1 = new Actor("Paul", " Walker", "September 12");
        Actor actor2 = new Actor("Vin", " Diesel", "July 18");

        Director director1 = new Director("Rob","Cohen"," March 12");

        actor1.addMovie(movie1);
        actor2.addMovie(movie1);
        director1.addMovie(movie1);

        entityManager.persist(actor1);
        entityManager.persist(actor2);
        entityManager.persist(director1);


       /* entityManager.persist(new Movie("The Fast and the Furious", "Action", "160 min", 2001));
        entityManager.persist(new Movie("Fight Club", "Drama",  "139 min", 1999));
        entityManager.persist(new Movie("Pulp Fiction", "Crime", "154 min", 1994));
        entityManager.persist(new Movie("Matrix", "Sci-Fi", "136 min", 1999));
        entityManager.persist(new Movie("Parasite", "Drama", "132 min", 2019));
        entityManager.persist(new Actor("Paul", " Walker", "September 12"));
        entityManager.persist(new Actor("Vin", " Diesel", "July 18"));
        entityManager.persist(new Director("Rob","Cohen"," March 12"));

        */
    }

}