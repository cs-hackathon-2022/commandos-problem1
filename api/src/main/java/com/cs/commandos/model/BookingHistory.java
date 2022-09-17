package com.cs.commandos.model;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bookinghistory")
@Getter
public class BookingHistory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fromDate")
    private Timestamp fromDate;

    @Column(name = "toDate")
    private Timestamp toDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_Id", referencedColumnName = "id")
    private Seat seat;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_Id", referencedColumnName = "id")
    private Employee employee;
}
