package com.example.ProductServiceAug24.respositories;

import com.example.ProductServiceAug24.Projections.ProductInfo;
import com.example.ProductServiceAug24.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findFirstByNameAndCategory(String name, String category);
    List<Product> findAll();
    Optional<Product> findById(long id);
    List<Product> findAllByCategory(String category);
    List<Product>findAllByNameLike(String name);
    List<Product>findAllByNameLikeIgnoreCase(String name);
    List<Product>findAllByIdIsLessThan(Long id);

    @Query("select p from Products p where p.id=:id")
    List<Product> selectByid(Long id);

    @Query(value = "select * from Products where id= id", nativeQuery = true)
    Product selectByid2(Long id);

    @Query(nativeQuery = true,
    value="select p.id,p.name,p.description as descp from Products p where id=:id")
    ProductInfo getProductInfo(Long id);


    Page<Product> findAll(Pageable pageable);
}





