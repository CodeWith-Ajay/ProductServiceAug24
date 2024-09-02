package com.example.ProductServiceAug24.single_table;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import lombok.Data;

@Data
@DiscriminatorValue("st_Mentors")
public class Mentor extends User {

    private double avgrating;
    private String currentCompany;
}
