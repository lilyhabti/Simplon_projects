package com.shos.gestion.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "commands",joinColumns = @JoinColumn(name = "client_id"),inverseJoinColumns = @JoinColumn(name = "produit_id"))
	private Set<Produit> commandes = new HashSet<>();

	public Client(Long id, String nom, String prenom, String username, String password, String email,
			Collection<AppRole> appRoles, Set<Produit> commandes) {
		super(id, nom, prenom, username, password, email, appRoles);
		this.commandes = commandes;
	}
}
