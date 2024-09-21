package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.Exceptions.ProductNotFoundException;
import com.example.ProductServiceAug24.dtos.FakeStoreProductDto;
import com.example.ProductServiceAug24.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakestore")
public class FakeStoreProductService implements ProductService{


    @Override
    public Product getProductById(long id) throws ProductNotFoundException {

        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("http://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product with id: "+id+" was not found");
        }

        return covertFakeStoreProductToProduct(fakeStoreProductDto);
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
