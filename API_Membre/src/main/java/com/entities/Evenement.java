package com.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name="T_evenement_EVT")
public class Evenement {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="evt_id")
	private Long Id;

	@Column(name="evt_nom")
	private String nom;

	@Column(name="evt_date")
	private LocalDateTime date;

	@Column(name="evt_duree")
	private Long duree;

	@Column(name="evt_max")
	private Long capa;

	@ManyToMany
	@JsonIgnore
	@JoinTable(name="TJ_inscription_INS", joinColumns=@JoinColumn(name="evt_id"), inverseJoinColumns=@JoinColumn(name="mbr_id"))
	private List<Membre> membresInscrit;

	@ManyToOne
	@JoinColumn(name="lie_id")
	private Lieu lieu;

}
