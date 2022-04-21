package com.externalapi.controller;

import com.externalapi.model.Film;
import com.externalapi.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/complete")
    public Object[] getAllFilmsComplete() {
        return filmService.findAllFilmsComplete();
    }

    @GetMapping
    public Film[] getAllFilms() {
        return filmService.findAllFilms();
    }

    @GetMapping("/title")
    public List<Film> getFilmsByTitle(@RequestParam("q") String title) {
        return filmService.findFilmsByTitle(title);
    }

    @GetMapping("/directors")
    public Map<Integer, String> getDirectors() {
        return filmService.findDirectors();
    }

    @GetMapping("/newest")
    public List<Film> getNewestFilms() {
        return filmService.findFilmsByNewest();
    }

}
