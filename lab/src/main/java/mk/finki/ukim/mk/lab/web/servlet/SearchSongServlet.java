//package mk.finki.ukim.mk.lab.web.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.model.Song;
//import mk.finki.ukim.mk.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@WebServlet(name = "search-songs-servlet", urlPatterns = "/searchSongs")
//public class SearchSongServlet extends HttpServlet {
//    //DOPOLNITELNO BARANJE
//    //search funkcionalnost za iminjata na pesnite
//    //na stranata kaj sho se pesnite da ima search pole
//    //koga ke searchneme na stranata kako substring da ni izlezat pesnite koi go sodrzhat toa zborche
//    private final SongService songService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public SearchSongServlet(SongService songService, SpringTemplateEngine springTemplateEngine) {
//        this.songService = songService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        String search = req.getParameter("search");
////        List<Song> songList = songService.listSongs().stream()
////                .filter(song -> song.getTitle().toLowerCase().contains(search.toLowerCase()))
////                .collect(Collectors.toList());
//        List<Song> songList = songService.findTitleBySubstring(search);
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//        WebContext webContext = new WebContext(webExchange);
//
//        webContext.setVariable("songList", songList);
//        springTemplateEngine.process("listSongs.html", webContext, resp.getWriter());
//    }
//}
