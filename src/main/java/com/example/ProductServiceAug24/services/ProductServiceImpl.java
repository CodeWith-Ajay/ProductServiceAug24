package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.Exceptions.ProductNotFoundException;
import com.example.ProductServiceAug24.Projections.ProductInfo;
import com.example.ProductServiceAug24.dtos.createProductRequestDto;
import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbImpl")

public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        ProductInfo productInfo = productRepository.getProductInfo(id);
        System.out.println(productInfo.getId());
        System.out.println(productInfo.getName());
        System.out.println(productInfo.getDescp());



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

    @Override
    public Page<Product> getAllProducts(int pageSize, int pageNum) {
        return productRepository.findAll(PageRequest.of(pageNum, pageSize, Sort.by("name").descending().and
                (Sort.by("category"))));
    }
}
