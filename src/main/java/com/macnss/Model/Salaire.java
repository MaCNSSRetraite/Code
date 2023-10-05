package com.macnss.Model;

public class Salaire {
    private String matrecule;
    private float salaire;
    private String date;

    public Salaire() {
    }

    public Salaire(String matrecule, float salaire, String date) {
        this.matrecule = matrecule;
        this.salaire = salaire;
        this.date = date;
    }

    public String getMatrecule() {
        return matrecule;
    }

    public void setMatrecule(String matrecule) {
        this.matrecule = matrecule;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public static SalaireBuilder builder(){
        return new SalaireBuilder();
    }

    @Override
    public String toString() {
        return "salaire{" +
                "matrecule='" + matrecule + '\'' +
                ", salaire=" + salaire +
                ", date=" + date +
                '}';
    }
}
