package pl.coderslab.movie.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.movie.database.DirectorDao;
import pl.coderslab.movie.database.SeriesDao;
import pl.coderslab.movie.entity.Series;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@Slf4j
public class SeriesController {

    private final SeriesDao seriesDao;
    private final DirectorDao directorDao;

    public SeriesController(SeriesDao seriesDao, DirectorDao directorDao) {
        this.seriesDao = seriesDao;
        this.directorDao = directorDao;
    }

    @GetMapping("form-edit")
    public String editForm(Model model){
        Series series = new Series();
        series.setTitle("Ranczo");
        series.setDescription("pitupitupitu");
        series.setRating(5);
        model.addAttribute("series", series);
        return "series/add";
    }

    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("directors", directorDao.getList());
        model.addAttribute("series", new Series());
        return "series/add";
    }

    @PostMapping("/form")
    public String saveForm(@Valid Series series, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("directors", directorDao.getList());
            return "series/add";
        }
        seriesDao.saveSeries(series);
        return "redirect:/series/list";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("series", seriesDao.getList());
        return "series/list";
    }
}
