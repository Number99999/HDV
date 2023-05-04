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

    void deleteById(String id);

    Product findProductById(int id);

    @Query("select p.id, p.product_id, p.product_category, p.product_name, p.availability, p.price, p.image from Product p where p.product_name = :name")
    Product findProductByProduct_name(@Param("name") String name);

    @Query("select p.id, p.product_id, p.product_category, p.product_name, p.availability, p.price, p.image from Product p where p.product_category = :cate")
    List<Product> findProductByCategory(@Param("cate") String cate);

    @Query("SELECT MAX(p.id) FROM Product p")
    int getMaxIdProduct();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Product WHERE id = :id")
    void deleteProductById(@Param("id") int id);

//    void deleteProductByProductId(@Param("id") String id);


//    @Query("select product.* from product  join category on  product.id = category.id_product and category.name = :cate group by id_product")
//@Query("select p.id, p.name, p.image, p.description, p.size, p.price, p.brand, p.quantity from Product p join Category c on p.id = c.name_product and c.name = :cate group by name_product")
//List<Product> getAllProductByCategory(@Param("cate") String cate);
}
