package com.cs.commandos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "space_master")
@Getter
@Setter
public class SpaceMaster {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String spaceNumber; //L3-A-110
    private String spaceTrackingNumber; //internal tracking number
    private String machineId;
    private String zone;
    private String floor;
    private String building;
    private String phase;
    private String city;
    private String country;
    private String availabilityStatus;
}
