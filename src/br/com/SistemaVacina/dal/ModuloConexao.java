/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaVacina.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author samue
 */
public class ModuloConexao {

    public Connection getConnection() throws SQLException{
        Connection ModuloConexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbinfox","root","20032003");
        return ModuloConexao;
    
    }
    
}
