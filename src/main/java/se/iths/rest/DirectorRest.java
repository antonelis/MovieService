package se.iths.rest;

import se.iths.service.DirectorService;
import se.iths.entity.Director;

import javax.inject.Inject;
import javax.json.stream.JsonParsingException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("director")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
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

    @Path("{id}")
    @DELETE
    public Response deleteDirector(@PathParam("id") Long id) {
        directorService.deleteDirector
                (id);
        return Response.ok().entity("Director with ID " + id + " was successfully deleted.").build();
    }

}