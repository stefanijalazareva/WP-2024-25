package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
public class Artist {
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;

    public Artist(String firstName, String lastName, String bio) {
        Random random = new Random();
        this.id = random.nextLong(1000, 9999);
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }
}
