package iti.jets.repository.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId", nullable = false)
    private Integer id;

    @Column(name = "date", columnDefinition = "TIMESTAMP")
    private LocalDateTime orderDate;

    @Column(name = "UserName", length = 45)
    private String userName;

    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

    public Order() {
    }

    public Order(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
        // this.total = 100;
        this.orderDate = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "[ id : " + id + " | userName : " + userName + " | total : " + total + " | date : " + orderDate + "]";
    }
}
