package se.iths.service;

import se.iths.entity.Director;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DirectorService {

    @PersistenceContext
    EntityManager directorEntityManager;

    public Director createDirector(Director director) {
        directorEntityManager.persist(director);
        return director;
    }

    public Director updateDirector(Director director) {
        directorEntityManager.merge(director);
        return director;
    }

    public Director updateDirector2(Director director, Long id) {
        Director updateThisDirector = directorEntityManager.find(Director.class, id);
        updateThisDirector.setFirstName(director.getFirstName());
        // osv

        return director;
    }

    public List<Director> getAllDirectors() {
        String query = "SELECT d from Director d";
        return directorEntityManager.createQuery(query, Director.class).getResultList();
    }

    public void deleteDirector(Long id) {
        Director deleteThisDirector = directorEntityManager.find(Director.class, id);
        directorEntityManager.remove(deleteThisDirector);
    }


}