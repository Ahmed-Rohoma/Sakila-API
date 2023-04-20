package iti.jets;

import java.util.Date;
import java.util.List;

import iti.jets.model.dto.FilmDTO;
import iti.jets.model.dto.LanguageDTO;
import iti.jets.model.mapper.FilmMapper;
import iti.jets.model.mapper.LanguageMapper;
import iti.jets.repository.entity.Film;
import iti.jets.service.FilmService;
import iti.jets.service.LanService;

public class Main {
    public static void main(String[] args) {

        FilmService filmService = new FilmService();
        LanService lanService = new LanService();

        FilmDTO f = new FilmDTO();
        f.setTitle("The Shawshank Redemption");
        f.setDescription(
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.");
        f.setReleaseYear(1994);
        f.setRentalDuration(3);
        f.setRentalRate(2.99);
        f.setLength(142);
        f.setReplacementCost(19.99);
        f.setLastUpdate(new Date());

        LanguageDTO languageDTO = new LanguageDTO();
        languageDTO.setName("noooooooooo");
        languageDTO.setLastUpdate(new Date());

        lanService.add(LanguageMapper.toEntity(languageDTO));

        // f.setLanguage(languageDTO);
        filmService.add(FilmMapper.toEntity(f));

        // filmService.deleteByID(2001);
        // filmService.deleteByID(2002);


        List<Film> all = filmService.getAll();
        for (Film film : all) {
            if(film.getId() > 1000)
                System.out.println(film.getId());
        }
        System.out.println("size = " + all.size());

        // ActorService actorService = new ActorService();

        // List<Actor> all = actorService.getAll();
        // System.out.println(all.size());
        // Actor byID = actorService.getByID(5);
        // byID.setFirstName("not zaki");
        // actorService.update(byID);
        // actorService.deleteByID(5);

        // Actor a = new Actor();
        // a.setFirstName("f");
        // a.setLastName("l");
        // a.setLastUpdate(new Date());

        // actorService.add(a);

    }

}
