package com.example.ProductServiceAug24.cardinalities.OnetoOne.ManytoOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Batches {
    @Id
    long id;
    String name;

    @OneToMany(mappedBy = "batches")
    List<Learners>l;
}
