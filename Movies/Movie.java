package movies;

import java.time.LocalDate;

public class Movie {
    private String title;
    private LocalDate releaseDate;
    private MovieTypes movieType;

    public Movie(String title, MovieTypes type, LocalDate releaseDate) {
        this.title = title;
        this.movieType = type;
        this.releaseDate = releaseDate;
    }

    public MovieTypes getMovieType() {
        return this.movieType;
    }

    public String getTitle() {
        return this.title;
    }
    
    public LocalDate getReleaseDate(){
        return this.releaseDate;
    }

}
