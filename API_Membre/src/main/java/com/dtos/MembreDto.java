package com.dtos;

import com.entities.Evenement;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class MembreDto {

	private Long Id;
	private String nom;
	private String prenom;
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dateNaiss;
	private String email;
	private String mdp;

	private List<Evenement> evenementsInscrit;
	
}
