package com.macnss.helpers;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class CalculRetraite {

    // Lambda function to calculate the percentage based on salaire and totaleJourTravail
    private static BiFunction<Float, Integer, Double> calculatePercentage = (salaire, totaleJourTravail) -> {
        if (totaleJourTravail <= 3240) {
            return 50 / 100.0;
        } else if (totaleJourTravail >= 7560) {
            return 70 / 100.0;
        } else {
            int nombreDeFoisDe216 = (totaleJourTravail - 3240) / 216;
            return (50 + nombreDeFoisDe216) / 100.0;
        }
    };


    public static double calculePrixRetraite(float salaire, int totaleJourTravail) {
        double percentage = calculatePercentage.apply(salaire, totaleJourTravail);
        double prixRetraiteParMois = salaire * percentage;
        return contSalaireRetreite((float) prixRetraiteParMois);
    }

    /*public static int calculerNombreMois(int nombreDeJours) {
        final double JOURS_PAR_MOIS = 26;
        Function<Integer, Integer> calculMois = (jours) -> {
            double nombreDeMoisDouble = jours / JOURS_PAR_MOIS;
            return (int) Math.round(nombreDeMoisDouble);
        };
        return calculMois.apply(nombreDeJours);
    }*/

    public static int calculerNombreMois(int nombreDeJours) {
        final double JOURS_PAR_MOIS = 26;
        return (int) Math.round(nombreDeJours / JOURS_PAR_MOIS);
    }



    public static float contSalaireRetreite(float salaire) {
        return Math.min(6000, Math.max(1000, salaire));
    }



    /*public static double calculePrixRetraite(float salaire, int totaleJourTravail){
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
    }*/
}
