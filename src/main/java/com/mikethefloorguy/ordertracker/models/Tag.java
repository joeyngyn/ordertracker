package com.mikethefloorguy.ordertracker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag extends AbstractEntity{

    @Size(min = 1, max = 25)
    @NotBlank
    private String name;

    @ManyToMany(mappedBy = "tags")
    private final List<Order> orders = new ArrayList<>();

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {}

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return "#" + name + " ";
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getEvents() {
        return orders;
    }

    @Override
    public boolean isMatchingPassword(String password) {
        return false;
    }
}
