package com.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name="T_lieu_LIE")
public class Lieu {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="lie_id")
	private Long id;

	@Column(name="lie_nom")
	private String nom;

	@Column(name="lie_adresse")
	private String adresse;

	@Column(name="lie_capacite")
	private Long capacite;

	@OneToMany(mappedBy = "lieu")
	@JsonIgnore
	private List<Evenement> evenements;
	
}
