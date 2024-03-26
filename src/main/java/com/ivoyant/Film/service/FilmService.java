package com.ivoyant.Film.service;

import com.ivoyant.Film.entity.Films;

import java.util.List;

public interface FilmService {
    /**
     *
     *
     * This method gets data
     * @param films "get some details about films"
     * @return  "data added"
     */
    public String createFilm(Films films);

    public String updateFilm(Films films);
    public String deleteFilm(int film_id);
    public Films getFilm(int film_id);
    public List<Films> getAllFilm();

    public Films getFilmByName(String film_name);


}
