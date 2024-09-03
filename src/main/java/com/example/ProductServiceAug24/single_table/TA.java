package com.example.ProductServiceAug24.single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("st_TA'S")
public class TA extends User {

    private int numOfQuestions;
    private String college;
}
