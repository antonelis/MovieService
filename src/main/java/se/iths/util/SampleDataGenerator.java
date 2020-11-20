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
        Movie movie2 = new Movie("Fight Club", "Drama", "139 min", 1999);
        Movie movie3 = new Movie("Pulp Fiction", "Crime", "154 min", 1994);
        Movie movie4 = new Movie("Matrix", "Sci-Fi", "136 min", 1999);
        Movie movie5 = new Movie("Speed", "Action", "116 min", 1994);
        Movie movie6 = new Movie("American History X", "Drama", "119 min", 1998);
        Movie movie7 = new Movie("From Dusk Till Dawn", "Action", "108 min", 1996);

        Actor actor1 = new Actor("Paul", "Walker", "September 12");
        Actor actor2 = new Actor("Vin", "Diesel", "July 18");
        Actor actor3 = new Actor("Edward", "Norton", "August 18");
        Actor actor4 = new Actor("Bruce", "Willis", "March 19");
        Actor actor5 = new Actor("Keanu", "Reeves", "March 19");
        Actor actor6 = new Actor("George", "Clooney", "May 6");

        Director director1 = new Director("Rob", "Cohen", "March 12");
        Director director2 = new Director("David", "Fincher", "August 28");
        Director director3 = new Director("Quentin", "Tarantino", "March 27");
        Director director4 = new Director("Brothers", "Wachowski", "June 21");
        Director director5 = new Director("Jan", "de Bont", "October 22");
        Director director6 = new Director("Tony", "Kaye", "July 8");

        actor1.addMovie(movie1);
        actor2.addMovie(movie1);
        actor3.addMovie(movie2);
        actor3.addMovie(movie6);
        actor4.addMovie(movie3);
        actor5.addMovie(movie4);
        actor5.addMovie(movie5);
        actor6.addMovie(movie7);

        director1.addMovie(movie1);
        director2.addMovie(movie2);
        director3.addMovie(movie3);
        director3.addMovie(movie7);
        director4.addMovie(movie4);
        director5.addMovie(movie5);
        director6.addMovie(movie6);

        entityManager.persist(actor1);
        entityManager.persist(actor2);
        entityManager.persist(actor3);
        entityManager.persist(actor4);
        entityManager.persist(actor5);
        entityManager.persist(actor6);

        entityManager.persist(director1);
        entityManager.persist(director2);
        entityManager.persist(director3);
        entityManager.persist(director4);
        entityManager.persist(director5);
        entityManager.persist(director6);
    }

}