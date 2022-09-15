package com.shos.gestion.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="commands")
public class Command {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateCommand;
	private double prixTotal;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    private Client client;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//    private Produit produit;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Client.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Client client;
    @Column(name = "client_id")
    private Long client_id;
    
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Produit.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Produit produit;
    @Column(name = "produit_id")
    private Long produit_id;
}
