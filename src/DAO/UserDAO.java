package DAO;

import java.sql.PreparedStatement;

import conect.Conection;
import entity.User;

public class UserDAO {
    public void cadastrar(User user) {
        String insert = "INSERT INTO user (nome, login, email, senha) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conection.getConection().prepareStatement(insert);
            ps.setString(1, user.getNome());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getSenha());

            ps.execute();
            ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ler(User user) {
        String read = "SELECT * FROM user WHERE id = ?";

        PreparedStatement ps = null;

        try {
            ps = Conection.getConection().prepareStatement(read);
            ps.setInt(1, user.getCodigo());

            ps.execute();
            ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizar(User user) {
        String update = "UPDATE user SET nome = ?, login = ?, email = ?, senha = ? WHERE id = ?";

        PreparedStatement ps = null;

        try {
            ps = Conection.getConection().prepareStatement(update);
            ps.setString(1, user.getNome());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getSenha());
            ps.setInt(5, user.getCodigo());

            ps.execute();
            ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(User user) {
        String delete = "DELETE FROM user WHERE id = ?";

        PreparedStatement ps = null;

        try {
            ps = Conection.getConection().prepareStatement(delete);
            ps.setInt(1, user.getCodigo());

            ps.execute();
            ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
