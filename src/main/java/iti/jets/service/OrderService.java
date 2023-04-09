package iti.jets.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import iti.jets.exception.ResourceNotFoundException;
import iti.jets.model.Order;
import iti.jets.repository.dao.OrderDao;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class OrderService {
    public static Map<Integer, Order> ordersMap = new HashMap<>();
    public static Set<Order> orders = new HashSet<>();
    static Order o1 = new Order(1, "user1");
    static Order o2 = new Order(2, "user2");
    static Order o3 = new Order(3, "user3");
    static OrderDao orderDao = new OrderDao();

    static {
        orders.add(o1);
        orders.add(o2);
        orders.add(o3);
        ordersMap.put(1, o1);
        ordersMap.put(2, o2);
        ordersMap.put(3, o3);
    }

    public static void addOrder(Order order) {
        orders.add(order);
    }

    public static void removeOrder(int orderId) {
        Order existingOrder = OrderService.getOrderbyID(orderId);
        // Order existingOrder = toModel(orderDao.getOrderByID(orderId));

        if (existingOrder != null) {
            orders.remove(existingOrder);
        } else
        // throw new ResourceNotFoundException("Order with ID:" + orderId + " Not Found
        // To Deleted");
        {
            Response response = Response.status(Response.Status.NOT_FOUND)
                    .entity("Order Does Not Exists with ID : " + orderId).build();
            throw new WebApplicationException(response);
        }
    }

    public static Set<Order> getAllOrders() {
        return orders;
    }

    public static Map<Integer, Order> getOrdersMap() {
        return ordersMap;
    }

    public static Order getOrderbyID(int orderID) {
        for (Order order : orders) {
            if (order.getOrderID() == orderID) {
                return order;
            }
        }
        return null;
    }

    public static void updateOrder(Order updatedOrder) {
        Order existingOrder = OrderService.getOrderbyID(updatedOrder.getOrderID());
        if (existingOrder == null) {
            throw new ResourceNotFoundException("Order with ID:" + updatedOrder.getOrderID() + " Not Found To Update ");
        }
        existingOrder.setUserName(updatedOrder.getUserName());
    }

    private static Order toModel(iti.jets.repository.entity.Order orderEntity) {
        return new Order(orderEntity.getId(), orderEntity.getUserName());
    }

}
