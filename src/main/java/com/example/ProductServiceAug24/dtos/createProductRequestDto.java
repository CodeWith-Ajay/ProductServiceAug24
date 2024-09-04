package com.example.ProductServiceAug24.dtos;

import lombok.Data;

@Data
public class createProductRequestDto {
    String name;
    String category;
    String description;
}
