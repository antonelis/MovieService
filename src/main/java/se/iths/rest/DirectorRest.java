package se.iths.rest;

import se.iths.entity.Actor;
import se.iths.entity.Movie;
import se.iths.service.DirectorService;
import se.iths.entity.Director;

import javax.inject.Inject;
import javax.json.stream.JsonParsingException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("director")
public class DirectorRest {

    @Inject
    DirectorService directorService;


    @Path("new")
    @POST
    public Response createDirector(Director director) {
        try {
            directorService.createDirector(director);
            return Response.ok(director).build();
        } catch (JsonParsingException j) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("update")
    @PUT
    public Response updateDirector(Director director) {
        try {
            directorService.updateDirector(director);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("getall")
    @GET
    public List<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    //TODO Check if you can fix this

    @Path("{id}")
    @DELETE
    public Response deleteDirector(@PathParam("id") Long id) {
        Director foundDirector = directorService.findDirectorById(id);
        if (foundDirector != null) {
            directorService.deleteDirectorById(id);
            return Response.ok().entity("Director with ID " + id + " was successfully deleted.").type(MediaType.TEXT_PLAIN).build();
        } else {
            throw new NotFoundException("Director with ID " + id + " not found.");
        }
    }

    @Path("getactorsformovie/{directorsLastname}/{movieTitle}")
    @GET
    public Set<Actor> getSpecificActorWithDirectorAndMovieTitle(@PathParam("directorsLastname") String directorsLastname, @PathParam("movieTitle") String movieTitle) {
        Set<Actor> foundActor = directorService.findActorsFromSpecificMovieWithDirector(directorsLastname, movieTitle);
        if (foundActor != null) {
            return directorService.findActorsFromSpecificMovieWithDirector(directorsLastname, movieTitle);
        } else {
            throw new NotFoundException("Actor with directors" + directorsLastname + " from movie " + movieTitle + " not found.");
        }

    }

}