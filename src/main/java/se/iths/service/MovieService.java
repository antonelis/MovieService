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

    public void createMovie(Movie movie) {
        entityManager.persist(movie);
    }

    public void updateMovie(Movie movie) {
        entityManager.merge(movie);
    }

    public void deleteMovieById(Long id){
        Movie deleteThisMovie = entityManager.find(Movie.class, id);
        entityManager.remove(deleteThisMovie);
    }

    public Movie findMovieById(Long id) {
        return entityManager.find(Movie.class, id);
    }

    public List<Movie> getAllMovies() {
        return entityManager.createQuery("select m from Movie m", Movie.class).getResultList();
    }

    public List<Movie> findMovieByCategory(String category) {
        return entityManager.createQuery("SELECT p FROM Movie p WHERE p.category = '" + category + "'", Movie.class).getResultList();
    }

    public List<Movie> getAllMoviesSortedByCategory() {
        String query = "SELECT m FROM Movie m ORDER BY m.category";
        return entityManager.createQuery(query, Movie.class).getResultList();
    }

    public List<Movie> getAllMoviesByReleaseYears(int minyear, int maxyear) {
        String query = "SELECT m FROM Movie m WHERE m.releaseYear BETWEEN :minyear AND :maxyear";
        return entityManager.createQuery(query, Movie.class).setParameter("minyear", minyear)
                .setParameter("maxyear", maxyear).getResultList();
    }
}