package com.hdv.hdv.Service;

import com.hdv.hdv.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void deleteById(int id)
    {
        this.orderRepository.deleteById((long) id);
    }
}
