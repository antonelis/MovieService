package se.iths.entity;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Movie {

    public Movie(@NotEmpty String title, @NotEmpty String category, @NotEmpty String runningTime, int releaseYear) {
        this.title = title;
        this.category = category;
        this.runningTime = runningTime;
        this.releaseYear = releaseYear;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String category;
    @NotEmpty
    private String runningTime;
    private int releaseYear;

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

}