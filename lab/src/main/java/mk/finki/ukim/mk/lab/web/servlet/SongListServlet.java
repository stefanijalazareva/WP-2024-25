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
//
//@WebServlet(name = "song-list-servlet", urlPatterns = "/listSongs")
//public class SongListServlet extends HttpServlet {
//    private final SpringTemplateEngine springTemplateEngine;
//    private final SongService songService;
//
//    public SongListServlet(SpringTemplateEngine springTemplateEngine, SongService songService) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.songService = songService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        List<Song> songs = songService.listSongs();
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);  //thymeleaf content
//        WebContext webContext = new WebContext(webExchange);
//
//        webContext.setVariable("songs", songs); //dodavanje na pesnite na kontekstot
//
//        //renderiranje na kontekstot
//        springTemplateEngine.process("listSongs.html", webContext, resp.getWriter());
//    }
//}
