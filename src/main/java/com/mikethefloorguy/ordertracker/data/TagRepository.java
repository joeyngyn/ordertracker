package com.mikethefloorguy.ordertracker.data;

import com.mikethefloorguy.ordertracker.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
}
