/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaVacina.Model;

/**
 *
 * @author samue
 */
public class Usuario {
    
    private int idCliente;
    private String NomeCliente;
    private String CpfCliente;
    private String Foneclientes;
    private String EmailCliente;
    private String SenhaCliente;

    public Usuario(int idCliente, String NomeCliente, String CpfCliente, String Foneclientes, String EmailCliente, String SenhaCliente) {
        this.idCliente = idCliente;
        this.NomeCliente = NomeCliente;
        this.CpfCliente = CpfCliente;
        this.Foneclientes = Foneclientes;
        this.EmailCliente = EmailCliente;
        this.SenhaCliente = SenhaCliente;
    }

    public Usuario(String NomeCliente, String CpfCliente, String Foneclientes, String EmailCliente, String SenhaCliente) {
        this.NomeCliente = NomeCliente;
        this.CpfCliente = CpfCliente;
        this.Foneclientes = Foneclientes;
        this.EmailCliente = EmailCliente;
        this.SenhaCliente = SenhaCliente;
    }

    public Usuario(String NomeCliente, String SenhaCliente) {
        this.NomeCliente = NomeCliente;
        this.SenhaCliente = SenhaCliente;
    }

    public Usuario(int idCliente, String NomeCliente, String SenhaCliente) {
        this.idCliente = idCliente;
        this.NomeCliente = NomeCliente;
        this.SenhaCliente = SenhaCliente;
    }

    
    
    
    
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }

    public String getCpfCliente() {
        return CpfCliente;
    }

    public void setCpfCliente(String CpfCliente) {
        this.CpfCliente = CpfCliente;
    }

    public String getFoneclientes() {
        return Foneclientes;
    }

    public void setFoneclientes(String Foneclientes) {
        this.Foneclientes = Foneclientes;
    }

    public String getEmailCliente() {
        return EmailCliente;
    }

    public void setEmailCliente(String EmailCliente) {
        this.EmailCliente = EmailCliente;
    }

    public String getSenhaCliente() {
        return SenhaCliente;
    }

    public void setSenhaCliente(String SenhaCliente) {
        this.SenhaCliente = SenhaCliente;
    }

    public int getidCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getSenha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
