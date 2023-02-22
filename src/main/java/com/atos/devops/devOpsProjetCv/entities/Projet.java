package com.atos.devops.devOpsProjetCv.entities;/***********************************************************************
 * Module:  Projet.java
 * Author:  
 * Purpose: Defines the Class Projet
 ***********************************************************************/

import java.util.*;
public class Projet {
   private Long id;
   private String nom;
   private String techno;
   private Date dateDebut;
   private Date dateFin;

   public Projet() {
   }

   public Projet(Long id, String nom, String techno, Date dateDebut, Date dateFin) {
      this.id = id;
      this.nom = nom;
      this.techno = techno;
      this.dateDebut = dateDebut;
      this.dateFin = dateFin;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getNom() {
      return nom;
   }

   public void setNom(String nom) {
      this.nom = nom;
   }

   public String getTechno() {
      return techno;
   }

   public void setTechno(String techno) {
      this.techno = techno;
   }

   public Date getDateDebut() {
      return dateDebut;
   }

   public void setDateDebut(Date dateDebut) {
      this.dateDebut = dateDebut;
   }

   public Date getDateFin() {
      return dateFin;
   }

   public void setDateFin(Date dateFin) {
      this.dateFin = dateFin;
   }
}