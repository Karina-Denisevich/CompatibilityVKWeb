package com.grsu.client;

import com.grsu.dataBase.MusicGroups;

import java.sql.*;
import java.util.ArrayList;

public class GroupDataBase {

    public ArrayList<MusicGroups> fill(String DB_URL, String USER_NAME, String PASSWORD){

        ArrayList<MusicGroups> groupsDatabase = new ArrayList<MusicGroups>();


        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

            statement = connection.createStatement();
            String sql = "select * from groups";
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                MusicGroups musicGroups = new MusicGroups();

                musicGroups.setGroupName(resultSet.getString(2));
                musicGroups.setGenres(resultSet.getString(3));

                groupsDatabase.add(musicGroups);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException ignored) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return groupsDatabase;
    }


}
