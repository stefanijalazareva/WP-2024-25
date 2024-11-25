package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.model.exceptions.SongNotFoundException;
import mk.finki.ukim.mk.lab.service.AlbumService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Song> songs = this.songService.listSongs();
        model.addAttribute("songs", songs);
        return "listSongs";
    }

    @GetMapping("/details/{trackId}")
    public String songDetails(@PathVariable Long trackId, Model model) {
        Song song = songService.findByTrackId(trackId);
        model.addAttribute("song", song);
        return "songDetails";
    }

    @GetMapping("/delete/{trackId}")
    public String deleteSong(@PathVariable Long trackId) {
        songService.deleteSong(trackId);
        return "redirect:/songs";
    }

    @GetMapping("/edit-form/{trackId}")
    public String getEditSongForm(@PathVariable Long trackId, Model model) {
        try {
            Song song = songService.findByTrackId(trackId);
            model.addAttribute("song", song);
            model.addAttribute("trackId", trackId);
            model.addAttribute("addSong", false);
            model.addAttribute("albums", albumService.findAll());
        } catch (SongNotFoundException e) {
            return "redirect:/songs?error=SongNotFound";
        }
        return "addSong";
    }

    @GetMapping("/add-form")
    public String getAddSongPage(Model model) {
        model.addAttribute("addSong", true);
        model.addAttribute("albums", albumService.findAll());
        return "addSong";
    }

    @PostMapping("/add")
    public String saveSong(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long albumId) {
        Song song = songService.addSong(title, genre, releaseYear, albumId);
        return "redirect:/songs";
    }

    @PostMapping("/edit/{trackId}")
    public String editSong(@PathVariable Long trackId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long albumId) {
        songService.editSong(trackId, title, genre, releaseYear, albumId);
        return "redirect:/songs";
    }
}
