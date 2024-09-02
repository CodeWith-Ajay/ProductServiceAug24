package com.example.ProductServiceAug24.joined_table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

//@Setter
//@Getter or @Data
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name= "jt_Users")
public class User {
    @Id
    private int id;
    private String name;
    private String email;
    private String password;
}
