/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaVacina.controller;


import br.com.SistemaVacina.Model.Usuario;
import br.com.SistemaVacina.dal.ModuloConexao;
import br.com.SistemaVacina.dal.UsuarioDal;
import br.com.SistemaVacina.telas.TelaADMIN1;
import br.com.SistemaVacina.telas.TelaLogin;
import br.com.SistemaVacina.telas.TelaUSUARIO1;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class FormLoginController {
    private TelaLogin viewtelalogin;

    public FormLoginController(TelaLogin viewtelalogin) {
        this.viewtelalogin = viewtelalogin;
    }

    public void autenticar() throws SQLException {
        String nomeUsuario = viewtelalogin.getBarranome().getText();
        String senha = viewtelalogin.getBarrasenha().getText();

        if (nomeUsuario.equals("Admin") && senha.equals("Admin")) {
            // Direcionar para a página de administração
            TelaADMIN1 telaAdmin = new TelaADMIN1();
            telaAdmin.setVisible(true);
            viewtelalogin.dispose(); // Fechar a tela de login
        } else {
            // Verificar as credenciais para usuários normais
            Usuario autenticar = new Usuario(nomeUsuario, senha);
            Connection conexao = new ModuloConexao().getConnection();
            UsuarioDal usuarioDal = new UsuarioDal(conexao);

            boolean existe = usuarioDal.existePorUsuarioESenha(autenticar);
            if (existe) {
                // Direcionar para a página do usuário normal
                TelaUSUARIO1 telaUsuario = new TelaUSUARIO1();
                telaUsuario.setVisible(true);
                viewtelalogin.dispose(); // Fechar a tela de login
            } else {
                JOptionPane.showMessageDialog(viewtelalogin, "NOME DE USUÁRIO ou SENHA INVALIDA! Por favor, tente novamente.");
            }
        }
    }
}

            
        
  
