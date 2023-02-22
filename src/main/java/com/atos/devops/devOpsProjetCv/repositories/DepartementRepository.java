/* Created by El Hadji M. NDONGO  */
/* on 22 02 2023 */
/* Project: devOpsProjetCv */

package com.atos.devops.devOpsProjetCv.repositories;

import com.atos.devops.devOpsProjetCv.entities.Collaborateur;
import com.atos.devops.devOpsProjetCv.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DepartementRepository extends JpaRepository<Departement,Long> {
}
