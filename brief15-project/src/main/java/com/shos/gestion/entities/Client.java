package com.shos.gestion.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="clients")
public class Client extends AppUser {

	 @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
     private Set<Command> commands = new HashSet<>();

	public Client(Long id, String nom, String prenom, String username, String password, String email,
			Collection<AppRole> appRoles, Set<Command> commands) {
		super(id, nom, prenom, username, password, email, appRoles);
		this.commands = commands;
	}

	public Client(Long id, String nom, String prenom, String username, String password, String email,
			Collection<AppRole> appRoles) {
		super(id, nom, prenom, username, password, email, appRoles);
	}
}
