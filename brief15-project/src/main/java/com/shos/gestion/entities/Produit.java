package com.shos.gestion.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@OneToMany(mappedBy = "produit",cascade = CascadeType.ALL)
	private Set<Command> orders = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Categorie.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id", insertable = false, updatable = false)
    @JsonIgnore
    private Categorie categorie;
    @Column(name = "categorie_id")
    private Long categorie_id;
	
//	@ManyToOne(fetch = FetchType.LAZY,targetEntity =Categorie.class,cascade = CascadeType.ALL )
//    private Categorie categorie;
//	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Categorie.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "categorie_id")
//    @JsonIgnore
//    private Categorie categorie;
//    private Long categoryId;
}
