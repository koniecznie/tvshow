package pl.coderslab.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.movie.database.MovieDao;
import pl.coderslab.movie.entity.Movie;

@Controller
public class HomeController {

    private final MovieDao movieDao;

    public HomeController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
    @RequestMapping("/")
    @ResponseBody
    public String home(){
        Movie movie = new Movie();
        movie.setTitle("Pewnego razu w Hollywood");
        movie.setDescription("Quentin Tarantino's Once Upon a Time... in Hollywood visits 1969 Los Angeles, where everything is changing, as TV star Rick Dalton (Leonardo DiCaprio) and his longtime stunt double Cliff Booth (Brad Pitt) make their way around an industry they hardly recognize anymore. The ninth film from the writer-addDirectorWithMovie features a large ensemble cast and multiple storylines in a tribute to the final moments of Hollywood's golden age.");
        movie.setRating(8);
        movie.setTime(171);

        Long id = movie.getId();
        System.out.println(id);


        return "welcome to my site :)";

    }
}
