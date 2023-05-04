package com.hdv.hdv.Controller;

import com.hdv.hdv.Entity.Product;
import com.hdv.hdv.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = {"/home", "/"})
    public String Home(Model model) {
        return "home";
    }

    @GetMapping("showProduct")
        public String ProductshowALl(Model model) {
        List<Product> list =  this.productService.getAllProduct();
        Product p = new Product();
//        model.addAttribute("products", list);
        model.addAttribute("products", p);
        return "product";
    }
//    public Product showAll(){
//        return productService.getAllProduct().get(0);
//    }

    @GetMapping("getproduct/{id}")
    public Product showProductById(@PathVariable int id) {
        return this.productService.getProductById(id);
    }

    @GetMapping("showProductByCate/{category}")
    public List<Product> showProductByCate(@PathVariable String category) {
        return this.productService.getProductByCategory(category);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable int id) {
        productService.deleteProductByID(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        this.productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        try {
            Product oldPro = this.productService.getProductById(id);
            oldPro.setId(product.getId());
            oldPro.setAvailability(product.getAvailability());
            oldPro.setProduct_id(product.getProduct_id());
            oldPro.setProduct_name(product.getProduct_name());
            oldPro.setProduct_category(product.getProduct_category());
            oldPro.setPrice(product.getPrice());
            oldPro.setImage(product.getImage());

            this.productService.deleteProductByID(product.getId());
            this.productService.addProduct(product);
            return ResponseEntity.ok("Updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating the product");
        }
    }



}
