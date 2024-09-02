package com.example.ProductServiceAug24.joined_table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name="jt_TAS")
@PrimaryKeyJoinColumn(name="user_id")
public class TA extends User {

    private int numOfQuestions;
    private String college;
}
