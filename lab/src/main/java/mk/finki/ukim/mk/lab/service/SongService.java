package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Long artistId, Long trackId);
    Song findByTrackId(Long trackId);
    Song addSong(String title, String genre, int releaseYear, Long albumId);
    List<Song> findTitleBySubstring(String string);
    Song editSong(Long trackId, String title, String genre, int releaseYear, Long albumId);
    boolean deleteSong(Long trackId);
}
