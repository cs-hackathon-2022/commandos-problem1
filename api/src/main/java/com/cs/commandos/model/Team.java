package com.cs.commandos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "team_details")
@Getter
public class Team {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String teamName;

//	@OneToOne
//	@JoinColumn(name = "team_owner_id", referencedColumnName = "id",
//	foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//	private Employee teamOwner;


	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private List<Employee> employees;

}
