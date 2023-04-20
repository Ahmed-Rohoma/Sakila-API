package iti.jets.Web_Services.Soap;

import java.util.List;

import iti.jets.exception.ResourceNotFoundException;
import iti.jets.model.dto.ActorDTO;
import iti.jets.model.mapper.ActorMapper;
import iti.jets.repository.entity.Actor;
import iti.jets.service.ActorService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;


@WebService
public class ActorEndPoint {

    private ActorService actorService = null;

    public ActorEndPoint() {
        actorService = new ActorService();
    }

    @WebMethod
    public Response getAll() {
        List<ActorDTO> FilmsList = actorService.getAll();
        GenericEntity<List<ActorDTO>> entity = new GenericEntity<List<ActorDTO>>(FilmsList) {
        };
        return Response.ok().entity(entity).build();
    }

    @WebMethod
    public Response getById(@PathParam("oid") int id) {
        ActorDTO existingFilm = actorService.getByID(id);
        if (existingFilm == null) {
            throw new ResourceNotFoundException("Actor with ID:" + id + " Not Found");
        }
        System.out.println(existingFilm);
        return Response.ok().entity(existingFilm).build();
    }

    @WebMethod
    public Response add(ActorDTO actor) {
        if (actor != null) {
            actorService.add(ActorMapper.toActorEntity(actor));
            return Response.ok().entity("Film with ID : " + actor.getActorId() + " has been Added ").build();
        }
        return Response.ok().entity("Please Provide The actor in Correct Format").build();
    }

    @WebMethod
    public Response update(Actor actor) {
        actorService.update(actor);
        return Response.ok().entity("Film with ID : " + actor.getId() + " has been Updated ").build();
    }


    @WebMethod
    public Response delete(@PathParam("id") int id) {
        actorService.deleteByID(id);
        return Response.ok().entity("Actor with ID : " + id + " has been Deleted ").build();
    }
}
