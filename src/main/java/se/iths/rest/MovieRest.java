package se.iths.rest;

import se.iths.entity.Movie;
import se.iths.service.MovieService;

import javax.inject.Inject;
import javax.json.stream.JsonParsingException;
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
        try {
            movieService.createMovie(movie);
            return Response.ok(movie).build();
        } catch (JsonParsingException j) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("update")
    @PUT
    public Response updateMovie(Movie movie) {
        try {
            movieService.updateMovie(movie);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
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
        if (!foundMovie.isEmpty()) {
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
    public Response deleteMovie(@PathParam("id") Long id) {
        Movie foundMovie = movieService.findMovieById(id);
        if (foundMovie != null) {
            movieService.deleteMovieById(id);
            return Response.ok().entity("Movie with ID " + id + " deleted.").build();
        } else {
            throw new MovieNotFoundException("Movie with ID " + id + " not found.");
        }
    }

    @Path("sortedbycategory")
    @GET
    public List<Movie> getSortedByCategory() {
        return movieService.getAllMoviesSortedByCategory();
    }

    @Path("byreleaseyears/{minyear}/{maxyear}")
    @GET
    public List<Movie> getByReleaseYears(@PathParam("minyear") int minyear, @PathParam("maxyear") int maxyear) {
        List<Movie> foundMovie = movieService.getAllMoviesByReleaseYears(minyear,maxyear);
        if (!foundMovie.isEmpty()) {
            return movieService.getAllMoviesByReleaseYears(minyear, maxyear);
        } else {
            throw new MovieNotFoundException("Movie with release years between " + minyear + " and " + maxyear + " not found.");
        }
    }
}
