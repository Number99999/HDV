package com.hdv.hdv.Controller;

import com.hdv.hdv.Entity.Product;
import com.hdv.hdv.Service.ProductService;
import com.hdv.hdv.Service.UploadImgurByByte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    UploadImgurByByte uploadImgurByByte;

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
    public String submitForm(@ModelAttribute Product product, @RequestParam("imagee") MultipartFile imageFile) throws IOException {
        int id = productService.getMaxId() + 1;
        String img = "";
        if(imageFile.isEmpty()==false)
        {
            byte[] imageData = imageFile.getBytes();
            img = uploadImgurByByte.getLink(imageData);
        }
        product.setId(id);
        product.setImage(img);
        this.productService.addProduct(product);
        return "redirect:/showProduct";
    }

    @GetMapping("update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "update";
    }

    @PostMapping("update/{id}")
    public String comfirmUpdate(@PathVariable int id, @ModelAttribute Product product, @RequestParam("imagee") MultipartFile imageFile) throws IOException {
        product.setId(id);
        String img = product.getImage().replace(",", "");
        if(imageFile.isEmpty()==false)
        {
            byte[] imageData = imageFile.getBytes();
            img = uploadImgurByByte.getLink(imageData);
        }
        product.setImage(img);
        this.productService.addProduct(product);
        return "redirect:/showProduct";
    }
}
