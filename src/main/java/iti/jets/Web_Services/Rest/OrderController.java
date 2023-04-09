package iti.jets.Web_Services.Rest;

import java.util.Set;

import iti.jets.exception.ResourceNotFoundException;
import iti.jets.model.Order;
import iti.jets.service.OrderService;
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

/**
 * Root resource (exposed at "orders" path)
 */
@Path("orders")
public class OrderController {

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllOrders() {
        Set<Order> ordersList = OrderService.getAllOrders();
        System.out.println("============================");
        System.out.println("====== GET ALL ORDERS ======");
        System.out.println("============================");
        for (Order order : ordersList) {
            System.out.println(order);
        }
        // =================================================================================>
        // Type erasure
        GenericEntity<Set<Order>> entity = new GenericEntity<Set<Order>>(ordersList) {
        };
        return Response.ok().entity(entity).build();
        // return Response.ok(entity).build();
    }

    @GET
    @Path("/only/{oid}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
    public Response getOrderById(@DefaultValue("1") @PathParam("oid") int id) {
        Order existingOrder = OrderService.getOrderbyID(id);
        if (existingOrder == null) {
            throw new ResourceNotFoundException("Order with ID:" + id + " Not Found");
        }
        System.out.println(existingOrder);
        return Response.ok().entity(existingOrder).build();
    }

    // "Order [id=1,name=2]"
    @POST // how to add validation to this coming object
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
    public Response addOrder(Order order) {
        if (order != null) {
            OrderService.addOrder(order);
            return Response.ok().entity("Order with ID : " + order.getOrderID() + " has been Added ").build();
        }
        return Response.ok().entity("Please Provide The Order in This Format => 'Order [id=?,name=?]'").build();
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateOrder(Order order) {
        OrderService.updateOrder(order);
        return Response.ok().entity("Order with ID : " + order.getOrderID() + " has been Updated ").build();
    }

    // here list and map doesn't return back in Response

    @DELETE
    @Path("{id}")
    public Response deleteOrder(@PathParam("id") int id) {
        OrderService.removeOrder(id);
        // getAllOrders();
        return Response.ok().entity("Order with ID : " + id + " has been Deleted ").build();
    }

    // EJB

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        Order existingOrder = OrderService.getOrderbyID(id);
        if (existingOrder == null)
            throw new ResourceNotFoundException("Order with ID:" + id + " Not Found");
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("how to access me again").build();
        // 
        return Response.ok(existingOrder).links(self).build();
    }
}
