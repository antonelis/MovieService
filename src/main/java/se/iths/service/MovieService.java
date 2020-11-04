package se.iths.service;

import se.iths.entity.Movie;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.interceptor.InvocationContext;
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

    public Movie findItemById(Long id) {
        return entityManager.find(Movie.class, id);
    }

    public List<Movie> getAllItems() {
        return entityManager.createQuery("select m from Movie m", Movie.class).getResultList();
    }

}