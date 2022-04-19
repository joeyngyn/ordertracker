package com.mikethefloorguy.ordertracker.models;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderCategory extends AbstractEntity {
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @OneToMany(mappedBy = "orderCategory")
    private final List<Order> orders = new ArrayList<>();

    public OrderCategory(@Size(min = 3, message = "Name must be at least 3 characters.") String name) {
        this.name = name;
    }

    public OrderCategory() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return name; }

    @Override
    public boolean isMatchingPassword(String password) {
        return false;
    }
}
