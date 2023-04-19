package com.hdv.hdv.Controller;

import com.hdv.hdv.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String checkLogin(@RequestParam String username, @RequestParam String password) {
        return Boolean.toString(userService.checkLogin(username, password));
    }

//    @GetMapping("/")
}
