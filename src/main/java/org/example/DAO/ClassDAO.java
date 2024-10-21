package org.example.DAO;

import org.example.DAO.Conection.ConnectionMySql;

import java.sql.Connection;

public class ClassDAO {
    private Connection connection = ConnectionMySql.getConnection();

}
