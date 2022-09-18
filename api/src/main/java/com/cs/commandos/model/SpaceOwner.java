package com.cs.commandos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "spaceowner")
@Getter
@Setter
public class SpaceOwner {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seatStart")
    private int seatStart;

    @Column(name = "seatEnd")
    private int seatEnd;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    private Employee employee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zone_id", referencedColumnName = "id")
    private Zone zone;
}
