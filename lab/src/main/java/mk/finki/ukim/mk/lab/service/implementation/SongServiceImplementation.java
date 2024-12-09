package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.model.exceptions.SongNotFoundException;
import mk.finki.ukim.mk.lab.repository.jpa.SongJPARepository;
import mk.finki.ukim.mk.lab.service.AlbumService;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongServiceImplementation implements SongService {
    private final SongJPARepository songRepository;
    private final ArtistService artistService;
    private final AlbumService albumService;

    public SongServiceImplementation(SongJPARepository songRepository, ArtistService artistService, AlbumService albumService) {
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
        Song song = songRepository.findById(trackId).orElse(null);
        if(song == null) {
            throw new SongNotFoundException(trackId);
        }
        Artist artist = artistService.findById(artistId);
        song.addArtist(artist);
        songRepository.save(song);
        return artist;
    }

    @Override
    public Song findByTrackId(Long trackId) {
        Song song = songRepository.findById(trackId).orElse(null);
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
        Song song = new Song(title, genre, releaseYear, album);
        return songRepository.save(song);
    }

    @Override
    public Song editSong(Long trackId, String title, String genre, int releaseYear, Long albumId) {
        Album album = albumService.findByAlbumId(albumId);
        Song song =songRepository.findById(trackId).orElse(null);
        if (song == null) {
            throw new SongNotFoundException(trackId);
        }
        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(album);
        return songRepository.save(song);
    }

    @Override
    public boolean deleteSong(Long trackId) {
        songRepository.deleteById(trackId);
        return true;
    }

    @Override
    public List<Song> findAllByAlbum_Id(Long albumId) {
        return songRepository.findAllByAlbum_Id(albumId);
    }

//    @Override
//    public int getViews(Long trackId) {
//        return songRepository.getViews(trackId);
//    }

}
