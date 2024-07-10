package com.components;

import com.DAO.UserDAO;
import com.entity.User;
import com.main.App;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONObject;

import com.google.zxing.WriterException;

public class Update {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\nDigite o id do usuário: ");
        int id = sc.nextInt();

        System.out.println("Digite o nome do usuário: ");
        String nomeAntigo = sc.next();

        System.out.println("\nDigite o novo nome do usuário: ");
        sc.nextLine();
        String nome = sc.nextLine();

        System.out.println("Digite o novo login do usuário: ");
        String login = sc.nextLine();

        System.out.println("Digite o novo email do usuário: ");
        String email = sc.nextLine();

        System.out.println("Digite a nova senha do usuário: ");
        String senha = sc.nextLine();

        if (id != 0 && nome != null && login != null && email != null && senha != null) {

            String projectDir = System.getProperty("user.dir");

            String oldResourcesPath = projectDir + "/src/main/resources/" + nomeAntigo + ".png";
            String resourcesPath = projectDir + "/src/main/resources/" + nome + ".png";

            File oldQr = new File(oldResourcesPath);

            if (oldQr.exists()) {
                if (oldQr.delete()) {
                    System.out.println("Antigo QR Code deletado.");
                } else {
                    System.out.println("Falhou.");
                }
            } else {
                System.out.println("Antigo QR code não existe.");
            }

            User update = new User();
            update.setCodigo(id);
            update.setNome(nome);
            update.setLogin(login);
            update.setEmail(email);
            update.setSenha(senha);

            new UserDAO().atualizar(update);

            JSONObject userInfo = new JSONObject();
            userInfo.put("nome", nome);
            userInfo.put("login", login);
            userInfo.put("email", email);

            String userData = userInfo.toString();
            
            try {
                GenerateQr.generateQrCode(userData, resourcesPath, "UTF-8");
            } catch (WriterException | IOException e) {
                e.printStackTrace();
            }
            try {
                App.main(args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Erro: todos os campos devem ser preenchidos.");
        }
    }
}
