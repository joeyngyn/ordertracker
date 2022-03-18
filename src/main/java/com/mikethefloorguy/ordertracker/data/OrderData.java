package com.mikethefloorguy.ordertracker.data;

import com.mikethefloorguy.ordertracker.models.Order;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OrderData {

    private static Map<Integer, Order> orders = new HashMap<>();

    public static Collection<Order> getAll() {
        return orders.values();
    }

    public static Order getById(int id){
        return orders.get(id);
    }

    public static void add(Order order) {
        orders.put(order.getId(), order);
    }

    public static void remove(int id) {
        orders.remove(id);
    }
}
