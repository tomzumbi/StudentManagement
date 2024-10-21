package org.example;

import org.example.DAO.Conection.ConnectionMySql;

public class Main {
    public static void main(String[] args) {
        ConnectionMySql.getConnection();
    }
}