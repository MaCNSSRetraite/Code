package com.macnss.Model;

public class SalaireBuilder {
    private String matrecule;
    private float salaire;
    private String date;

    public SalaireBuilder matrecule(String matrecule) {
        this.matrecule = matrecule;
        return this;
    }
    public SalaireBuilder salaire(float salaire) {
        this.salaire = salaire;
        return this;
    }
    public SalaireBuilder date(String date) {
        this.date = date;
        return this;
    }
    public Salaire build(){
        return new Salaire(matrecule, salaire, date);
    }
}
