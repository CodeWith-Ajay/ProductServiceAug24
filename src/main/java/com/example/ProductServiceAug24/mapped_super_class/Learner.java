package com.example.ProductServiceAug24.mapped_super_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="msc_Learners")
public class Learner extends User{

    private String college;
    private String company;
}
