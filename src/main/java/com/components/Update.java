package com.components;

import com.DAO.UserDAO;
import com.entity.User;
import com.main.App;

import java.util.Scanner;

public class Update {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\nDigite o id do usuário: ");
        int id = sc.nextInt();

        System.out.println("Digite o novo nome do usuário: ");
        sc.nextLine();
        String nome = sc.nextLine();

        System.out.println("Digite o novo login do usuário: ");
        String login = sc.nextLine();

        System.out.println("Digite o novo email do usuário: ");
        String email = sc.nextLine();

        System.out.println("Digite a nova senha do usuário: ");
        String senha = sc.nextLine();

        if (id != 0 && nome != null && login != null && email != null && senha != null) {
            User update = new User();
            update.setCodigo(id);
            update.setNome(nome);
            update.setLogin(login);
            update.setEmail(email);
            update.setSenha(senha);

            new UserDAO().atualizar(update);
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
