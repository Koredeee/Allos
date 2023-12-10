package com.example.allos.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.transform.Result;

public class Connect {
    private final String username = "root";
    private final String password = "root123";
    private final String database = "ooad_jdbc";
    private final String host = "localhost:3306";
    private final String connection = String.format("jdbc:mysql://%s/%s", host, database);

    private Connection con;
    private Statement st;
    public ResultSet rs;

    public static Connect connect;

    public static Connect getInstance(){
        if (connect == null){
            connect = new Connect();
        }
        return connect;
    }

    private Connect(){
        try {
            con = DriverManager.getConnection(connection, username, password);

            // buat bikin query
            st = con.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet selectData(String query){
        try {
            rs = st.executeQuery(query);

            // executeQuery() buat ngirim query ke database
            // executeUpdate() buat ngirim query ke database tapi buat update data

        } catch (Exception e){
            e.printStackTrace();
        }
        return rs;

    }

    public void execute(String query){
        try {
            st.executeUpdate(query);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
