package com.components;

import java.util.Scanner;

import com.DAO.UserDAO;
import com.entity.User;
import com.main.App;

public class Delete {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.println("\nDigite o id do usuário: ");
        int id = sc.nextInt();

        if (id != 0) {
            User delete = new User();
            delete.setCodigo(id);

            new UserDAO().deletar(delete);
            System.out.println("Usuário deletado com sucesso.");
            try {
                App.main(args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Erro: o campo id deve ser preenchido.");
        }
    }
}
