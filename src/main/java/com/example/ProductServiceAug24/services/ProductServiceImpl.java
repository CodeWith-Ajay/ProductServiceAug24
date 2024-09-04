package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.Exceptions.ProductNotFoundException;
import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("dbImpl")
@Qualifier("")
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product createProduct(String name, String category, String description) {

        Product p= productRepository.findFirstByNameAndCategory(name,category);
        if(p!=null){
            return p;
        }
        Product product =new Product();
        product.setName(name);
        product.setCategory(category);
        product.setDescription(description);
        product = productRepository.save(product);
        return product;
    }
}
