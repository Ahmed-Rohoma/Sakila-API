package iti.jets.Web_Services.Rest;

import java.util.List;

import iti.jets.exception.ResourceNotFoundException;
import iti.jets.model.dto.AddressDTO;
import iti.jets.model.mapper.AddressMapper;
import iti.jets.repository.entity.Address;
import iti.jets.service.AddressService;
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


@Path("address")
public class AddressEndPoint {

    private AddressService addressService = null;

    public AddressEndPoint() {
        addressService = new AddressService();
    }

    // @GET
    // @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    // public Response getAll() {
    //     List<ActorDTO> FilmsList = addressService.getAll();
    //     GenericEntity<List<ActorDTO>> entity = new GenericEntity<List<ActorDTO>>(FilmsList) {
    //     };
    //     return Response.ok().entity(entity).build();
    // }

    @GET
    @Path("/{oid}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
    public Response getById(@PathParam("oid") int id) {
        AddressDTO existingadd = addressService.getByID(id);
        if (existingadd == null) {
            throw new ResourceNotFoundException("Address with ID:" + id + " Not Found");
        }
        System.out.println(existingadd);
        return Response.ok().entity(existingadd).build();
    }

    @POST 
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response add(AddressDTO address) {
        if (address != null) {
            addressService.add(AddressMapper.toEntity(address));
            return Response.ok().entity("Film with ID : " + address.getId() + " has been Added ").build();
        }
        return Response.ok().entity("Please Provide The Address in Correct Format").build();
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response update(Address address) {
        addressService.update(address);
        return Response.ok().entity("Address with ID : " + address.getId() + " has been Updated ").build();
    }


    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        addressService.deleteByID(id);
        return Response.ok().entity("Address with ID : " + id + " has been Deleted ").build();
    }
}
