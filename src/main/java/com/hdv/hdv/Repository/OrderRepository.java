package com.hdv.hdv.Repository;

import com.hdv.hdv.Entity.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Long> {
//    void deleteByName(String name);
}
