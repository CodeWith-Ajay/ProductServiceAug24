package com.example.ProductServiceAug24.single_table;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("st_Mentors")
public class Mentor extends User {

    private double avgrating;
    private String currentCompany;
}
