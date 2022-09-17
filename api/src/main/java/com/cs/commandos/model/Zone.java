package com.cs.commandos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "zone")
@Getter
@Setter
public class Zone {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zoneName")
    private String zoneName;

    @Column(name = "seatStart")
    private String seatStart;

    @Column(name = "seatEnd")
    private String seatEnd;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "owner_id", referencedColumnName = "id")
//    private SpaceOwner spaceOwner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "floor_id", referencedColumnName = "id")
    private Floor floor;
}
