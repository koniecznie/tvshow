package pl.coderslab.movie.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.movie.database.SeriesDao;
import pl.coderslab.movie.entity.Director;
import pl.coderslab.movie.database.DirectorDao;
import pl.coderslab.movie.entity.Movie;
import pl.coderslab.movie.database.MovieDao;

import javax.validation.Valid;


@Controller
@RequestMapping("/director")
@Slf4j
public class DirectorController {

    private final DirectorDao directorDao;
    private final MovieDao movieDao;
    private final SeriesDao seriesDao;


    public DirectorController(DirectorDao directorDao, MovieDao movieDao, SeriesDao seriesDao) {
        this.directorDao = directorDao;
        this.movieDao = movieDao;
        this.seriesDao = seriesDao;
    }


    @RequestMapping("/add")
    @ResponseBody
    public String addDirectorWithMovie() {
        Director director = new Director();
        director.setFirstName("Quentin");
        director.setLastName("Tarantino");
        directorDao.save(director);

        Movie movie = new Movie();
        movie.setDirector(director);
        movieDao.saveMovie(movie);
        return "Imie rezysera to: " + director.getFirstName() + director.getLastName();

    }

    @GetMapping("/form")
    public String showForm(Model model){
//        model.addAttribute("directors", directorDao.getList());
//        model.addAttribute("movies", movieDao.getList());
        model.addAttribute("director", new Director());
        return "director/add";
    }

    @PostMapping("/form")
    public String saveForm(@Valid Director director, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("directors", directorDao.getList());
            return "director/add";
        }
        directorDao.save(director);
        return "redirect:/director/list";
    }


    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("directors", directorDao.getList());
        return "/director/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        directorDao.delete(directorDao.find(id));
        return "redirect:/director/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable long id){
        model.addAttribute("directors", directorDao.getList());
        model.addAttribute("movie", movieDao.find(id));
        return "director/edit";
    }

    @PostMapping("/update")
    public String updateForm(Director director) {
        directorDao.update(director);
        return "redirect:/director/list";
    }


}

