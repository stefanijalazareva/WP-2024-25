package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/details/{albumId}")
    public String albumDetails(@PathVariable Long albumId, Model model) {
        Album album =albumService.findByAlbumId(albumId);
        model.addAttribute("album", album);
        return "albumDetails";
    }
}

