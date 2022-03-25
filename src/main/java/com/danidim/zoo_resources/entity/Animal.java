package com.danidim.zoo_resources.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "animals")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "kind")
    private String kind;
    @Column(name = "predator")
    private Boolean isPredator;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "animals_foods",
            joinColumns = @JoinColumn(name = "animals_id"),
            inverseJoinColumns = @JoinColumn(name = "foods_id"))
    private List<Food> foods = new ArrayList<>();

    public Animal(String name, String kind, Boolean isPredator) {
        this.name = name;
        this.kind = kind;
        this.isPredator = isPredator;
    }
}

