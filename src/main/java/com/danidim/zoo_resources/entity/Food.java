package com.danidim.zoo_resources.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "foods")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "current_amount")
    private int currentAmount;
    @Column(name = "measure")
    private String measure;
    @Column(name = "type")
    private String type;
    @Column(name = "consumption")
    private int consumption;

//    @Transient
//    @ManyToMany(mappedBy = "foods")
//    private List<Animal> animals;

    public Food(int currentAmount, String measure, String type, int consumption) {
        this.currentAmount = currentAmount;
        this.measure = measure;
        this.type = type;
        this.consumption = consumption;
    }
}
