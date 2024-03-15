package com.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name="T_membre_MBR")
public class Membre {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mbr_id")
	private Long Id;

	@Column(name="mbr_nom")
	private String nom;

	@Column(name="mbr_prenom")
	private String prenom;

	@Column(name="mbr_dateNaissance")
	private LocalDate dateNaiss;

	@Column(name="mbr_email")
	private String email;

	@Column(name="mbr_mdp")
	private String mdp;

	@ManyToMany(mappedBy = "membresInscrit")
	private List<Evenement> evenementsInscrit;
	
}
