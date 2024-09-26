package com.example.ProductServiceAug24.controllers;

import com.example.ProductServiceAug24.Exceptions.ProductNotFoundException;
import com.example.ProductServiceAug24.dtos.createProductRequestDto;
import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.services.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    @Qualifier("fakestore")
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) throws ProductNotFoundException {

//    if (productId < 1 || productId > 20) {
//        return new ResponseEntity<>(HttpStatusCode.valueOf(400));
//    }
    Product product= productService.getProductById(productId);
    return ResponseEntity.ok(product);
    }

    @PostMapping()
    public Product createProduct(@RequestBody createProductRequestDto requestDto) throws Exception {
        if(requestDto.getName() ==null || requestDto.getCategory()==null || requestDto.getDescription()==null){
            throw new Exception("Database Columns Mismatch");
        }
        System.out.println(requestDto);
        return productService.createProduct(requestDto.getName(), requestDto.getCategory(), requestDto.getDescription());
    }
    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(
            @RequestParam(value = "pageSize",defaultValue = "20") int pageSize,
            @RequestParam(value = "pageNum",defaultValue = "0") int pageNum) {

        Page<Product>products= productService.getAllProducts(pageSize,pageNum);
        return ResponseEntity.ok(products);
    }

}
