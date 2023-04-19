package com.hdv.hdv.Service;

import com.hdv.hdv.Entity.User;
import com.hdv.hdv.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean checkLogin(String username, String password) {
        return userRepository.findUserByUsernameAndPassword(username, password) != null;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

}
