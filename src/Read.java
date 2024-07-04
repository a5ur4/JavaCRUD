import java.sql.ResultSet;
import java.sql.Statement;

import conect.Conection;

public class Read {
    static final String QUERY = "SELECT id, nome, login, email, senha FROM user";
    public static void main(String[] args) {
        try {
            Statement stmt = Conection.getConection().createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println("\n");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Login: " + rs.getString("login"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Senha: " + rs.getString("senha"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
