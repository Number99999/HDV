package com.hdv.hdv.Service;

import com.hdv.hdv.Entity.Product;
import com.hdv.hdv.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductByID(String id) {
        productRepository.deleteProductById(Integer.parseInt(id));
//        productRepository.deleteById(Long.parseLong(id));
    }


}
