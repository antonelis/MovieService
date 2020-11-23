package se.iths.service;

import se.iths.entity.Actor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ActorService {

    @PersistenceContext
    EntityManager entityManager;

    public void createActor(Actor actor) {
        entityManager.persist(actor);
    }

    public void updateActor(Actor actor) {
        entityManager.merge(actor);
    }

    public List<Actor> getAllActors() {
        String query = "SELECT a FROM Actor a";
        return entityManager.createQuery(query, Actor.class).getResultList();
    }

    public Actor findActorById(Long id) {
        return entityManager.find(Actor.class, id);
    }

    public void deleteActor(Long id) {
        Actor deleteThisActor = entityManager.find(Actor.class, id);
        entityManager.remove(deleteThisActor);
    }
}