package com.hdv.hdv.Repository;

import com.hdv.hdv.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

    @Override
    void deleteById(Long id);

    Product findProductById(Long id);

    Product findProductByName(String name);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Product WHERE id = :id")
    void deleteProductById(@Param("id") int id);

//    @Query("select * from product join cart on product.category = and cart.")
}
