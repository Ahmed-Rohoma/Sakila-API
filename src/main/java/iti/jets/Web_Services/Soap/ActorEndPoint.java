package iti.jets.Web_Services.Soap;

import java.util.List;

import iti.jets.exception.ResourceNotFoundException;
import iti.jets.model.dto.ActorDTO;
import iti.jets.model.mapper.ActorMapper;
import iti.jets.repository.entity.Actor;
import iti.jets.service.ActorService;
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


@Path("actor")
public class ActorEndPoint {

    private ActorService actorService = null;

    public ActorEndPoint() {
        actorService = new ActorService();
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAll() {
        List<ActorDTO> FilmsList = actorService.getAll();
        GenericEntity<List<ActorDTO>> entity = new GenericEntity<List<ActorDTO>>(FilmsList) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("/{oid}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
    public Response getById(@PathParam("oid") int id) {
        ActorDTO existingFilm = actorService.getByID(id);
        if (existingFilm == null) {
            throw new ResourceNotFoundException("Actor with ID:" + id + " Not Found");
        }
        System.out.println(existingFilm);
        return Response.ok().entity(existingFilm).build();
    }

    @POST 
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response add(ActorDTO actor) {
        if (actor != null) {
            actorService.add(ActorMapper.toActorEntity(actor));
            return Response.ok().entity("Film with ID : " + actor.getActorId() + " has been Added ").build();
        }
        return Response.ok().entity("Please Provide The actor in Correct Format").build();
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response update(Actor actor) {
        actorService.update(actor);
        return Response.ok().entity("Film with ID : " + actor.getId() + " has been Updated ").build();
    }


    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        actorService.deleteByID(id);
        return Response.ok().entity("Actor with ID : " + id + " has been Deleted ").build();
    }
}
