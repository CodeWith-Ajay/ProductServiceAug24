package com.example.ProductServiceAug24.single_table;

import jakarta.persistence.*;
import lombok.Data;

//@Setter
//@Getter or @Data
@Data
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "st_user_type")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
}
