package com.macnss.helpers;

import java.util.function.Function;
import java.util.function.Supplier;

public class CalculRetraite {

    public static int calculerNombreMois(int nombreDeJours) {
        final double JOURS_PAR_MOIS = 26;
        Function<Integer, Integer> calculMois = (jours) -> {
            double nombreDeMoisDouble = jours / JOURS_PAR_MOIS;
            return (int) Math.round(nombreDeMoisDouble);
        };
        return calculMois.apply(nombreDeJours);
    }//lamda1


    public static float contSalaireRetreite(float salaire) {
        return Math.min(6000, Math.max(1000, salaire));
    }//lamda 3



    public static double calculePrixRetraite(float salaire, int totaleJourTravail){
        if (totaleJourTravail<=3240) {
            Supplier<Double> calculprixRetraiteParMois = () ->
                    salaire * (50 / 100.0);
            double prixRetraiteParMois = calculprixRetraiteParMois.get();
            prixRetraiteParMois = contSalaireRetreite((float) prixRetraiteParMois);
            return prixRetraiteParMois;
        } else if (totaleJourTravail>=7560) {
            Supplier<Double> calculprixRetraiteParMois = () ->
                    salaire * (70 / 100.0);
            double prixRetraiteParMois = calculprixRetraiteParMois.get();
            prixRetraiteParMois = contSalaireRetreite((float) prixRetraiteParMois);
            return prixRetraiteParMois;
        } else {
            int nombreDeFoisDe216 = (totaleJourTravail-3240)/216;
            Supplier<Double> calculprixRetraiteParMois = () ->
                    salaire * ((50 + nombreDeFoisDe216) / 100.0);

            double prixRetraiteParMois = calculprixRetraiteParMois.get();
            prixRetraiteParMois = contSalaireRetreite((float) prixRetraiteParMois);
            return prixRetraiteParMois;
        }
    }//lamda2
}
