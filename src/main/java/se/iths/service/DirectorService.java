package se.iths.service;

import se.iths.entity.Director;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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


}