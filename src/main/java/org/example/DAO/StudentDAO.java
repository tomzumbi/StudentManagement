package org.example.DAO;

import org.example.DAO.Conection.ConnectionMySql;

import java.sql.Connection;

public class StudentDAO {
    private Connection connection = ConnectionMySql.getConnection();

}
