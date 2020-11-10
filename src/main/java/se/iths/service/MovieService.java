package se.iths.service;

import se.iths.entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class MovieService {

    @PersistenceContext
    EntityManager entityManager;

    public Movie createItem(Movie movie) {
        entityManager.persist(movie);
        return movie;
    }

    public Movie updateItem(Movie movie) {
        entityManager.merge(movie);
        return movie;
    }

    public void deleteItemById(Long id){
        Movie deleteThisMovie = entityManager.find(Movie.class, id);
        entityManager.remove(deleteThisMovie);
    }

    public Movie findItemById(Long id) {
        return entityManager.find(Movie.class, id);
    }

    public List<Movie> getAllItems() {
        return entityManager.createQuery("select m from Movie m", Movie.class).getResultList();
    }

    public List<Movie> findItemByName(String name) {
        return entityManager.createQuery("SELECT p FROM Movie p WHERE p.name = \'" + name + "\'", Movie.class).getResultList();
    }
}