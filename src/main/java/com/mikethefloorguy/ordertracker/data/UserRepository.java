package com.mikethefloorguy.ordertracker.data;

import com.mikethefloorguy.ordertracker.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
