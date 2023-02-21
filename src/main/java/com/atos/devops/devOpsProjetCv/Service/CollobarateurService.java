package com.atos.devops.devOpsProjetCv.Service;

import com.atos.devops.devOpsProjetCv.entities.Collaborateur;

import java.util.List;

public interface CollobarateurService {
    Collaborateur addCollaborateur(Collaborateur collaborateur);

    Collaborateur editCollaborateur(Collaborateur collaborateur, Long id);

    Collaborateur getCollaborateur(Long id);
    void deleteCollaborateur(Long id);

    List<Collaborateur> getCollabarateurs();


}
