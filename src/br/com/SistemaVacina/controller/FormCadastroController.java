
package br.com.SistemaVacina.controller;

import br.com.SistemaVacina.Model.Usuario;
import br.com.SistemaVacina.dal.ModuloConexao;
import br.com.SistemaVacina.dal.UsuarioDal;
import br.com.SistemaVacina.telas.TelaCadastro;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class FormCadastroController {
    private TelaCadastro viewtelacadastro;

    public FormCadastroController(TelaCadastro viewtelacadastro) {
        this.viewtelacadastro = viewtelacadastro;
    }

    public void salvaUsuario() {
        String nome = viewtelacadastro.getjTextFieldnome().getText();
        String senha = viewtelacadastro.getjPasswordFieldsenha().getText();
        String telefone = viewtelacadastro.getjTextFieldtelefone().getText();
        String email = viewtelacadastro.getjTextFieldemail().getText();
        String cpf = viewtelacadastro.getjTextFieldcpf().getText();

        if (nome.isEmpty() || senha.isEmpty() || telefone.isEmpty() || email.isEmpty() || cpf.isEmpty()) {
            JOptionPane.showMessageDialog(viewtelacadastro, "Por favor, preencha todos os campos.");
            return;
        }

        Usuario usuario = new Usuario(nome, cpf, telefone, email, senha);

        try {
            Connection conexao = new ModuloConexao().getConnection();
            UsuarioDal usuarioDal = new UsuarioDal(conexao);
            usuarioDal.insert(usuario);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
