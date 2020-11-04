package se.iths.rest;

import se.iths.entity.Movie;
import se.iths.service.MovieService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("movie")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieRest {

    @Inject
    MovieService movieService;

    @Path("new")
    @POST
    public Response createItem(Movie movie) {
        movieService.createItem(movie);
        return Response.ok(movie).build();
    }

    @Path("update")
    @PUT
    public Response updateItem(Movie movie) {
        movieService.updateItem(movie);
        return Response.ok(movie).build();
    }

    @Path("{id}")
    @GET
    public Movie getItem(@PathParam("id") Long id) {
        return movieService.findItemById(id);
    }


    @Path("getall")
    @GET
    public List<Movie> getAllItems() {
        return movieService.getAllItems();
    }


}
