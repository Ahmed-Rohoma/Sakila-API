package iti.jets.repository.dao;

import java.util.List;

import iti.jets.repository.connection.DBMananger;
import iti.jets.repository.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class OrderDao {
    private EntityManager entityManager;

    public OrderDao() {
        entityManager = DBMananger.getInstance().createEntityManager();
    }

    public List<Order> getAllOrders() {
        Query query = entityManager.createQuery("SELECT p FROM Order p");
        entityManager.clear();
        return query.getResultList();
    }

    public Order getOrderByID(int OrderID) {
        Order order = entityManager.find(Order.class, OrderID);
        return order;
    }

    public boolean addOrder(Order Order) {
        if (Order != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(Order);
                entityManager.getTransaction().commit();
                return true;
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            }
        }
        return false;
    }

    public boolean deleteOrderById(int OrderID) {
        Order Order = entityManager.find(Order.class, OrderID);
        if (Order != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(Order);
                entityManager.getTransaction().commit();
                return true;
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            }

        }
        return false;
    }

    public boolean updateOrder(Order updatedOrder, int id) {
        if (updatedOrder != null) {
            try {
                entityManager.getTransaction().begin();
                Order Order = entityManager.find(Order.class, id);
                entityManager.merge(Order);
                entityManager.getTransaction().commit();
                entityManager.clear();
                return true;
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            }
        }
        return false;
    }
}
