package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.model.exceptions.SongNotFoundException;
import mk.finki.ukim.mk.lab.repository.AlbumRepository;
import mk.finki.ukim.mk.lab.repository.ArtistRepository;
import mk.finki.ukim.mk.lab.repository.SongRepository;
import mk.finki.ukim.mk.lab.service.AlbumService;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongServiceImplementation implements SongService {
    private final SongRepository songRepository;
    private final ArtistService artistService;
    private final AlbumService albumService;

    public SongServiceImplementation(SongRepository songRepository, ArtistService artistService, AlbumService albumService) {
        this.songRepository = songRepository;
        this.artistService = artistService;
        this.albumService = albumService;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Long artistId, Long trackId) {
        Artist artist = artistService.findById(artistId);
        return songRepository.addArtistToSong(artist, trackId);
    }

    @Override
    public Song findByTrackId(Long trackId) {
        Song song = songRepository.findByTrackId(trackId).orElse(null);
        if(song == null) {
            throw new SongNotFoundException(trackId);
        }
        return song;
    }

    @Override
    public Song addSong(String title, String genre, int releaseYear, Long albumId) {
        if(title.isEmpty() || genre.isEmpty() || albumId == null) {
            return null;
        }
        Album album = albumService.findByAlbumId(albumId);
        return songRepository.addSong(title, genre, releaseYear, album);
    }

    @Override
    public List<Song> findTitleBySubstring(String string) {
        return songRepository.findBySubstring(string).stream().collect(Collectors.toList());
    }

    @Override
    public Song editSong(Long trackId, String title, String genre, int releaseYear, Long albumId) {
        Album album = albumService.findByAlbumId(albumId);
        return songRepository.editSong(trackId, title, genre, releaseYear, album);
    }

    @Override
    public boolean deleteSong(Long trackId) {
        return songRepository.deleteSong(trackId);
    }

    @Override
    public int getViews(Long trackId) {
        return songRepository.getViews(trackId);
    }

}
