package com.hdv.hdv.Controller;

import com.hdv.hdv.Entity.Product;
import com.hdv.hdv.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = {"/"})
    public String Home(Model model) {
        return "home";
    }

    @GetMapping("showProduct")
    public String ProductshowALl(Model model) {
        model.addAttribute("listProduct", this.productService.getAllProduct());
        return "product";
    }

    @GetMapping("getproduct/{id}")
    public Product showProductById(@PathVariable int id) {
        return this.productService.getProductById(id);
    }

    @GetMapping("category/{cate}")
    public String showProductByCate(@PathVariable String cate, Model model)
    {
        model.addAttribute("listProduct", productService.getProductByCategory(cate));
        return "product";
    }
//    @PostMapping("category/{cate}")
//    public String showProductByCate(@PathVariable String cate, Model model) {
//        model.addAttribute("listProduct", productService.getProductByCategory(cate));
//        return "product";
//    }

    @GetMapping("delete/{id}")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "delete";
    }

    @PostMapping("delete/{id}")
    public String comfirmDelte(@PathVariable int id, RedirectAttributes redirectAttributes) {
        productService.deleteProductByID(id);
        return "redirect:/showProduct";
    }

    @GetMapping("add")
    public String showFormAdd(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("add")
    public String submitForm(@ModelAttribute Product product) {
        int id = productService.getMaxId() + 1;
        product.setId(id);
        this.productService.addProduct(product);
        return "redirect:/showProduct";
    }

    @GetMapping("update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "update";
    }

    @PostMapping("update/{id}")
    public String comfirmUpdate(@PathVariable int id, @ModelAttribute Product product) {
        product.setId(id);
        String img = product.getImage().replace(",", "");
        product.setImage(img);
        this.productService.addProduct(product);
        return "redirect:/showProduct";
    }


}
