package com.cs.commandos.model;

import liquibase.pro.packaged.E;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "role")
@Getter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String roleCode;
    private String roleType;
    private String description;
    @CreationTimestamp
    @Column(updatable = false)
    Timestamp createdOn;
    @UpdateTimestamp
    Timestamp modifiedOn;
}
