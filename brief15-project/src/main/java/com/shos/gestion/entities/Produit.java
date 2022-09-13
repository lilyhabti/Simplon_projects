package com.shos.gestion.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produits")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String descriptif;
	private String country;
	private double prix;

	@OneToMany(mappedBy = "produit",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Command> orders = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity =Categorie.class,cascade = CascadeType.ALL )
    private Categorie categorie;
}
