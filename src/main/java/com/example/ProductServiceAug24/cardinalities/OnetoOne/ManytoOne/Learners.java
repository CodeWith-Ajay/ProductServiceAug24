package com.example.ProductServiceAug24.cardinalities.OnetoOne.ManytoOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Learners {
    @Id
    long id;
    String name;

    @ManyToOne
    Batches batches;
}
