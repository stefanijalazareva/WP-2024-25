package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.jpa.AlbumJPARepository;
import mk.finki.ukim.mk.lab.repository.jpa.ArtistJPARepository;
import mk.finki.ukim.mk.lab.repository.jpa.SongJPARepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists = null;
    public static List<Song> songs = null;
    public static List<Album> albums = null;
    private final ArtistJPARepository artistRepository;
    private final SongJPARepository songRepository;
    private final AlbumJPARepository albumRepository;

    public DataHolder(ArtistJPARepository artistRepository, SongJPARepository songRepository, AlbumJPARepository albumRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @PostConstruct
    @Transactional
    public void init() {
        if (artistRepository.count() == 0) {
            artists = new ArrayList<>();
            artists.add(new Artist("Bon", "Jovi",
                    "Success is falling nine times and getting up ten."));
            artists.add(new Artist("Red Hot", "Chilli Peppers",
                    "I'll make it to the moon if I have to crawl"));
            artists.add(new Artist("Green", "Day",
                    "Are you scared to death to live?"));
            artists.add(new Artist("The", "Beatles",
                    "In the end, the love you take is equal to the love you make."));
            artists.add(new Artist("The", "Police",
                    "One of the rewards of success is freedom, the ability to do whatever you like."));
            artistRepository.saveAll(artists);
        }

        if (albumRepository.count() == 0) {
            albums = new ArrayList<>();
            albums.add(new Album("Album1", "Pop rock", "1969"));
            albums.add(new Album("Album2", "Rock", "2004"));
            albums.add(new Album("Album3", "Alternative Rock", "1997"));
            albums.add(new Album("Album4", "Alternative/Idile", "1999"));
            albums.add(new Album("Album5", "Soft Rock", "1983"));
            albumRepository.saveAll(albums);
        }

        if (songRepository.count() == 0) {
            songs = new ArrayList<>();
            songs.add(new Song("You give a love bad name", "Rock", 1986, new ArrayList<>(List.of(artists.get(0))), albums.get(1)));
            songs.add(new Song("Californication", "Alternative/Idile", 1999, new ArrayList<>(List.of(artists.get(1))), albums.get(3)));
            songs.add(new Song("Good Riddance", "Alternative rock", 1997, new ArrayList<>(List.of(artists.get(2))), albums.get(2)));
            songs.add(new Song("Boulevard of broken dreams", "Hard Rock", 2004, new ArrayList<>(List.of(artists.get(2))), albums.get(1)));
            songs.add(new Song("Every breath you take", "Soft Rock", 1983, new ArrayList<>(List.of(artists.get(4))), albums.get(4)));
            songs.add(new Song("Here comes the sun", "Pop Rock", 1969, new ArrayList<>(List.of(artists.get(3))), albums.get(0)));
            songRepository.saveAll(songs);
        }
    }
}
