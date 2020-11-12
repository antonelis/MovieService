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
    public Response createMovie(Movie movie) {
        movieService.createMovie(movie);
        return Response.ok(movie).build();
    }

    @Path("update")
    @PUT
    public Response updateMovie(Movie movie) {
        movieService.updateMovie(movie);
        return Response.ok(movie).build();
    }

    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public Response getMovie(@PathParam("id") Long id) {
        Movie foundMovie = movieService.findMovieById(id);
        if (foundMovie != null) {
            return Response.ok(foundMovie).build();
        } else {
           throw new MovieNotFoundException("Movie with ID " + id + " not found.");
        }
    }

    @Path("bycategory/{category}")
    @GET
    public List<Movie> getMoviesByCategory(@PathParam("category") String category) {
        List<Movie> foundMovie = movieService.findMovieByCategory(category);
        if (foundMovie != null) {
            return movieService.findMovieByCategory(category);
        } else {
            throw new MovieNotFoundException("Movie with category " + category + " not found.");
        }
    }

    @Path("getall")
    @GET
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @DELETE
    public Response deleteItem(@PathParam("id") Long id) {
        Movie foundMovie = movieService.findMovieById(id);
        if (foundMovie != null) {
            movieService.deleteMovieById(id);
            return Response.ok().entity("Movie with ID " + id + " deleted.").build();
        } else {
            throw new MovieNotFoundException("Movie with ID " + id + " not found.");
        }
    }
}
