package com.dtos;

import com.entities.Lieu;
import com.entities.Membre;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class EvenementDto {

	private Long Id;
	private String nom;
	@JsonFormat(pattern="HH:mm:ss dd-MM-yyyy")
	private LocalDateTime date;
	private Long duree;

	private Long capa;

	private List<Membre> membresInscrit;

	private Lieu lieu;

}
