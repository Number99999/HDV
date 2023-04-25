package com.hdv.hdv.Controller;

import com.hdv.hdv.Entity.Product;
import com.hdv.hdv.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/hello")
    public String hello() {
        return "this is my site";
    }

    @GetMapping("showProduct")
    public Product ProductshowALl() {
        List<Product> list = this.productService.getAllProduct();
        return list.get(0);
    }

    @GetMapping("add")
    public void addProduct() {
        Product p = new Product("duong", "duong", "duong", "duong", 10, "duong", "Duong", 10);
        productService.addProduct(p);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable String id) {
        productService.deleteProductByID(id);
        return ResponseEntity.ok().build();
    }
//        try {
//            productService.deleteProductByID(id);
//            return "Done";
//        } catch (Exception e) {
//            return "false" + e;
//        }
//    }

}
