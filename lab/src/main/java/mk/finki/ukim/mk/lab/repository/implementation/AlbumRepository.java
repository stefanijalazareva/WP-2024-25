package mk.finki.ukim.mk.lab.repository.implementation;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlbumRepository {
    public List<Album> findAll() {
        return DataHolder.albums;
    }

    public Optional<Album> findAlbumById(Long id) {
        return DataHolder.albums.stream().filter(album -> album.getId().equals(id)).findFirst();
    }
}
