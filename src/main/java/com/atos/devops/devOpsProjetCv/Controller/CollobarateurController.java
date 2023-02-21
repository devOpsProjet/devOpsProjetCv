package com.atos.devops.devOpsProjetCv.Controller;

import com.atos.devops.devOpsProjetCv.Service.CollobarateurService;
import org.springframework.web.bind.annotation.*;
import com.atos.devops.devOpsProjetCv.entities.Collaborateur;

import java.util.List;


@RestController
@RequestMapping("/collaborateur")
public class CollobarateurController {

    CollobarateurService collobarateurService;
    public CollobarateurController(CollobarateurService collobarateurService){
        this.collobarateurService = collobarateurService;
    }
    @PostMapping
    public Collaborateur addCollobarateur(@RequestBody Collaborateur collaborateur){
        return collobarateurService.addCollaborateur(collaborateur);
    }

    @PatchMapping("/{id}")
    public Collaborateur editCollaborateur(@RequestBody Collaborateur collaborateur, @PathVariable Long id){
        return collobarateurService.editCollaborateur(collaborateur , id);
    }

    @DeleteMapping("/{id}")
    public void deleteCollaborateur(@PathVariable Long id){
        collobarateurService.deleteCollaborateur(id);
    }
    @GetMapping
    public List<Collaborateur> getCollaborateur(){
        return collobarateurService.getCollabarateurs();
    }
    @GetMapping("/{id}")
    public Collaborateur getCollaborateur(@PathVariable Long id){
        return collobarateurService.getCollaborateur(id);
    }

}
