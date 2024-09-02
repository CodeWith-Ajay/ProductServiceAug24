package com.example.ProductServiceAug24.joined_table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name="jt_Mentors")
@PrimaryKeyJoinColumn(name="user_id")
public class Mentor extends User {

    private double avgrating;
    private String currentCompany;
}
