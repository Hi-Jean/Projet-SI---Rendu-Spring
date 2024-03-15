package com.controllers;

import com.dtos.MembreDto;
import com.services.impl.MembreServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membre")
public class MainController {

	private final MembreServiceImpl membreService;

	public MainController(MembreServiceImpl membreService) {
		this.membreService = membreService;
	}

	/**
	 * <p>Récupère la liste de tous les membres enregistrés</p>
	 * @return List<MembreDto>
	 */
	@GetMapping
	public List<MembreDto> getMembres() {
		return this.membreService.getAllMembres();
	}

	/**
	 * <p>Récupère les détails d'un membre selon son ID</p>
	 * @return MembreDto
	 */
	@GetMapping("/{id}")
	public MembreDto getMembre(@PathVariable Long id){
		return this.membreService.getMembreById(id);
	}

	/**
	 * <p>Enregistre le membre passé dans la requête</p>
	 * @return MembreDto
	 */
	@PostMapping
	public MembreDto saveMembre(final @RequestBody MembreDto membreDto){
		return this.membreService.saveMembre(membreDto);
	}

	/**
	 * <p>Met à jour les détails d'un membre selon son ID</p>
	 * @return MembreDto
	 */
	@PutMapping("/{id}")
	public MembreDto updateMembre(@PathVariable Long id, final @RequestBody MembreDto membreDto){
		return this.membreService.updateMembre(id, membreDto);
	}


	/**
	 * <p>Supprime un membre selon son ID</p>
	 * @return Boolean
	 */
	@DeleteMapping("/{id}")
	public Boolean deleteMembre(@PathVariable Long id){
		return this.membreService.deleteMembre(id);
	}
	
}
