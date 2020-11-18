package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String category;
    @NotEmpty
    private String runningTime;
    private int releaseYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToMany(mappedBy = "movies")
    private Set<Actor> actors = new HashSet<>();


    public Movie(@NotEmpty String title, @NotEmpty String category, @NotEmpty String runningTime, int releaseYear) {
        this.title = title;
        this.category = category;
        this.runningTime = runningTime;
        this.releaseYear = releaseYear;
    }

    public Movie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }
}