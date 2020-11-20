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

    public Actor createActor(Actor actor) {
        entityManager.persist(actor);
        return actor;
    }

    public Actor updateActor(Actor actor) {
        entityManager.merge(actor);
        return actor;
    }

    public Actor updateActor2(Actor actor, Long id) {
        Actor updateThisActor = entityManager.find(Actor.class, id);
        updateThisActor.setFirstName(actor.getFirstName());
        // osv

        return actor;
    }

    public List<Actor> getAllActors() {
        String query = "SELECT a FROM Actor a";
        return entityManager.createQuery(query, Actor.class).getResultList();
    }

    public void deleteActor(Long id) {
        Actor deleteThisActor = entityManager.find(Actor.class, id);
        entityManager.remove(deleteThisActor);
    }
}