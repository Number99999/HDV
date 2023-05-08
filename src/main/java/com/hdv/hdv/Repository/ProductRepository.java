package com.hdv.hdv.Repository;

import com.hdv.hdv.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Converter;
import javax.transaction.Transactional;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

    void deleteById(String id);

    Product findProductById(int id);

    Product findProductByName(String name);

    List<Product> findProductByCategory(String category);
//    @Query("select p.id, p.product_id, p.product_category, p.product_name, p.availability, p.price, p.image from Product p where p.product_name = :name")
//    Product findProductByProduct_name(@Param("name") String name);

//    @Query("select p.id, p.product_id, p.product_category, p.product_name, p.availability, " +
//            "p.price, p.image from Product p where p.product_category = :category")
//    List<Product> getProductByCategory(@Param("category") String cate);

    @Query("SELECT MAX(p.id) FROM Product p")
    int getMaxIdProduct();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Product WHERE id = :id")
    void deleteProductById(@Param("id") int id);

}
