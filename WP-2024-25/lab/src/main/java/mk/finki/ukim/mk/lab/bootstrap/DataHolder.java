package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists = new ArrayList<>();
    public static List<Song> songs = new ArrayList<>();

    @PostConstruct
    public void init() {
        artists.add(new Artist(1L, "Bon", "Jovi",
                "Success is falling nine times and getting up ten."));
        artists.add(new Artist(27L, "Red Hot", "Chilli Peppers",
                "I'll make it to the moon if I have to crawl"));
        artists.add(new Artist(6L, "Green", "Day",
                "Are you scared to death to live?"));
        artists.add(new Artist(34L, "The", "Beatles",
                "In the end, the love you take is equal to the love you make."));
        artists.add(new Artist(19L, "The", "Police",
                "One of the rewards of success is freedom, the ability to do whatever you like."));

        songs.add(new Song("BJ", "You give a love bad name", "Rock", 1986));
        songs.add(new Song("rhcp", "Californication", "Alternative/Idile", 1999));
        songs.add(new Song("Gd", "Good Riddance", "Alternative rock", 1997));
        songs.add(new Song("M", "Nothing Else Matters", "Metal", 1991));
        songs.add(new Song("AbbA", "Dancing queen", "Pop", 1976));
        songs.add(new Song("SG", "Love you like a love song", "Pop", 1976));
    }
}
