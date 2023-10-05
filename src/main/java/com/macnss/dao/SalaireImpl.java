package com.macnss.dao;

import com.macnss.DBconnection.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.macnss.helpers.helpers.*;

public class SalaireImpl implements SalaireDao{
    @Override
    public void calculeSalereMoyenne() {

        Connection con = DBconnection.getConnection();
        String query = "SELECT * FROM patient";
        try (PreparedStatement preparedStatement = con.prepareStatement((query))){
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String matrecule = resultSet.getString("matrecule");
                String query2 = "SELECT * FROM `salaire` WHERE matrecule = ? ORDER BY date DESC LIMIT 96";
                try (PreparedStatement preparedStatement2 = con.prepareStatement((query2))){
                    preparedStatement2.setString(1,matrecule);
                    ResultSet resultSet2 = preparedStatement2.executeQuery();

                    float salaire = 0;
                    int countSalaire = 0;

                    while (resultSet2.next()){
                        salaire += resultSet2.getInt("salaire");
                        countSalaire++;
                    }
                    float moyenne = salaire/countSalaire;
                    String query3 = "UPDATE `patient` SET `salere`=? WHERE `matrecule`=?";
                    try (PreparedStatement preparedStatement3 = con.prepareStatement(query3);){
                        preparedStatement3.setFloat(1,moyenne);
                        preparedStatement3.setString(2,matrecule);

                        preparedStatement3.executeUpdate();

                    } catch (SQLException se){
                        se.printStackTrace();
                    }

                } catch (SQLException se){
                    se.printStackTrace();
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
    }
}
