package com.example.ProductServiceAug24.single_table;

import jakarta.persistence.DiscriminatorValue;
import lombok.Data;

@Data
@DiscriminatorValue("st_Learners")
public class Learner extends User {

    private String college;
    private String company;
}
