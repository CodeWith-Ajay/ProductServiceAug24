package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.Exceptions.ProductNotFoundException;
import com.example.ProductServiceAug24.dtos.FakeStoreProductDto;
import com.example.ProductServiceAug24.dtos.createProductRequestDto;
import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service("dbImpl")

public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        Optional<Product>OptionalProduct = productRepository.findById(id);
        if(OptionalProduct.isPresent()){
            return  OptionalProduct.get();

        }
        else{
            throw new ProductNotFoundException("Product not found in Mysql DB");
        }
    }



    private Product covertcreateProductToProduct(createProductRequestDto dto) {
        Product product = new Product();
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
        product.setName(dto.getName());
        return product;
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
