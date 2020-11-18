package se.iths.service;

import se.iths.entity.Actor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ActorService {

    @PersistenceContext
    EntityManager actorEntityManager;

    public Actor createActor(Actor actor) {
        actorEntityManager.persist(actor);
        return actor;
    }

    public Actor updateActor(Actor actor) {
        actorEntityManager.merge(actor);
        return actor;
    }

    public Actor updateActor2(Actor actor, Long id) {
        Actor updateThisActor = actorEntityManager.find(Actor.class, id);
        updateThisActor.setFirstName(actor.getFirstName());
        // osv

        return actor;
    }

    public List<Actor> getAllActors() {
        String query = "SELECT a from Actor a";
        return actorEntityManager.createQuery(query, Actor.class).getResultList();
    }

    public void deleteActor(Long id) {
        Actor deleteThisActor = actorEntityManager.find(Actor.class, id);
        actorEntityManager.remove(deleteThisActor);
    }



}