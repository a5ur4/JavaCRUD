package com.components;

import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import com.google.zxing.NotFoundException;

import com.main.App;
import com.conect.Conection;

public class Read {
    static final String QUERY = "SELECT id, nome, login, email, senha FROM user WHERE id = ";
    static final String QUERY_ALL = "SELECT id, nome, login, email, senha FROM user";
    
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1 - Listar todos os usuários");
        System.out.println("2 - Visualizar usuário específico");
        System.out.println("3 - Visualizar Qr Code de usuário específico");
        int option = sc.nextInt();
        
        if (option == 1) {
            try {
                Statement stmt = Conection.getConection().createStatement();
                ResultSet rs = stmt.executeQuery(QUERY_ALL);
                while (rs.next()) {
                    System.out.println("\n");
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Nome: " + rs.getString("nome"));
                    System.out.println("Login: " + rs.getString("login"));
                    System.out.println("Email: " + rs.getString("email"));
                    System.out.println("Senha: " + rs.getString("senha"));
                }
                App.main(args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (option == 2) {
            System.out.println("Digite o ID do usuário que deseja visualizar: ");
            int userId = sc.nextInt();

            try {
                Statement stmt = Conection.getConection().createStatement();
                ResultSet rs = stmt.executeQuery(QUERY + userId);
                while (rs.next()) {
                    System.out.println("\n");
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Nome: " + rs.getString("nome"));
                    System.out.println("Login: " + rs.getString("login"));
                    System.out.println("Email: " + rs.getString("email"));
                    System.out.println("Senha: " + rs.getString("senha"));
                }
                App.main(args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (option == 3) {
            System.out.println("Digite o nome do usuário que deseja visualizar o Qr Code: ");
            String userName = sc.next();

            String projectDir = System.getProperty("user.dir");

            String resourcesPath = projectDir + "/src/main/resources/" + userName + ".png";

            try {
                System.out.println("The data stored in the QR Code is: " + ReadingQr.readQr(resourcesPath));
                System.out.println("QR Code read successfully");
            } catch (IOException | NotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Opção inválida.");
            try {
                App.main(args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
