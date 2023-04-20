package iti.jets.Web_Services.Soap;

import java.util.List;

import iti.jets.exception.ResourceNotFoundException;
import iti.jets.model.dto.FilmDTO;
import iti.jets.model.mapper.FilmMapper;
import iti.jets.repository.entity.Film;
import iti.jets.service.FilmService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;


@WebService
public class FilmEndPoint {

    private FilmService filmService = null;

    public FilmEndPoint() {
        filmService = new FilmService();
    }

    @WebMethod
    public Response getAllFilms() {
        List<FilmDTO> FilmsList = FilmMapper.toDTOList(filmService.getAll());
        GenericEntity<List<FilmDTO>> entity = new GenericEntity<List<FilmDTO>>(FilmsList) {
        };
        return Response.ok().entity(entity).build();
    }

    @WebMethod
    public Response getFilmById(@PathParam("id") int id) {
        Film existingFilm = filmService.getByID(id);
        if (existingFilm == null) {
            throw new ResourceNotFoundException("Film with ID:" + id + " Not Found");
        }
        System.out.println(existingFilm);
        return Response.ok().entity(FilmMapper.toDTO(existingFilm)).build();
    }

    @WebMethod
    public Response addFilm(Film film) {
        if (film != null) {
            filmService.add(film);
            return Response.ok().entity("Film with ID : " + film.getId() + " has been Added ").build();
        }
        return Response.ok().entity("Please Provide The Film in This Format => 'Film [id=?,name=?]'").build();
    }

    @WebMethod
    public Response updateFilm(Film film) {
        filmService.update(film);
        return Response.ok().entity("Film with ID : " + film.getId() + " has been Updated ").build();
    }


    @WebMethod
    public Response deleteFilm(@PathParam("id") int id) {
        filmService.deleteByID(id);
        return Response.ok().entity("Film with ID : " + id + " has been Deleted ").build();
    }
}
