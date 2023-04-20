package iti.jets.Web_Services.Soap;

import java.util.List;


import iti.jets.exception.ResourceNotFoundException;
import iti.jets.model.dto.CustomerDTO;
import iti.jets.model.mapper.CustomerMapper;
import iti.jets.service.CustomerService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;

@WebService
public class CustomerEndPoint {

    private CustomerService customerService = null;

    public CustomerEndPoint() {
        customerService = new CustomerService();
    }

    // @WebMethod
    // public Response getAll() {
    // List<ActorDTO> FilmsList = customerService.getAll();
    // GenericEntity<List<ActorDTO>> entity = new
    // GenericEntity<List<ActorDTO>>(FilmsList) {
    // };
    // return Response.ok().entity(entity).build();
    // }

    @WebMethod
    public Response getById(@PathParam("oid") int id) {
        CustomerDTO existingCustomer = customerService.getByID(id);
        if (existingCustomer == null) {
            throw new ResourceNotFoundException("customer with ID:" + id + " Not Found");
        }
        System.out.println(existingCustomer);
        return Response.ok().entity(existingCustomer).build();
    }

    @WebMethod
    public Response add(CustomerDTO customer) {
        if (customer != null) {
            customerService.add(CustomerMapper.toEntity(customer));
            return Response.ok().entity("customer with ID : " + customer.getId() + " has been Added ").build();
        }
        return Response.ok().entity("Please Provide The customer in Correct Format").build();
    }

    @WebMethod
    public Response update(CustomerDTO customer) {
        customerService.update(CustomerMapper.toEntity(customer));
        return Response.ok().entity("customer with ID : " + customer.getId() + " has been Updated ").build();
    }

    @WebMethod
    public Response delete(@PathParam("id") int id) {
        customerService.deleteByID(id);
        return Response.ok().entity("Customer with ID : " + id + " has been Deleted ").build();
    }
}
