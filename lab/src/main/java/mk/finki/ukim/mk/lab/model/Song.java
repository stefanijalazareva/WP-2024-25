package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Entity
@NoArgsConstructor
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackId;
    private String title;
    private String genre;
    private int releaseYear;
    @ManyToMany
    private List<Artist> performers;
    @ManyToOne
    private Album album;
    private int views = 1;

    public Song(String title, String genre, int releaseYear, List<Artist> performers, Album album) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
    }

    public Song(String title, String genre, int releaseYear, Album album) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album = album;
        this.performers = new ArrayList<>();
    }

    public Artist addArtist(Artist artist) {
        performers.add(artist);
        return artist;
    }

//    public int getViews() {
//        return views++;
//    }
}
