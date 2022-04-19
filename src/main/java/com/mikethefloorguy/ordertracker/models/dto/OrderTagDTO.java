package com.mikethefloorguy.ordertracker.models.dto;

import com.mikethefloorguy.ordertracker.models.Order;
import com.mikethefloorguy.ordertracker.models.Tag;

import javax.validation.constraints.NotNull;

public class OrderTagDTO {

    @NotNull
    private Order order;

    @NotNull
    private Tag tag;

    public OrderTagDTO() {}

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
