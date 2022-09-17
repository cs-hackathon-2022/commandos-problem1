package com.cs.commandos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "floor")
@Getter
@Setter
public class Floor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "numberOfZones")
    private long numberOfZones;

    @Column(name = "totalSeats")
    private long totalSeats;

}
