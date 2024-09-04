package com.example.ProductServiceAug24.cardinalities.OnetoOne.ManytoMany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Items {
    @Id
    long id;
    String name;

    @ManyToMany(mappedBy = "items")
    List<Tags> tags;
}
