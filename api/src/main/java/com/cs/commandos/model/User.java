package com.cs.commandos.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "satuser")
@Getter
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fname")
	private String fname;

	@Column(name = "lname")
	private String lname;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private Long mobile;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private Roles role;


}
