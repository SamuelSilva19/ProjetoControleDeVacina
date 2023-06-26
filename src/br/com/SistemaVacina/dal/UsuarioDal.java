/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaVacina.dal;

import br.com.SistemaVacina.Model.Usuario;
import br.com.SistemaVacina.telas.TelaCadastro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samue
 */
public class UsuarioDal {
    private final Connection connection;

    public UsuarioDal(Connection connection) {
        this.connection = connection;
    }

    public UsuarioDal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void insert (Usuario usuario) throws SQLException{
        
           String sql = "insert into tbclientes (NomeCliente,CpfCliente,Fonecliente,EmailCliente,SenhaCliente) values(?,?,?,?,?);";
              
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNomeCliente());
            statement.setString(2, usuario.getCpfCliente());
            statement.setString(3, usuario.getFoneclientes());
            statement.setString(4, usuario.getEmailCliente());
            statement.setString(5, usuario.getSenhaCliente());
                
            statement.execute();  
        }
    
    
 public void update (Usuario usuario) throws SQLException{
     
     String sql = "update into tbclientes set NomeCliente = ?, CpfCliente = ?, Foneclientes = ?, EmailCliente = ?, SenhaCliente = ? where id = ?" ;  
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNomeCliente());
            statement.setString(2, usuario.getCpfCliente());
            statement.setString(3, usuario.getFoneclientes());
            statement.setString(4, usuario.getEmailCliente());
            statement.setString(5, usuario.getSenhaCliente());
            statement.setInt(6, usuario.getidCliente());
            
            statement.execute();  
 
 }
 public void insertOrUpdate(Usuario usuario) throws SQLException{
  if(usuario.getIdCliente() > 0){
          update (usuario);
  }else{
   insert(usuario);
  }
  }    
  public void delete(Usuario usuario) throws SQLException{
    
      String sql = "delet from tbclientes where idCliente = ?";  
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, usuario.getidCliente());
            statement.execute();  
           
}
  public ArrayList<Usuario>SelectAll() throws SQLException{
      String sql = "select * from tbclientes";  
            PreparedStatement statement = connection.prepareStatement(sql);
            
            return pesquisa(statement);
  }

    private ArrayList<Usuario> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            
            int idCliente = resultSet.getInt("idCliente");
            String NomeCliente = resultSet.getString("NomeCliente");
            String SenhaCliente= resultSet.getString("SenhaCliente");
            
            Usuario usuarioComDadosDoBanco = new Usuario(idCliente, NomeCliente, SenhaCliente);
            usuarios.add(usuarioComDadosDoBanco);
        }
        return usuarios;
    }
  
 public Usuario selectPorId(Usuario usuario) throws SQLException {
 
      String sql = "select * from tbclientes where idCliente = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
             statement.setInt(1, usuario.getidCliente());
              return pesquisa(statement).get(0);           
 
 }  
 

    public boolean existePorUsuarioESenha(Usuario usuario) throws SQLException {
        String sql = " select * from tbclientes where NomeCliente = ? and SenhaCliente = ?";
        //'"+usuario.getNomeCliente()+"' and SenhaCliente = '"+usuario.getSenhaCliente()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNomeCliente());
        statement.setString(2, usuario.getSenhaCliente());
          statement.execute(); 
           
        ResultSet resultSet = statement.getResultSet();
        
       // if (resultSet.next()) {
         //   return true;
        //}else {
             //return false;
        return resultSet.next();
        }
        
       
                }



