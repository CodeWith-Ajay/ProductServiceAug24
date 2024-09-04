package com.example.ProductServiceAug24.dtos;

import lombok.Data;

@Data
public class FakeStoreProductDto {

    long id;
    String title;
    String price;
    String description;
    String Category;
    String image;

}