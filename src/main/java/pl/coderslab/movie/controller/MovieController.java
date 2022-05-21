package pl.coderslab.movie.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.movie.entity.Director;
import pl.coderslab.movie.database.DirectorDao;
import pl.coderslab.movie.entity.Movie;
import pl.coderslab.movie.database.MovieDao;

import javax.validation.Valid;


@Controller
@RequestMapping("/movie")
@Slf4j
public class MovieController {


    private final MovieDao movieDao;
    private final DirectorDao directorDao;

    public MovieController(MovieDao movieDao, DirectorDao directorDao) {
        this.movieDao = movieDao;
        this.directorDao = directorDao;
    }




    @GetMapping("/form-edit")
    public String editForm(Model model){
        Movie movie = new Movie();
        movie.setTitle("Pewnego Razu w Hollywood");
        movie.setRating(7);
        model.addAttribute("movie", movie);
        return "movie/add";
    }


    @RequestMapping("/add")
    @ResponseBody
    public String addMovieWithDirector() {

        Director director = new Director();
        director.setFirstName("Steven");
        director.setLastName("Spielberg");
        directorDao.save(director);

        Movie movie = new Movie();
        movie.setDirector(director);
        movieDao.saveMovie(movie);

        return "added";
    }

    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("directors", directorDao.getList());
        model.addAttribute("movie", new Movie());
        return "movie/add";
    }

    @PostMapping("/form")
    public String saveForm(@Valid Movie movie, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("directors", directorDao.getList());
            return "movie/add";
        }
        movieDao.saveMovie(movie);
        return "redirect:/movie/list";
    }


    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("movie", movieDao.getList());
        return "movie/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        movieDao.delete(movieDao.find(id));
        return "redirect:/movie/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable long id){
        model.addAttribute("directors", directorDao.getList());
        model.addAttribute("movie", movieDao.find(id));
        return "movie/edit";
    }

    @PostMapping("/update")
    public String updateForm( Movie movie){
        movieDao.update(movie);
        return "redirect:/movie/list";
    }

}