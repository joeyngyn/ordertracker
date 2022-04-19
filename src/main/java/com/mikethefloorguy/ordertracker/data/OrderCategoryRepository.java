package com.mikethefloorguy.ordertracker.data;

import com.mikethefloorguy.ordertracker.models.OrderCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCategoryRepository extends CrudRepository<OrderCategory, Integer> {
}
