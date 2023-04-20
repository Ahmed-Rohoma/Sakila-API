package iti.jets.Web_Services.Soap;

import java.util.List;

import iti.jets.exception.ResourceNotFoundException;
import iti.jets.model.dto.AddressDTO;
import iti.jets.model.mapper.AddressMapper;
import iti.jets.repository.entity.Address;
import iti.jets.service.AddressService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@WebService
public class AddressEndPoint {

    private AddressService addressService = null;

    public AddressEndPoint() {
        addressService = new AddressService();
    }

    // @WebMethod
    // public Response getAll() {
    //     List<ActorDTO> FilmsList = addressService.getAll();
    //     GenericEntity<List<ActorDTO>> entity = new GenericEntity<List<ActorDTO>>(FilmsList) {
    //     };
    //     return Response.ok().entity(entity).build();
    // }

    @WebMethod
    public Response getById(@PathParam("oid") int id) {
        AddressDTO existingadd = addressService.getByID(id);
        if (existingadd == null) {
            throw new ResourceNotFoundException("Address with ID:" + id + " Not Found");
        }
        System.out.println(existingadd);
        return Response.ok().entity(existingadd).build();
    }

    @WebMethod
    public Response add(AddressDTO address) {
        if (address != null) {
            addressService.add(AddressMapper.toEntity(address));
            return Response.ok().entity("Film with ID : " + address.getId() + " has been Added ").build();
        }
        return Response.ok().entity("Please Provide The Address in Correct Format").build();
    }

    @WebMethod
    public Response update(Address address) {
        addressService.update(address);
        return Response.ok().entity("Address with ID : " + address.getId() + " has been Updated ").build();
    }


    @WebMethod
    public Response delete(@PathParam("id") int id) {
        addressService.deleteByID(id);
        return Response.ok().entity("Address with ID : " + id + " has been Deleted ").build();
    }
}
