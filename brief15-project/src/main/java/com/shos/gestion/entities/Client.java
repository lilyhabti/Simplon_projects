package com.shos.gestion.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

	 @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true)
     private List<Command> commands = new ArrayList<>();

	public Client(Long id, String nom, String prenom, String username, String password, String email,
			Collection<AppRole> appRoles, List<Command> commands) {
		super(id, nom, prenom, username, password, email, appRoles);
		this.commands = commands;
	}
}
