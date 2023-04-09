package iti.jets.Web_Services.Rest;

import java.util.Set;

import iti.jets.exception.ResourceNotFoundException;
import iti.jets.model.Film;
import iti.jets.service.FilmService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Link;


@Path("films")
public class FilmEndPoint {

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllFilms() {
        Set<Film> FilmsList = FilmService.getAllFilms();
        GenericEntity<Set<Film>> entity = new GenericEntity<Set<Film>>(FilmsList) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("/only/{oid}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
    public Response getFilmById(@DefaultValue("1") @PathParam("oid") int id) {
        Film existingFilm = FilmService.getFilmbyID(id);
        if (existingFilm == null) {
            throw new ResourceNotFoundException("Film with ID:" + id + " Not Found");
        }
        System.out.println(existingFilm);
        return Response.ok().entity(existingFilm).build();
    }

    // "Film [id=1,name=2]"
    @POST // how to add validation to this coming object
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
    public Response addFilm(Film film) {
        if (film != null) {
            FilmService.addFilm(film);
            return Response.ok().entity("Film with ID : " + film.getId() + " has been Added ").build();
        }
        return Response.ok().entity("Please Provide The Film in This Format => 'Film [id=?,name=?]'").build();
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateFilm(Film film) {
        FilmService.updateFilm(film);
        return Response.ok().entity("Film with ID : " + film.getId() + " has been Updated ").build();
    }

    // here list and map doesn't return back in Response

    @DELETE
    @Path("{id}")
    public Response deleteFilm(@PathParam("id") int id) {
        // FilmService.removeFilm(id);
        return Response.ok().entity("Film with ID : " + id + " has been Deleted ").build();
    }

    // EJB

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        Film existingFilm = FilmService.getFilmbyID(id);
        if (existingFilm == null)
            throw new ResourceNotFoundException("Film with ID:" + id + " Not Found");
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("how to access me again").build();
        // 
        return Response.ok(existingFilm).links(self).build();
    }
}
