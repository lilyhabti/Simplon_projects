package com.example.gestion.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ID_Role;
	
	private String Nom;
	
	@OneToMany(mappedBy="role")
    private Set<Users> users;
}
