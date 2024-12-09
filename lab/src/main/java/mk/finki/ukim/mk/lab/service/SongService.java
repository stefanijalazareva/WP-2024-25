package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Long artistId, Long trackId);
    Song findByTrackId(Long trackId);
    Song addSong(String title, String genre, int releaseYear, Long albumId);
    Song editSong(Long trackId, String title, String genre, int releaseYear, Long albumId);
    List<Song> findAllByAlbum_Id(Long albumId);
    boolean deleteSong(Long trackId);
//    int getViews(Long trackId);
}
