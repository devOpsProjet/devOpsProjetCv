package com.atos.devops.devOpsProjetCv.Service;

import com.atos.devops.devOpsProjetCv.entities.Collaborateur;
import com.atos.devops.devOpsProjetCv.repositories.CollobarateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollobarateurServiceImpl implements CollobarateurService {
    private final CollobarateurRepository collaborateurRepository;

    private CollobarateurServiceImpl(CollobarateurRepository collaborateurRepository){
        this.collaborateurRepository = collaborateurRepository;
    }

    @Override
    public Collaborateur addCollaborateur(Collaborateur collaborateur) {
        return collaborateurRepository.save(collaborateur) ;
    }

    @Override
    public Collaborateur editCollaborateur(Collaborateur collaborateur, Long id) {
        collaborateur.setId(id);
        return collaborateurRepository.save(collaborateur);
    }

    @Override
    public Collaborateur getCollaborateur(Long id) {
        return collaborateurRepository.findById(id).get();
    }

    @Override
    public void deleteCollaborateur(Long id) {

        collaborateurRepository.deleteById(id);
    }

    @Override
    public List<Collaborateur> getCollabarateurs() {
        return collaborateurRepository.findAll();
    }
}
