package com.hdv.hdv.Repository;

import com.hdv.hdv.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsernameAndPassword(String username, String password);
}
