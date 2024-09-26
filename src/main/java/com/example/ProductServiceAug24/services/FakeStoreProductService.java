package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.Exceptions.ProductNotFoundException;
import com.example.ProductServiceAug24.dtos.FakeStoreProductDto;
import com.example.ProductServiceAug24.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakestore")
public class FakeStoreProductService implements ProductService{

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {

        //call redis ache before calling api by using redis
       Product product=(Product)this.redisTemplate.opsForHash().get("PRODUCTS","products_"+id);
       if(product!=null)return product;

        String url="https://fakestoreapi.com/products/" + id;
        FakeStoreProductDto fakeStoreProductDto = this.restTemplate.getForObject( url, FakeStoreProductDto.class);
        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product with id: "+id+" was not found");
        }

        product=covertFakeStoreProductToProduct(fakeStoreProductDto);
        this.redisTemplate.opsForHash().put("PRODUCTS","products_"+id,product);
        return product;
    }

    @Override
    public Product createProduct(String name, String category, String description) {


        return null;
    }

    @Override
    public Page<Product> getAllProducts(int pageSize, int pageNum) {
        return null;
    }

    private Product covertFakeStoreProductToProduct(FakeStoreProductDto dto) {
        Product product = new Product();
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
        product.setName(dto.getTitle());
        return product;
    }
}
