package iti.jets.Web_Services.Soap;

import java.util.List;

import iti.jets.exception.ResourceNotFoundException;
import iti.jets.model.dto.ActorDTO;
import iti.jets.model.dto.CityDTO;
import iti.jets.model.mapper.ActorMapper;
import iti.jets.model.mapper.CityMapper;
import iti.jets.repository.entity.Actor;
import iti.jets.service.ActorService;
import iti.jets.service.CityService;
import jakarta.jws.WebService;
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


@WebService
public class CityEndPoint {

    private CityService cityService = null;

    public CityEndPoint() {
        cityService = new CityService();
    }

    // @GET
    // @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    // public Response getAll() {
    //     List<ActorDTO> FilmsList = cityService.getAll();
    //     GenericEntity<List<ActorDTO>> entity = new GenericEntity<List<ActorDTO>>(FilmsList) {
    //     };
    //     return Response.ok().entity(entity).build();
    // }

    @GET
    @Path("/{oid}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
    public Response getById(@PathParam("oid") int id) {
        CityDTO existingCity = cityService.getByID(id);
        if (existingCity == null) {
            throw new ResourceNotFoundException("City with ID:" + id + " Not Found");
        }
        System.out.println(existingCity);
        return Response.ok().entity(existingCity).build();
    }

    @POST 
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response add(CityDTO city) {
        if (city != null) {
            cityService.add(CityMapper.toEntity(city));
            return Response.ok().entity("Film with ID : " + city.getId() + " has been Added ").build();
        }
        return Response.ok().entity("Please Provide The City in Correct Format").build();
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response update(CityDTO city) {
        cityService.update(CityMapper.toEntity(city));
        return Response.ok().entity("City with ID : " + city.getId() + " has been Updated ").build();
    }


    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        cityService.deleteByID(id);
        return Response.ok().entity("City with ID : " + id + " has been Deleted ").build();
    }
}
