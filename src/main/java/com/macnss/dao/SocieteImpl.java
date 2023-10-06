package com.macnss.dao;

import com.macnss.DBconnection.DBconnection;
import com.macnss.Model.Admin;
import com.macnss.Model.Agent;
import com.macnss.Model.Patient;
import com.macnss.Model.Societe;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static com.macnss.helpers.helpers.*;

public class SocieteImpl implements SocieteDao{
    @Override
    public boolean inscrireSociete(Societe societe) {
        Connection con = DBconnection.getConnection();

        String query = "SELECT * FROM `societe` WHERE `email`=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);){
            preparedStatement.setString(1,societe.getEmail());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return false;
            }else {
                String salt = BCrypt.gensalt();

                String hashedPassword = BCrypt.hashpw(societe.getPassword(), salt);

                String Matrecule = generateMatrecule(societe.getNom(),societe.getPrenom(),societe.getEmail(),5);

                String query3="SELECT * FROM `patient` WHERE `matrecule`=?";
                try (PreparedStatement preparedStatement3 = con.prepareStatement(query3)){
                    preparedStatement3.setString(1,Matrecule);

                    ResultSet resultSet3 = preparedStatement3.executeQuery();
                    if (resultSet3.next()) {
                        int code = generateCode();
                        Matrecule += code;

                        String query2 = "INSERT INTO societe (email, password, nom, prenom, matrecule) VALUES (?,?,?,?,?)";
                        try (PreparedStatement preparedStatement2 = con.prepareStatement(query2);){
                            preparedStatement2.setString(1,societe.getEmail());
                            preparedStatement2.setString(2,hashedPassword);
                            preparedStatement2.setString(3,societe.getNom());
                            preparedStatement2.setString(4,societe.getPrenom());
                            preparedStatement2.setString(5,Matrecule);

                            preparedStatement2.executeUpdate();

                            return true;
                        } catch (SQLException se){
                            se.printStackTrace();
                        }finally {
                            try {
                                con.close();
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        return true;
                    }else {
                        String query2 = "INSERT INTO societe (email, password, nom, prenom, matrecule) VALUES (?,?,?,?,?)";
                        try (PreparedStatement preparedStatement2 = con.prepareStatement(query2);){
                            preparedStatement2.setString(1,societe.getEmail());
                            preparedStatement2.setString(2,hashedPassword);
                            preparedStatement2.setString(3,societe.getNom());
                            preparedStatement2.setString(4,societe.getPrenom());
                            preparedStatement2.setString(5,Matrecule);

                            preparedStatement2.executeUpdate();

                            return true;
                        } catch (SQLException se){
                            se.printStackTrace();
                        }finally {
                            try {
                                con.close();
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        return true;
                    }
                }
            }
        } catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @Override
    public boolean ajouterEmploye(Patient patient) {
        Connection con = DBconnection.getConnection();

        String query = "SELECT * FROM `patient` WHERE `email`=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);){
            preparedStatement.setString(1,patient.getemail());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return false;
            }else {
                String Matrecule = generateMatrecule(patient.getNom(),patient.getPrenom(),patient.getemail(),3);
                String StatusRetraite = null;
                Float PrixRetraite = null;
                float Salere = patient.getSalere();
                int totaleJourTravail = patient.getTotaleJourTravail();
                String date_naissance = patient.getDate_naissance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                int annee = 0;

                try {
                    Date date = sdf.parse(date_naissance);

                    java.util.Calendar calendar = java.util.Calendar.getInstance();
                    calendar.setTime(date);
                    annee = calendar.get(java.util.Calendar.YEAR);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Calendar calendrier = Calendar.getInstance();

                int anneeAujourdhui = calendrier.get(Calendar.YEAR);
                int moisAujourdhui = calendrier.get(Calendar.MONTH) + 1;
                int jourAujourdhui = calendrier.get(Calendar.DAY_OF_MONTH);

                String dateAjourdhui = anneeAujourdhui + "-" + moisAujourdhui + "-" + jourAujourdhui;

                int an =  anneeAujourdhui - annee;

                if (totaleJourTravail >= 3240 && an >= 55) {
                    StatusRetraite = "Retraite";
                    PrixRetraite = (float) calculePrixRetraite(Salere,totaleJourTravail);
                } else {
                    StatusRetraite = "Non Retraite";
                    PrixRetraite = 0F;
                }

                String query3="SELECT * FROM `patient` WHERE `matrecule`=?";
                try (PreparedStatement preparedStatement3 = con.prepareStatement(query3)){
                    preparedStatement3.setString(1,Matrecule);

                    ResultSet resultSet3 = preparedStatement3.executeQuery();
                    if (resultSet3.next()) {
                        int code = generateCode();
                        Matrecule += code;
                        String query2 = "INSERT INTO patient (matrecule, nom_P, prenom_P, email, statusRetraite, prixRetraite, matriculeSociete, totaleJourTravail, date_naissance,salere) VALUES (?,?,?,?,?,?,?,?,?,?)";
                        try (PreparedStatement preparedStatement2 = con.prepareStatement(query2);){
                            preparedStatement2.setString(1,Matrecule);
                            preparedStatement2.setString(2,patient.getNom());
                            preparedStatement2.setString(3,patient.getPrenom());
                            preparedStatement2.setString(4,patient.getemail());
                            preparedStatement2.setString(5,StatusRetraite);
                            preparedStatement2.setFloat(6,PrixRetraite);
                            preparedStatement2.setString(7,patient.getMatreculeSociete());
                            preparedStatement2.setInt(8,totaleJourTravail);
                            preparedStatement2.setString(9,patient.getDate_naissance());
                            preparedStatement2.setFloat(10,patient.getSalere());

                            preparedStatement2.executeUpdate();
                        } catch (SQLException se){
                            se.printStackTrace();
                        }
                        String query4 = "INSERT INTO `salaire`(`matrecule`, `salaire`, `date`) VALUES (?,?,?)";
                        try (PreparedStatement preparedStatement4 = con.prepareStatement(query4);){
                            preparedStatement4.setString(1,Matrecule);
                            preparedStatement4.setFloat(2,patient.getSalere());
                            preparedStatement4.setDate(3, java.sql.Date.valueOf(dateAjourdhui));

                            preparedStatement4.executeUpdate();
                            return true;
                        } catch (SQLException se){
                            se.printStackTrace();
                        }finally {
                            try {
                                con.close();
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        return true;
                    }else {
                        String query2 = "INSERT INTO patient (matrecule, nom_P, prenom_P, email, statusRetraite, prixRetraite, matriculeSociete, totaleJourTravail, date_naissance,salaire) VALUES (?,?,?,?,?,?,?,?,?,?)";
                        try (PreparedStatement preparedStatement2 = con.prepareStatement(query2);){
                            preparedStatement2.setString(1,Matrecule);
                            preparedStatement2.setString(2,patient.getNom());
                            preparedStatement2.setString(3,patient.getPrenom());
                            preparedStatement2.setString(4,patient.getemail());
                            preparedStatement2.setString(5,StatusRetraite);
                            preparedStatement2.setFloat(6,PrixRetraite);
                            preparedStatement2.setString(7,patient.getMatreculeSociete());
                            preparedStatement2.setInt(8,totaleJourTravail);
                            preparedStatement2.setString(9,patient.getDate_naissance());
                            preparedStatement2.setFloat(10,patient.getSalere());

                            preparedStatement2.executeUpdate();
                        } catch (SQLException se){
                            se.printStackTrace();
                        }
                        String query4 = "INSERT INTO `salaire`(`matrecule`, `salaire`, `date`) VALUES (?,?,?)";
                        try (PreparedStatement preparedStatement4 = con.prepareStatement(query4);){
                            preparedStatement4.setString(1,Matrecule);
                            preparedStatement4.setFloat(2,patient.getSalere());
                            preparedStatement4.setDate(3, java.sql.Date.valueOf(dateAjourdhui));

                            preparedStatement4.executeUpdate();
                            return true;
                        } catch (SQLException se){
                            se.printStackTrace();
                        }finally {
                            try {
                                con.close();
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        return true;
                    }
                } catch (SQLException se){
                    se.printStackTrace();
                }finally {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        } catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @Override
    public boolean modifierEmploye(Patient patient) {
        Connection con = DBconnection.getConnection();


        String query = "SELECT * FROM `patient` WHERE `matrecule`=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);){
            preparedStatement.setString(1,patient.getMatrecule());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String query2 = "UPDATE `patient` SET `nom_P`=?,`prenom_P`=?, `salere`=? WHERE `matrecule`=?";
                try (PreparedStatement preparedStatement2 = con.prepareStatement(query2);){
                    preparedStatement2.setString(1,patient.getNom());
                    preparedStatement2.setString(2,patient.getPrenom());
                    preparedStatement2.setFloat(3,patient.getSalere());
                    preparedStatement2.setString(4,patient.getMatrecule());

                    preparedStatement2.executeUpdate();

                    return true;
                } catch (SQLException se){
                    se.printStackTrace();
                }finally {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }else {
                return false;
            }
        } catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @Override
    public boolean supprimerEmploye(String matrecule) {
        Connection con = DBconnection.getConnection();

        String query = "SELECT * FROM `patient` WHERE `matrecule`=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);){
            preparedStatement.setString(1,matrecule);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                String query2 = "DELETE FROM `patient` WHERE `matrecule` = ?";
                try (PreparedStatement preparedStatement2 = con.prepareStatement(query2);){
                    preparedStatement2.setString(1,matrecule);

                    preparedStatement2.executeUpdate();

                    return true;
                } catch (SQLException se){
                    se.printStackTrace();
                }finally {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }else {
                return false;
            }
        } catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @Override
    public List<Patient> affichageEmploye(String matreculeEntreprise) {
        Connection con =DBconnection.getConnection();

        List<Patient> patients = new LinkedList<>();

        String query = "SELECT * FROM patient WHERE `matriculeSociete` = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement((query))){
            preparedStatement.setString(1,matreculeEntreprise);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Patient patient = new Patient (resultSet.getString("matrecule"),
                        resultSet.getString("nom_P"),
                        resultSet.getString("prenom_P"),
                        resultSet.getString("email"),
                        resultSet.getFloat("salaire"),
                        resultSet.getString("statusRetraite"),
                        resultSet.getFloat("prixRetraite"),
                        resultSet.getInt("totaleJourTravail"),
                        resultSet.getString("matriculeSociete"),
                        resultSet.getString("date_naissance"));
                patients.add(patient);
            }

        } catch (SQLException se){
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se){
                se.printStackTrace();
            }
        }

        return patients;
    }

    @Override
    public Societe loginSociete(Societe societe) {
        Connection con = DBconnection.getConnection();


        String query = "SELECT * FROM `societe` WHERE `email`=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);){
            preparedStatement.setString(1,societe.getEmail());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (BCrypt.checkpw(societe.getPassword(), resultSet.getString("password"))) {
                    societe = new Societe(resultSet.getInt("id"),
                            resultSet.getString("matrecule"),
                            resultSet.getString("nom"),
                            resultSet.getString("prenom"),
                            resultSet.getString("email"),
                            resultSet.getString("password"));
                    return societe;
                } else {
                    societe = Societe.builder()
                            .id(-1)
                            .email("null")
                            .matrecule("null")
                            .password("null")
                            .nom("null")
                            .prenom("null")
                            .build();
                    return societe;
                }
            }else {
                societe = Societe.builder()
                        .id(-1)
                        .email("null")
                        .password("null")
                        .nom("null")
                        .matrecule("null")
                        .prenom("null")
                        .build();
                return societe;
            }
        } catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        societe = Societe.builder()
                .id(-1)
                .email("null")
                .password("null")
                .matrecule("null")
                .nom("null")
                .prenom("null")
                .build();
        return societe;
    }

    @Override
    public boolean ajouterJourTravailleEmploye(int nombreJourAbsance, int nombreJourMaladie, String matrecule, float salaire) {
        Connection con = DBconnection.getConnection();

        String query = "SELECT * FROM patient WHERE `matrecule` = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement((query))){
            preparedStatement.setString(1,matrecule);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int totaleJourTravail = resultSet.getInt("totaleJourTravail");
                int jourTravail = 26 - (nombreJourAbsance+nombreJourMaladie);
                totaleJourTravail = totaleJourTravail+jourTravail;

                Calendar calendrier = Calendar.getInstance();

                int anneeAujourdhui = calendrier.get(Calendar.YEAR);
                int moisAujourdhui = calendrier.get(Calendar.MONTH) + 1;
                int jourAujourdhui = calendrier.get(Calendar.DAY_OF_MONTH);

                String dateAjourdhui = anneeAujourdhui + "-" + moisAujourdhui + "-" + jourAujourdhui;

                String query2 = "UPDATE `patient` SET `totaleJourTravail`=? WHERE `matrecule`=?";
                try (PreparedStatement preparedStatement2 = con.prepareStatement(query2);){
                    preparedStatement2.setInt(1,totaleJourTravail);
                    preparedStatement2.setString(2,matrecule);

                    preparedStatement2.executeUpdate();

                    String query4 = "INSERT INTO `salaire`(`matrecule`, `salaire`, `date`) VALUES (?,?,?)";
                    try (PreparedStatement preparedStatement4 = con.prepareStatement(query4);){
                        preparedStatement4.setString(1,matrecule);
                        preparedStatement4.setFloat(2,salaire);
                        preparedStatement4.setDate(3, java.sql.Date.valueOf(dateAjourdhui));

                        preparedStatement4.executeUpdate();
                        return true;
                    } catch (SQLException se){
                        se.printStackTrace();
                    }finally {
                        try {
                            con.close();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    return true;
                } catch (SQLException se){
                    se.printStackTrace();
                }finally {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        } catch (SQLException se){
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
        return false;
    }
}
