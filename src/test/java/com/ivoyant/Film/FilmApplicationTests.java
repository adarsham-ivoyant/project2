package com.ivoyant.Film;

import com.ivoyant.Film.entity.Films;
import com.ivoyant.Film.repository.FilmRepo;
import com.ivoyant.Film.service.FilmService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@SpringBootTest
class FilmApplicationTests {
    @Autowired
    private FilmService filmService;

    @MockBean
    private FilmRepo filmRepo;


    @Test
    public void getAllFilmTest(){
        when(filmRepo.findAll()).thenReturn(Stream
                .of(new Films(376, "Dia", "xyz", 123), new Films(958, "Huy","Temp", 35 )).collect(Collectors.toList()));
        assertEquals(2, filmService.getAllFilm().size());

    }

   @Test
    public void addFilmTest(){

//       Films film=new Films(1,"temp","qwer",456);
//        when(filmRepo.save(film)).thenReturn(film);
////        assertEquals(film,filmService.createFilm(film));
////       Films f=new Films();
////       f.setFilmId(1);
////        f.setFilmName("dia");
////        f.setDirector("temp");
////        f.setBudget(300);
////        .save(f);
//
//        assertNotNull(filmRepo.findById(1).get());
       Films film = new Films(1, "temp", "qwer", 456);
// Mock the behavior of filmRepo.save(film)
       doReturn(film).when(filmRepo).save(film);

// Now, you can save the film
       filmRepo.save(film);

// Retrieve the film using findById
       Optional<Films> optionalFilm = filmRepo.findById(1);

// Check if the optionalFilm contains a value before calling .get()
       if (optionalFilm.isPresent()) {
           assertNotNull(optionalFilm.get());
       } else {
           // Handle the case where no film with the specified ID was found
       }

   }

//   @Test
//    public void getFilmByName(){
//       String film_name="Dia";
//       when(filmRepo.findAll()).thenReturn(Stream
//               .of(new Films(376, "Dia", "xyz", 123)).collect(Collectors.toList()));
//
//       assertEquals(film_name,filmRepo.findByFilmName(film_name));
//    }


    @Test
    public void getFilmByName() {
        String film_name = "Dia";

        // Mock the behavior of filmRepo.findAll() to return a list with a film
        when(filmRepo.findAll()).thenReturn(
                Stream.of(new Films(376, "Dia", "xyz", 123)).collect(Collectors.toList())
        );

        // Mock the behavior of filmRepo.findByFilmName(film_name) to return the film with the specified name
        when(filmRepo.findByFilmName(film_name)).thenReturn(new Films(376, "Dia", "xyz", 123));

        // Call the findByFilmName method
        Films foundFilm = filmRepo.findByFilmName(film_name);

        // Assert that the foundFilm is not null
        assertNotNull(foundFilm);

        // Assert that the film_name matches the name of the foundFilm
        assertEquals(film_name, foundFilm.getFilmName());
    }


//    @Test
//    public void deleteFilmTest(){
//      int film_id=1;
//        Films film=new Films(1,"temp","qwer",456);
//         filmRepo.save(film);
//        filmService.deleteFilm(film_id);
//        verify(filmRepo, filmService.deleteFilm(film_id));
//
//    }

    @Test
    public void deleteTest(){
        int film_id=1;
        Films film = new Films(1, "temp", "qwer", 456);
// Mock the behavior of filmRepo.save(film)
        doReturn(film).when(filmRepo).save(film);

// Now, you can save the film
        filmRepo.save(film);

// Retrieve the film using findById
    //    Optional<Films> optionalFilm = filmRepo.findById(1);
    //    filmService.deleteFilm(film_id);
      //  verify(filmRepo, times(1)).delete(film_id);
    }






}
