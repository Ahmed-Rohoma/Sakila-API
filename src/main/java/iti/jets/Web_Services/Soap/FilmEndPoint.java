package iti.jets.Web_Services.Soap;

import java.util.List;

import iti.jets.exception.ResourceNotFoundException;
import iti.jets.model.dto.FilmDTO;
import iti.jets.model.mapper.FilmMapper;
import iti.jets.repository.entity.Film;
import iti.jets.service.FilmService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("film")
public class FilmEndPoint {

    private FilmService filmService = null;

    public FilmEndPoint() {
        filmService = new FilmService();
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getAllFilms() {
        List<FilmDTO> FilmsList = FilmMapper.toDTOList(filmService.getAll());
        GenericEntity<List<FilmDTO>> entity = new GenericEntity<List<FilmDTO>>(FilmsList) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getFilmById(@PathParam("id") int id) {
        Film existingFilm = filmService.getByID(id);
        if (existingFilm == null) {
            throw new ResourceNotFoundException("Film with ID:" + id + " Not Found");
        }
        System.out.println(existingFilm);
        return Response.ok().entity(FilmMapper.toDTO(existingFilm)).build();
    }

    @POST 
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response addFilm(Film film) {
        if (film != null) {
            filmService.add(film);
            return Response.ok().entity("Film with ID : " + film.getId() + " has been Added ").build();
        }
        return Response.ok().entity("Please Provide The Film in This Format => 'Film [id=?,name=?]'").build();
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response updateFilm(Film film) {
        filmService.update(film);
        return Response.ok().entity("Film with ID : " + film.getId() + " has been Updated ").build();
    }


    @DELETE
    @Path("{id}")
    public Response deleteFilm(@PathParam("id") int id) {
        filmService.deleteByID(id);
        return Response.ok().entity("Film with ID : " + id + " has been Deleted ").build();
    }
}
