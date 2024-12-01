package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Song {
    private Long trackId;
    private String title;
    private String genre;
    private int releaseYear;
    private List<Artist> performers;
    private Album album;
    private int views = 1;

    public Song(String title, String genre, int releaseYear, List<Artist> performers, Album album) {
        Random random = new Random();
        this.trackId = random.nextLong(1000, 9999);
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
    }

    public Song(String title, String genre, int releaseYear, Album album) {
        Random random = new Random();
        this.trackId = random.nextLong(1000, 9999);
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album = album;
        this.performers = new ArrayList<>();
    }

    public Artist addPerformer(Artist performer) {
        performers.add(performer);
        return performer;
    }

    public int getViews() {
        return views++;
    }
}
