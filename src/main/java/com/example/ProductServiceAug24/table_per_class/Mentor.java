package com.example.ProductServiceAug24.table_per_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="tpc_Mentors")
public class Mentor extends User {

    private double avgrating;
    private String currentCompany;
}
