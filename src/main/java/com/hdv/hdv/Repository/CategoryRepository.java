package com.hdv.hdv.Repository;

import com.hdv.hdv.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//    @Query("de")
    void deleteByName(String name);
}
