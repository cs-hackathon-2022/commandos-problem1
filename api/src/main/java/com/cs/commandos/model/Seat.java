package com.cs.commandos.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "seat")
@Getter
public class Seat {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seatNumber")
    private String seatNumber;

    @Column(name = "status")
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zone_id", referencedColumnName = "id")
    private Zone zone;
}
