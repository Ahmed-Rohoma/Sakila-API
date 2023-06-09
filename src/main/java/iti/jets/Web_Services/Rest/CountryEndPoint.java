package iti.jets.Web_Services.Rest;

import java.util.List;

import iti.jets.exception.ResourceNotFoundException;
import iti.jets.model.dto.ActorDTO;
import iti.jets.model.dto.CountryDTO;
import iti.jets.model.mapper.ActorMapper;
import iti.jets.model.mapper.CountryMapper;
import iti.jets.repository.entity.Actor;
import iti.jets.service.ActorService;
import iti.jets.service.CountryService;
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


@Path("countries")
public class CountryEndPoint {

    private CountryService countryService = null;

    public CountryEndPoint() {
        countryService = new CountryService();
    }

    // @GET
    // @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    // public Response getAll() {
    //     List<CountryDTO> FilmsList = countryService.getAll();
    //     GenericEntity<List<CountryDTO>> entity = new GenericEntity<List<CountryDTO>>(FilmsList) {
    //     };
    //     return Response.ok().entity(entity).build();
    // }

    @GET
    @Path("/{oid}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
    public Response getById(@PathParam("oid") int id) {
        CountryDTO existingCountry = countryService.getByID(id);
        if (existingCountry == null) {
            throw new ResourceNotFoundException("Country with ID:" + id + " Not Found");
        }
        System.out.println(existingCountry);
        return Response.ok().entity(existingCountry).build();
    }

    @POST 
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response add(CountryDTO country) {
        if (country != null) {
            countryService.add(CountryMapper.toEntity(country));
            return Response.ok().entity("Film with ID : " + country.getId() + " has been Added ").build();
        }
        return Response.ok().entity("Please Provide The country in Correct Format").build();
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response update(CountryDTO country) {
        countryService.update(CountryMapper.toEntity(country));
        return Response.ok().entity("Film with ID : " + country.getId() + " has been Updated ").build();
    }


    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        countryService.deleteByID(id);
        return Response.ok().entity("country with ID : " + id + " has been Deleted ").build();
    }
}
