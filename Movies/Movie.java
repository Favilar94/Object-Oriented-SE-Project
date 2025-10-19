package movies;

import java.time.LocalDate;

public abstract class Movie {
    private String title;
    private LocalDate releaseDate;

    public Movie(String title, LocalDate releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return this.title;
    }
    
    public LocalDate getReleaseDate(){
        return this.releaseDate;
    }

}
