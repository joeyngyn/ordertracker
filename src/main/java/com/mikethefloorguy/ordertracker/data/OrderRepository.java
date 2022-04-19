package com.mikethefloorguy.ordertracker.data;

import com.mikethefloorguy.ordertracker.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
