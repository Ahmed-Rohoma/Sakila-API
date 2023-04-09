package iti.jets.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {

    private int orderID;
    private String userName;

    public Order() {
    }

    public Order(int orderID, String userName) {
        this.orderID = orderID;
        this.userName = userName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "[order Id : " + orderID + " User Name : " + userName + " ]";
    }

}
