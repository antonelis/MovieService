package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Actor {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String firstName;
    private String lastName;
    private String birthday;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Movie> movies = new HashSet<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
        movie.getActors().add(this);
    }

    public Actor(@NotEmpty String firstName, String lastName, String birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public Actor() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String email) {
        this.birthday = email;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

}