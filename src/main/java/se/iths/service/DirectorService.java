package se.iths.service;

import se.iths.entity.Actor;
import se.iths.entity.Director;
import se.iths.entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
public class DirectorService {

    @PersistenceContext
    EntityManager entityManager;

    public Director createDirector(Director director) {
        entityManager.persist(director);
        return director;
    }

    public Director updateDirector(Director director) {
        entityManager.merge(director);
        return director;
    }

    public Director updateDirector2(Director director, Long id) {
        Director updateThisDirector = entityManager.find(Director.class, id);
        updateThisDirector.setFirstName(director.getFirstName());
        // osv

        return director;
    }

    public List<Director> getAllDirectors() {
        String query = "SELECT d from Director d";
        return entityManager.createQuery(query, Director.class).getResultList();
    }

    public void deleteDirector(Long id) {
        Director deleteThisDirector = entityManager.find(Director.class, id);
        entityManager.remove(deleteThisDirector);
    }

    public Set<Actor> findActorsFromSpecificMovieWithDirector(String directorsLastname, String movieTitle) {
        Movie movie = (Movie) entityManager
                .createQuery("SELECT DISTINCT m FROM Movie m INNER JOIN FETCH m.director d INNER JOIN FETCH m.actors a WHERE d.lastName = :directorsLastname AND m.title = :movieTitle")
                .setParameter("directorsLastname", directorsLastname).setParameter("movieTitle", movieTitle).getSingleResult();

        Set<Actor> actorResult = movie.getActors();
        return actorResult;
    }
}