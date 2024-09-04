package com.example.ProductServiceAug24.respositories;

import com.example.ProductServiceAug24.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findFirstByNameAndCategory(String name, String category);
    List<Product> findAll();
    Product findById(long id);
    List<Product> findAllByCategory(String category);

}




