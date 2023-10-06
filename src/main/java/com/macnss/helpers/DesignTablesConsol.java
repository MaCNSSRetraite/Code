package com.macnss.helpers;

public class DesignTablesConsol {

    static int td_lenght;
    static int td_lenght_empty;

    public static String createTableAgents(String td){
        // String tr = jauneColor + "+";
        String tr =  "+";
        if (td == "empty1"){
            for (int i=0; i<151; i++){
                tr += "-";
            }
            tr += "+";
            //tr += defautColor;
        }
        else if (td == "empty2"){
            for (int i=0; i<37; i++){
                tr += "-";
            }
            tr += "+";
            for (int i=0; i<37; i++){
                tr += "-";
            }
            tr += "+";
            for (int i=0; i<37; i++){
                tr += "-";
            }
            tr += "+";
            for (int i=0; i<37; i++){
                tr += "-";
            }
            tr += "+";

        }
        else {

            tr = "|";
            td_lenght = td.length();
            td_lenght_empty = (151 - td_lenght)/2;

            for (int i=0; i<td_lenght_empty; i++){
                tr += " ";
            }
            tr += td;
            if (((153 - td_lenght) % 2) == 1){
                for (int i=0; i<td_lenght_empty+1; i++){
                    tr += " ";
                }
            }else {
                for (int i=0; i<td_lenght_empty; i++){
                    tr += " ";
                }
            }

            tr += "|";

        }
        return tr;
    }
    public static String createTrAgents(){
        String td1 = "Id";
        String td2 = "Nom Agents";
        String td3 = "Prenom Agents";
        String td4 = "Email";
        int td1_lenght = td1.length();
        int td1_lenght_empty = 37 - td1_lenght;
        int demi_td1_lenght_empty = td1_lenght_empty / 2;

        int td2_lenght = td2.length();
        int td2_lenght_empty = 37 - td2_lenght;
        int demi_td2_lenght_empty = td2_lenght_empty / 2;

        int td3_lenght = td3.length();
        int td3_lenght_empty = 37 - td3_lenght;
        int demi_td3_lenght_empty = td3_lenght_empty / 2;

        int td4_lenght = td4.length();
        int td4_lenght_empty = 37 - td4_lenght;
        int demi_td4_lenght_empty = td4_lenght_empty / 2;


        String tr = "|" ;
        for (int i=0; i<demi_td1_lenght_empty+1; i++){
            tr += " ";
        }
        tr += td1;
        for (int i=0; i<demi_td1_lenght_empty; i++){
            tr += " ";
        }

        tr += "|";
        for (int i=0; i<demi_td2_lenght_empty; i++){
            tr += " ";
        }
        tr += td2;
        for (int i=0; i<demi_td2_lenght_empty+1; i++){
            tr += " ";
        }

        tr += "|";
        for (int i=0; i<demi_td3_lenght_empty; i++){
            tr += " ";
        }
        tr += td3;
        for (int i=0; i<demi_td3_lenght_empty; i++){
            tr += " ";
        }

        tr +=  "|";
        for (int i=0; i<demi_td4_lenght_empty; i++){
            tr += " ";
        }
        tr += td4;
        for (int i=0; i<demi_td4_lenght_empty; i++){
            tr += " ";
        }

        tr += "|";
        return tr;
    }
    public static String createTrDossiers(String sans){
        String td1 = "Id Dossier";
        String td2 = "Prix Retour";
        String td3 = "Status";
        String td4 = "Id Agent";
        String td5 = "Id Medicament";
        String td6 = "Id Consultation M.";
        String td7 = "Matrecule";
        int td1_lenght = td1.length();
        int td1_lenght_empty = 20 - td1_lenght;
        int demi_td1_lenght_empty = td1_lenght_empty / 2;

        int td2_lenght = td2.length();
        int td2_lenght_empty = 20 - td2_lenght;
        int demi_td2_lenght_empty = td2_lenght_empty / 2;

        int td3_lenght = td3.length();
        int td3_lenght_empty = 20 - td3_lenght;
        int demi_td3_lenght_empty = td3_lenght_empty / 2;

        int td4_lenght = td4.length();
        int td4_lenght_empty = 20 - td4_lenght;
        int demi_td4_lenght_empty = td4_lenght_empty / 2;

        int td5_lenght = td5.length();
        int td5_lenght_empty = 20 - td5_lenght;
        int demi_td5_lenght_empty = td5_lenght_empty / 2;

        int td7_lenght = td7.length();
        int td7_lenght_empty = 20 - td7_lenght;
        int demi_td7_lenght_empty = td7_lenght_empty / 2;


        String tr ="|";
        if (sans == "sans1"){

            tr = "+";
            for (int i=0; i<146; i++){
                tr += "-";
            }

            tr += "+";
        } if (sans == "sans2"){

            tr =  "+";
            for (int j = 0 ; j<7; j++){
                for (int i=0; i<20; i++){
                    tr += "-";
                }

                tr += "+" ;
            }

        }if (sans == "sans3"){
            for (int i=0; i<demi_td1_lenght_empty; i++){
                tr += " ";
            }
            tr += td1;
            for (int i=0; i<demi_td1_lenght_empty; i++){
                tr += " ";
            }

            tr += "|";
            for (int i=0; i<demi_td2_lenght_empty; i++){
                tr += " ";
            }
            tr += td2;
            for (int i=0; i<demi_td2_lenght_empty+1; i++){
                tr += " ";
            }
            tr +=  "|";
            for (int i=0; i<demi_td3_lenght_empty; i++){
                tr += " ";
            }
            tr += td3;
            for (int i=0; i<demi_td3_lenght_empty; i++){
                tr += " ";
            }
            tr += "|" ;
            for (int i=0; i<demi_td4_lenght_empty; i++){
                tr += " ";
            }
            tr += td4;
            for (int i=0; i<demi_td4_lenght_empty; i++){
                tr += " ";
            }
            tr +=  "|";
            for (int i=0; i<demi_td5_lenght_empty; i++){
                tr += " ";
            }
            tr += td5;
            for (int i=0; i<demi_td5_lenght_empty+1; i++){
                tr += " ";
            }
            tr += "| " + td6 +  " |";
            for (int i=0; i<demi_td7_lenght_empty; i++){
                tr += " ";
            }
            tr += td7;
            for (int i=0; i<demi_td7_lenght_empty+1; i++){
                tr += " ";
            }
            tr += "|";
        }else {
            td_lenght = sans.length();
            td_lenght_empty = (146 - td_lenght)/2;
            // tr += getRougeClairColor();
            for (int i=0; i<td_lenght_empty; i++){
                tr += " ";
            }
            tr += sans;
            if (((146 - td_lenght) % 2) == 1){
                for (int i=0; i<td_lenght_empty+1; i++){
                    tr += " ";
                }
            }else {
                for (int i=0; i<td_lenght_empty; i++){
                    tr += " ";
                }
            }
            tr +=  "|";

        }
        return tr;
    }
    public static String createTrMedicamentConsultationMedicale(String sans){

        String td1 = "Id";
        String td2 = "Nom";
        String td3 = "Prix";

        int td1_lenght = td1.length();
        int td1_lenght_empty = 48 - td1_lenght;
        int demi_td1_lenght_empty = td1_lenght_empty / 2;

        int td2_lenght = td2.length();
        int td2_lenght_empty = 48 - td2_lenght;
        int demi_td2_lenght_empty = td2_lenght_empty / 2;

        int td3_lenght = td3.length();
        int td3_lenght_empty = 48 - td3_lenght;
        int demi_td3_lenght_empty = td3_lenght_empty / 2;

        String tr = "|";
        if (sans == "sans1"){
            tr =  "+";
            for (int i=0; i<146; i++){
                tr += "-";
            }
            tr += "+";
        } if (sans == "sans2"){
            tr =  "+";
            for (int j = 0 ; j<3; j++){
                for (int i=0; i<48; i++){
                    tr += "-";
                }
                //tr += jauneColor + "+" ;
                tr += "+" ;
            }
        }if (sans == "sans3"){
            for (int i=0; i<demi_td1_lenght_empty; i++){
                tr += " ";
            }
            tr += td1;
            for (int i=0; i<demi_td1_lenght_empty; i++){
                tr += " ";
            }

            tr += "|" ;
            for (int i=0; i<demi_td2_lenght_empty; i++){
                tr += " ";
            }
            tr += td2;
            for (int i=0; i<demi_td2_lenght_empty+1; i++){
                tr += " ";
            }
            tr += "|";
            for (int i=0; i<demi_td3_lenght_empty; i++){
                tr += " ";
            }
            tr += td3;
            for (int i=0; i<demi_td3_lenght_empty; i++){
                tr += " ";
            }
            tr +="|";
        }else {
            td_lenght = sans.length();
            td_lenght_empty = (146 - td_lenght)/2;
            for (int i=0; i<td_lenght_empty; i++){
                tr += " ";
            }
            tr += sans;
            if (((146 - td_lenght) % 2) == 1){
                for (int i=0; i<td_lenght_empty+1; i++){
                    tr += " ";
                }
            }else {
                for (int i=0; i<td_lenght_empty; i++){
                    tr += " ";
                }
            }
            tr += "|";
        }
        return tr;
    }
    public static String createTrTdAgents(String td){
        int td_lenght = td.length();
        int td_lenght_empty = 37 - td_lenght;
        int demi_td_lenght_empty = td_lenght_empty / 2;
        int modulo_td_lenght_2 = td_lenght_empty % 2;
        String tr;
        for (int i=0; i<demi_td_lenght_empty; i++){
            tr = " ";
        }
        tr = td;
        if (modulo_td_lenght_2 == 1){
            for (int i=0; i<demi_td_lenght_empty+1; i++){
                tr += " ";
            }
        }else {
            for (int i=0; i<demi_td_lenght_empty; i++){
                tr += " ";
            }
        }
        tr += "|" ;
        return tr;
    }
    public static String createTrTdDossier(String td){
        int td_lenght = td.length();
        int td_lenght_empty = 20 - td_lenght;
        int demi_td_lenght_empty = td_lenght_empty / 2;
        int modulo_td_lenght_2 = td_lenght_empty % 2;
        String tr;
        for (int i=0; i<demi_td_lenght_empty; i++){
            tr = " ";
        }
        tr = td;
        if (modulo_td_lenght_2 == 1){
            for (int i=0; i<demi_td_lenght_empty+1; i++){
                tr += " ";
            }
        }else {
            for (int i=0; i<demi_td_lenght_empty; i++){
                tr += " ";
            }
        }
        tr += "|" ;
        return tr;
    }
    public static String createTrTdTrMedicamentConsultationMedicale(String td){
        int td_lenght = td.length();
        int td_lenght_empty = 48 - td_lenght;
        int demi_td_lenght_empty = td_lenght_empty / 2;
        int modulo_td_lenght_2 = td_lenght_empty % 2;
        String tr;
        for (int i=0; i<demi_td_lenght_empty; i++){
            tr = " ";
        }
        tr = td;
        if (modulo_td_lenght_2 == 1){
            for (int i=0; i<demi_td_lenght_empty+1; i++){
                tr += " ";
            }
        }else {
            for (int i=0; i<demi_td_lenght_empty; i++){
                tr += " ";
            }
        }
        tr += "|";
        return tr;
    }

    public static void FermetureProgramme(){

        System.out.println("Programme Fermé");

    }


    public static String createTableEmployer(String emptyNoEmpty, String style){
        String tr;

        String td1 = "Matrecule";
        String td2 = "Nom";
        String td3 = "Prenom";
        String td4 = "Salaire";
        String td5 = "Status Retraite";
        String td6 = "Les Jours Travails";

        int td1_lenght = td1.length();
        int td1_lenght_empty = 28 - td1_lenght;
        int demi_td1_lenght_empty = td1_lenght_empty / 2;

        int td2_lenght = td2.length();
        int td2_lenght_empty = 28 - td2_lenght;
        int demi_td2_lenght_empty = td2_lenght_empty / 2;

        int td3_lenght = td3.length();
        int td3_lenght_empty = 28 - td3_lenght;
        int demi_td3_lenght_empty = td3_lenght_empty / 2;

        int td4_lenght = td4.length();
        int td4_lenght_empty = 28 - td4_lenght;
        int demi_td4_lenght_empty = td4_lenght_empty / 2;

        int td5_lenght = td5.length();
        int td5_lenght_empty = 28 - td5_lenght;
        int demi_td5_lenght_empty = td5_lenght_empty / 2;

        int td6_lenght = td6.length();
        int td6_lenght_empty = 28 - td6_lenght;
        int demi_td6_lenght_empty = td6_lenght_empty / 2;

        String td = "List des Employes";

        int td_lenght = td.length();
        int td_lenght_empty = 174 - td_lenght;
        int demi_td_lenght_empty = td_lenght_empty / 2;

        if (emptyNoEmpty == "Empty" && style == "Style1"){
            tr = "+";
            for (int i = 0; i < 173; i++) {
                tr += "-";
            }
            tr += "+" ;
        } else if (emptyNoEmpty == "Empty" && style == "Style2") {
            tr = "+";
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 28; j++) {
                    tr += "-";
                }
                tr += "+";
            }

        } else if (emptyNoEmpty == "NoEmpty" && style == "Style1"){
            //tr += "|";
            tr = "|";
            for (int i = 0; i < demi_td_lenght_empty; i++) {
                tr += " ";
            }
            tr +=td;
            for (int i = 0; i < demi_td_lenght_empty; i++) {
                tr += " ";
            }
            tr += "|" ;
        } else if (emptyNoEmpty == "NoEmpty" && style == "Style2") {
            // tr += "|";
            tr = "|";
            for (int j = 0; j < demi_td1_lenght_empty; j++) {
                tr += " ";
            }
            tr += td1;
            for (int j = 0; j < demi_td1_lenght_empty + 1; j++) {
                tr += " ";
            }
            tr += "|";
            for (int j = 0; j < demi_td2_lenght_empty; j++) {
                tr += " ";
            }
            tr += td2 ;
            for (int j = 0; j < demi_td2_lenght_empty + 1; j++) {
                tr += " ";
            }
            tr += "|";
            for (int j = 0; j < demi_td3_lenght_empty; j++) {
                tr += " ";
            }
            tr +=td3 ;
            for (int j = 0; j < demi_td3_lenght_empty; j++) {
                tr += " ";
            }
            tr += "|";
            for (int j = 0; j < demi_td4_lenght_empty; j++) {
                tr += " ";
            }
            tr +=   td4 ;
            for (int j = 0; j < demi_td4_lenght_empty; j++) {
                tr += " ";
            }
            tr += "|";
            for (int j = 0; j < demi_td5_lenght_empty; j++) {
                tr += " ";
            }
            tr +=   td5 ;
            for (int j = 0; j < demi_td5_lenght_empty + 1; j++) {
                tr += " ";
            }
            tr += "|";
            for (int j = 0; j < demi_td6_lenght_empty; j++) {
                tr += " ";
            }
            tr +=  td6 ;
            for (int j = 0; j < demi_td6_lenght_empty; j++) {
                tr += " ";
            }
            tr += "|" ;
        } else {
            int emptyNoEmpty_lenght = emptyNoEmpty.length();
            int emptyNoEmpty_lenght_empty = 28 - emptyNoEmpty_lenght;
            int demi_emptyNoEmpty_lenght_empty = emptyNoEmpty_lenght_empty / 2;
            int modulo_emptyNoEmpty_lenght_2 = emptyNoEmpty_lenght % 2;

            for (int i=0; i<demi_emptyNoEmpty_lenght_empty; i++){
                //tr += " ";
                tr = " ";
            }
            tr = emptyNoEmpty;
            if (modulo_emptyNoEmpty_lenght_2 == 1){
                for (int i=0; i<demi_emptyNoEmpty_lenght_empty+1; i++){
                    tr += " ";
                }
            }else {
                for (int i=0; i<demi_emptyNoEmpty_lenght_empty; i++){
                    tr += " ";
                }
            }
            tr +=  "|";
        }
        return tr;
    }
}
