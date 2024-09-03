package com.example.ProductServiceAug24.single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("st_Learners")
public class Learner extends User {

    private String college;
    private String company;
}
