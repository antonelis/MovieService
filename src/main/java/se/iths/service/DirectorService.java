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

    public void createDirector(Director director) {
        entityManager.persist(director);
    }

    public void updateDirector(Director director) {
        entityManager.merge(director);
    }

    public void deleteDirectorById(Long id) {
        Director deleteThisDirector = entityManager.find(Director.class, id);
        entityManager.remove(deleteThisDirector);
    }

    public Director findDirectorById(Long id) {
        return entityManager.find(Director.class, id);
    }
    public List<Director> getAllDirectors() {
        String query = "SELECT d from Director d";
        return entityManager.createQuery(query, Director.class).getResultList();
    }

    public Set<Actor> findActorsFromSpecificMovieWithDirector(String directorsLastname, String movieTitle) {
        Movie movie = (Movie) entityManager
                .createQuery("SELECT DISTINCT m FROM Movie m INNER JOIN FETCH m.director d INNER JOIN FETCH m.actors a WHERE d.lastName = :directorsLastname AND m.title = :movieTitle")
                .setParameter("directorsLastname", directorsLastname).setParameter("movieTitle", movieTitle).getSingleResult();

        Set<Actor> actorResult = movie.getActors();
        return actorResult;
    }
}