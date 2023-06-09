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

    public Product getProductById(int id) {
        return productRepository.findProductById(id);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductByID(int id) {
        productRepository.deleteProductById(id);
    }


    public Product getProductByName(String name) {
        return productRepository.findProductByName(name);
    }


    public List<Product> getProductByCategory(String category)
    {
        return productRepository.findProductByCategory(category);
    }

    public int getMaxId()
    {
        return productRepository.getMaxIdProduct();
    }
}
