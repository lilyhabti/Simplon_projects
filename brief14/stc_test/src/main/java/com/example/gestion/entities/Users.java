package com.example.gestion.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long ID_User;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String email;
	private String telephone;
	
	@ManyToOne
    @JoinColumn(name="ID_Role", nullable=false)
    private Role role;
}
