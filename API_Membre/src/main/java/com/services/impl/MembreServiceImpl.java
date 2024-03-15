package com.services.impl;

import com.dtos.MembreDto;
import com.entities.Membre;
import com.repositories.MembreRepository;
import com.services.MembreService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service("membreService")
public class MembreServiceImpl implements MembreService {

    private final MembreRepository membreRepository;

    public MembreServiceImpl(MembreRepository membreRepository){
        this.membreRepository = membreRepository;
    }

    @Override
    public MembreDto saveMembre(MembreDto membreDto) {
        Membre membre = membreDtoToEntity(membreDto);
        membre.setId(null);
        membre = membreRepository.save(membre);
        return membreEntityToDto(membre);
    }

    @Override
    public MembreDto getMembreById(Long membreId) {
        Membre membre = this.membreRepository.findById(membreId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Membre not found"));
        return membreEntityToDto(membre);
    }


    @Override
    public boolean deleteMembre(Long membreId) {
        Membre membre = this.membreRepository.findById(membreId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Membre not found"));
        this.membreRepository.delete(membre);
        return true;
    }

    @Override
    public List<MembreDto> getAllMembres() {
        List<MembreDto> membresDto = new ArrayList<>();
        List<Membre> membres = this.membreRepository.findAll();
        for (Membre e : membres) {
            membresDto.add(membreEntityToDto(e));
        }
        return membresDto;
    }

    @Override
    public MembreDto updateMembre(Long membreId, MembreDto membreDto) {
        Membre membre = this.membreRepository.findById(membreId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Membre not found"));

        membre.setNom(membreDto.getNom());
        membre.setPrenom(membreDto.getPrenom());
        membre.setDateNaiss(membreDto.getDateNaiss());
        membre.setEmail(membreDto.getEmail());
        membre.setMdp(membreDto.getMdp());

        membre = this.membreRepository.save(membre);
        return this.membreEntityToDto(membre);
    }


    /**
     * Map membre dto to membre entity
     */
    private MembreDto membreEntityToDto(Membre membre){
        MembreDto membreDto = new MembreDto();
        membreDto.setId(membre.getId());
        membreDto.setNom(membre.getNom());
        membreDto.setPrenom(membre.getPrenom());
        membreDto.setDateNaiss(membre.getDateNaiss());
        membreDto.setEmail(membre.getEmail());
        membreDto.setMdp(membre.getMdp());
        membreDto.setEvenementsInscrit(membre.getEvenementsInscrit());
        return membreDto;
    }

    /**
     * Map membre entity to membre dto
     */
    private Membre membreDtoToEntity(MembreDto membreDto) {
        Membre membre = new Membre();
        membre.setId(membreDto.getId());
        membre.setNom(membreDto.getNom());
        membre.setPrenom(membreDto.getPrenom());
        membre.setDateNaiss(membreDto.getDateNaiss());
        membre.setEmail(membreDto.getEmail());
        membre.setMdp(membreDto.getMdp());
        membre.setEvenementsInscrit(membreDto.getEvenementsInscrit());
        return membre;
    }
}
