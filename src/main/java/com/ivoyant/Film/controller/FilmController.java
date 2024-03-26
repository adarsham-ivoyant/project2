package com.ivoyant.Film.controller;


import com.ivoyant.Film.entity.Films;
import com.ivoyant.Film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {
    @Autowired
    FilmService filmService;


    //for insert data into db
    @PostMapping("/addFilm")
    public String createFilm(@RequestBody Films films) {
        filmService.createFilm(films);
        return "Inserted Successfully";
    }
    //update film
    @PutMapping("/update")
    public String updateFilm(@RequestBody Films films){
        filmService.updateFilm(films);
        return "Updated Successfully";
    }
    //get film by specific Id
    @GetMapping("/getById/{film_id}")
    public Films getFilm(@PathVariable("film_id") int film_id){
        return filmService.getFilm(film_id);
    }
    //get all films
    @GetMapping("/getAll")
    public List<Films> getAllFilm(){
        return filmService.getAllFilm();
    }
    //delete film by id
    @DeleteMapping("/delete/{film_id}")
    public String deleteFilm(@PathVariable("film_id") int film_id){
        filmService.deleteFilm(film_id);
        return "deleted Successfully";
    }
    //get film by specific name
    @GetMapping("/getFilmByName/{film_name}")
    public Films getFilmByName(@PathVariable("film_name") String film_name) {
        return filmService.getFilmByName(film_name);
    }


}
