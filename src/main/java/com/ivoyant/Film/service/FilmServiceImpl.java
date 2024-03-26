package com.ivoyant.Film.service;

import com.ivoyant.Film.entity.Films;
import com.ivoyant.Film.exception.FilmNotFoundException;
import com.ivoyant.Film.repository.FilmRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService{

    FilmRepo filmRepo;

    public FilmServiceImpl(FilmRepo filmRepo) {
        this.filmRepo = filmRepo;
    }


    @Override
    public String createFilm(Films films) {
        filmRepo.save(films);
        return "Successful inserted";
    }

    @Override
    public String updateFilm(Films films) {
        filmRepo.save(films);
        return "Successful updated";
    }
    /**
     * Adds two numbers.
     *
     * @param film_id to be added.
     * @return string..
     * @throws FilmNotFoundException if there is no Id found
     */

    @Override
    public String deleteFilm(int film_id) {
        if(filmRepo.findById(film_id).isEmpty()){
            throw new FilmNotFoundException(film_id+" id is not present");
        }
        filmRepo.deleteById(film_id);
        return "successfully deleted";
    }

    /**
     * Adds two numbers.
     *
     * @param film_id to be added.
     * @return string..
     * @exception  FilmNotFoundException if there is no Id found
     */

    @Override
    public Films getFilm(int film_id) {
        if(filmRepo.findById(film_id).isEmpty())
            throw new FilmNotFoundException(film_id+" is does not exist");
        return filmRepo.findById(film_id).get();
    }

    @Override
    public List<Films> getAllFilm() {
        if(filmRepo.findAll().isEmpty())
            throw new FilmNotFoundException("Database is empty");
        return filmRepo.findAll();
}

    @Override
    public Films getFilmByName(String film_name) {
        return filmRepo.findByFilmName(film_name);
    }
}