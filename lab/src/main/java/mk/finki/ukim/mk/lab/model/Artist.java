package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@Data
@Entity
@NoArgsConstructor
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;
    @ManyToMany
    private List<Song> songs;

    public Artist(String firstName, String lastName, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }
}
