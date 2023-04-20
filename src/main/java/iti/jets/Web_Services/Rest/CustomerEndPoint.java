package iti.jets.Web_Services.Rest;

import java.util.List;

import org.glassfish.jersey.internal.inject.Custom;

import iti.jets.exception.ResourceNotFoundException;
import iti.jets.model.dto.ActorDTO;
import iti.jets.model.dto.CustomerDTO;
import iti.jets.model.mapper.ActorMapper;
import iti.jets.model.mapper.CustomerMapper;
import iti.jets.repository.entity.Actor;
import iti.jets.service.ActorService;
import iti.jets.service.CustomerService;
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


@Path("customers")
public class CustomerEndPoint {

    private CustomerService customerService = null;

    public CustomerEndPoint() {
        customerService = new CustomerService();
    }

    // @GET
    // @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    // public Response getAll() {
    //     List<ActorDTO> FilmsList = customerService.getAll();
    //     GenericEntity<List<ActorDTO>> entity = new GenericEntity<List<ActorDTO>>(FilmsList) {
    //     };
    //     return Response.ok().entity(entity).build();
    // }

    @GET
    @Path("/{oid}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
    public Response getById(@PathParam("oid") int id) {
        CustomerDTO existingCustomer = customerService.getByID(id);
        if (existingCustomer == null) {
            throw new ResourceNotFoundException("customer with ID:" + id + " Not Found");
        }
        System.out.println(existingCustomer);
        return Response.ok().entity(existingCustomer).build();
    }

    @POST 
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response add(CustomerDTO customer) {
        if (customer != null) {
            customerService.add(CustomerMapper.toEntity(customer));
            return Response.ok().entity("customer with ID : " + customer.getId() + " has been Added ").build();
        }
        return Response.ok().entity("Please Provide The customer in Correct Format").build();
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response update(CustomerDTO customer) {
        customerService.update(CustomerMapper.toEntity(customer));
        return Response.ok().entity("customer with ID : " + customer.getId() + " has been Updated ").build();
    }


    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        customerService.deleteByID(id);
        return Response.ok().entity("Customer with ID : " + id + " has been Deleted ").build();
    }
}
