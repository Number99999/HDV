package com.hdv.hdv.Controller;

import com.hdv.hdv.Entity.Category;
import com.hdv.hdv.Entity.Product;
import com.hdv.hdv.Service.CategoryService;
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
    @Autowired
    CategoryService categoryService;

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
        try{
            Category cate = new Category();
            cate.setName_product("duong");
            cate.setName("con nguoi");
            this.categoryService.addCate(cate);
            Product p = new Product("duong", "duong", "duong", "duong", 10, "Duong", 10);
            productService.addProduct(p);}
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable String id) {
        productService.deleteProductByID(id);
        Product product = productService.getProductById(Integer.parseInt(id));
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
