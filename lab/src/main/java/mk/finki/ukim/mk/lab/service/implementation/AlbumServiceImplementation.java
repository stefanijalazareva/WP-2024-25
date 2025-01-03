package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.exceptions.AlbumNotFoundException;
import mk.finki.ukim.mk.lab.repository.implementation.AlbumRepository;
import mk.finki.ukim.mk.lab.repository.jpa.AlbumJPARepository;
import mk.finki.ukim.mk.lab.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImplementation implements AlbumService {
    private final AlbumJPARepository albumRepository;

    public AlbumServiceImplementation(AlbumJPARepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return this.albumRepository.findAll();
    }

    @Override
    public Album findByAlbumId(Long albumId) {
        Album album = this.albumRepository.findById(albumId).orElse(null);
        if (album == null) {
            throw new AlbumNotFoundException(albumId);
        } else {
            return album;
        }
    }
}
