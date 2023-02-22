package com.atos.devops.devOpsProjetCv.entities;/***********************************************************************
 * Module:  Collaborateur.java
 * Author:  
 * Purpose: Defines the Class Collaborateur
 ***********************************************************************/


public class Collaborateur {
   private Long id;
   private String nom;
   private String prenom;
   private String email;
   private String telephone;
   private String adresse;
   private String posteOccupe;
   private StatusType status;

   public Collaborateur(Long id, String nom, String prenom, String email, String telephone, String adresse, String posteOccupe, StatusType status) {
      this.id = id;
      this.nom = nom;
      this.prenom = prenom;
      this.email = email;
      this.telephone = telephone;
      this.adresse = adresse;
      this.posteOccupe = posteOccupe;
      this.status = status;
   }

   public Collaborateur() {
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

   public String getPrenom() {
      return prenom;
   }

   public void setPrenom(String prenom) {
      this.prenom = prenom;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getTelephone() {
      return telephone;
   }

   public void setTelephone(String telephone) {
      this.telephone = telephone;
   }

   public String getAdresse() {
      return adresse;
   }

   public void setAdresse(String adresse) {
      this.adresse = adresse;
   }

   public String getPosteOccupe() {
      return posteOccupe;
   }

   public void setPosteOccupe(String posteOccupe) {
      this.posteOccupe = posteOccupe;
   }

   public StatusType getStatus() {
      return status;
   }

   public void setStatus(StatusType status) {
      this.status = status;
   }
}