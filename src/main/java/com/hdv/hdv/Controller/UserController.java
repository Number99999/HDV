package com.hdv.hdv.Controller;

import com.hdv.hdv.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public String checkLogin(@RequestParam String username, @RequestParam String password, Model model) {
        return Boolean.toString(userService.checkLogin(username, password));
    }

//    @GetMapping("/")
}
