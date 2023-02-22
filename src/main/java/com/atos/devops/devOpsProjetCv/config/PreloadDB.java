/* Created by El Hadji M. NDONGO  */
/* on 22 02 2023 */
/* Project: devOpsProjetCv */

package com.atos.devops.devOpsProjetCv.config;

import com.atos.devops.devOpsProjetCv.entities.Collaborateur;
import com.atos.devops.devOpsProjetCv.entities.Departement;
import com.atos.devops.devOpsProjetCv.entities.Projet;
import com.atos.devops.devOpsProjetCv.entities.StatusType;
import com.atos.devops.devOpsProjetCv.repositories.CollaborateurRepository;
import com.atos.devops.devOpsProjetCv.repositories.DepartementRepository;
import com.atos.devops.devOpsProjetCv.repositories.ProjetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class PreloadDB {
    @Bean
    CommandLineRunner preloadDB(CollaborateurRepository collaborateur, ProjetRepository projet, DepartementRepository departement) {
        return (args -> {
            Collaborateur col1 = new Collaborateur(null, "Ndiaye", "Cheikh", "cheikh@atos.net", "77 100 00 01", "HLM 2 Dakar", "Developpeur", StatusType.CDI);
            Collaborateur col2 = new Collaborateur(null, "Mbacke", "Sokhna Diarra", "sokhna@atos.net", "77 200 00 01", "Touba", "Scrum Master", StatusType.CDI);
            Collaborateur col3 = new Collaborateur(null, "Diakhate", "Mame Khady", "mkhady@atos.net", "77 300 00 01", "Ben Tally", "Manager", StatusType.CDI);
            Collaborateur col4 = new Collaborateur(null, "Ndongo", "El Hadji", "ndongo@atos.net", "77 400 00 01", "Tivaouane", "Developpeur", StatusType.CDD);
            collaborateur.save(col1);
            collaborateur.save(col2);
            collaborateur.save(col3);
            collaborateur.save(col4);

            Projet projet1 = new Projet(null, "WoldLine", "Java, PHP, React", new Date(), new Date());
            Projet projet2 = new Projet(null, "ElTogo", "Java, PHP, React", new Date(), new Date());
            Projet projet3 = new Projet(null, "DiversIT", "Java, Angular, React", new Date(), new Date());
            Projet projet4 = new Projet(null, "Port 3.0", "Java, PHP, Spring", new Date(), new Date());
            projet.save(projet1);
            projet.save(projet2);
            projet.save(projet3);
            projet.save(projet4);

            Departement dep1 = new Departement(null, "ressources Humaines");
            Departement dep2 = new Departement(null, "Informatique");
            Departement dep3 = new Departement(null, "Communication");
            Departement dep4 = new Departement(null, "Formation");

            departement.save(dep1);
            departement.save(dep2);
            departement.save(dep3);
            departement.save(dep4);
        });
    }
}
