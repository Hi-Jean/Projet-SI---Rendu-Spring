package com.dtos;

import com.entities.Evenement;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class LieuDto {

	private Long id;
	private String nom;
	private String adresse;
	private Long capacite;

	private List<Evenement> evenements;
	
}
