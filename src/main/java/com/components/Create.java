package com.components;

import java.util.Scanner;

import org.json.JSONObject;

import com.DAO.UserDAO;
import com.entity.User;
import com.main.App;

public class Create {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\nDigite o nome do usuário: ");
        String nome = sc.nextLine();
        
        System.out.println("Digite o login do usuário: ");
        String login = sc.nextLine();
        
        System.out.println("Digite o email do usuário: ");
        String email = sc.nextLine();
        
        System.out.println("Digite a senha do usuário: ");
        String senha = sc.nextLine();

        if (nome != null && login != null && email != null && senha != null) {
            User create = new User();
            create.setNome(nome);
            create.setLogin(login);
            create.setEmail(email);
            create.setSenha(senha);
    
            new UserDAO().cadastrar(create);

            JSONObject userInfo = new JSONObject();
            userInfo.put("nome", nome);
            userInfo.put("login", login);
            userInfo.put("email", email);

            String userData = userInfo.toString();

            String projectDir = System.getProperty("user.dir");

            String resourcesPath = projectDir + "/src/main/resources/" + nome + ".png";
            
            GenerateQr.generateQrCode(userData, resourcesPath, "UTF-8");

            System.out.println("QR Code gerado com sucesso!");

            App.main(args);
        } else {
            System.out.println("Erro: todos os campos devem ser preenchidos.");
            App.main(args);
        }
    }
}
