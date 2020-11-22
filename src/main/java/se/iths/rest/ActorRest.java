package se.iths.rest;

import se.iths.entity.Director;
import se.iths.service.ActorService;
import se.iths.entity.Actor;

import javax.inject.Inject;
import javax.json.stream.JsonParsingException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("actor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ActorRest {

    @Inject
    ActorService actorService;


    @Path("new")
    @POST
    public Response createActor(Actor actor) {
        try {
            actorService.createActor(actor);
            return Response.ok(actor).build();
        } catch (JsonParsingException j) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("update")
    @PUT
    public Response updateActor(Actor actor) {
        try {
            actorService.updateActor(actor);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("getall")
    @GET
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @Path("{id}")
    @DELETE
    public Response deleteActor(@PathParam("id") Long id) {
        Actor foundActor = actorService.findActorById(id);
        if (foundActor != null) {
            actorService.deleteActor(id);
            return Response.ok().entity("Director with ID " + id + " was successfully deleted.").type(MediaType.TEXT_PLAIN).build();
        } else {
            throw new NotFoundException("Director with ID " + id + " not found.");
        }
    }

}