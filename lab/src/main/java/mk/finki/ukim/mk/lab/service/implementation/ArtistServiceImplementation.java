package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.repository.implementation.ArtistRepository;
import mk.finki.ukim.mk.lab.repository.jpa.ArtistJPARepository;
import mk.finki.ukim.mk.lab.service.ArtistService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArtistServiceImplementation implements ArtistService {
    private final ArtistJPARepository artistRepository;

    public ArtistServiceImplementation(ArtistJPARepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }
}
