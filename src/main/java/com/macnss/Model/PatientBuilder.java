package com.macnss.Model;

import java.util.Date;

public class PatientBuilder {
    private String matrecule;
    private String nom;
    private String prenom;
    private String email;
    private float salaire;
    private String statusRetraite;
    private float prixRetraite;
    private int totaleJourTravail;
    private String matreculeSociete;
    private String date_naissance;

    public PatientBuilder matrecule(String matrecule) {
        this.matrecule = matrecule;
        return this;
    }

    public PatientBuilder nom(String nom) {
        this.nom = nom;
        return this;
    }

    public PatientBuilder prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public PatientBuilder email(String email) {
        this.email = email;
        return this;
    }
    public PatientBuilder salaire(float salaire) {
        this.salaire = salaire;
        return this;
    }

    public PatientBuilder statusRetraite(String statusRetraite) {
        this.statusRetraite = statusRetraite;
        return this;
    }

    public PatientBuilder prixRetraite(float prixRetraite) {
        this.prixRetraite = prixRetraite;
        return this;
    }

    public PatientBuilder totaleJourTravail(int totaleJourTravail) {
        this.totaleJourTravail = totaleJourTravail;
        return this;
    }
    public PatientBuilder matreculeSociete(String matreculeSociete) {
        this.matreculeSociete = matreculeSociete;
        return this;
    }
    public PatientBuilder date_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
        return this;
    }

    public Patient build(){
        return new Patient(matrecule, nom, prenom, email, salaire, statusRetraite, prixRetraite, totaleJourTravail, matreculeSociete, date_naissance);
    }
}
