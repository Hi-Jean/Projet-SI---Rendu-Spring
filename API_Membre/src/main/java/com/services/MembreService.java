package com.services;

import com.dtos.MembreDto;

import java.util.List;

public interface MembreService {
    /**
     * Enregistre un membre
     */
    MembreDto saveMembre(MembreDto membreDto);

    /**
     * Récupère les détails d'un membre selon son ID
     */
    MembreDto getMembreById(Long membreId);

    /**
     * Supprime un membre selon son ID
     */
    boolean deleteMembre(Long membreId);

    /**
     * Récupère la liste des membres enregistrés
     */
    List<MembreDto> getAllMembres();


    /**
     * Met à jour les détails d'un membre selon son ID
     */
    MembreDto updateMembre(Long membreId, MembreDto membreDto);


}
