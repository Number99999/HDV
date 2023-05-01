package com.hdv.hdv.Service;

import com.hdv.hdv.Entity.Cart;
import com.hdv.hdv.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    public void addCart(Cart cart)
    {
        this.cartRepository.save(cart);
    }

    public void deleteCartById(int id)
    {
        this.cartRepository.deleteById((long) id);
    }

//    public void deleteCartByName(String name)
//    {
//        this.cartRepository.deleteByName(name);
//    }
}
