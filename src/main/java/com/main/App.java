package com.main;

import java.util.Scanner;

import com.components.Create;
import com.components.Delete;
import com.components.Menu;
import com.components.Read;
import com.components.Update;

public class App {
    public static void main(String[] args) throws Exception {
        Menu.main(args);
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("\nDigite o número da operação desejada: ");
        int opcao = sc.nextInt();

        if (opcao == 1) {
            Create.main(args);
        } else if (opcao == 2) {
            Read.main(args);
        } else if (opcao == 3) {
            Update.main(args);
        } else if (opcao == 4) {
            Delete.main(args);
        } else if (opcao == 5) {
            System.out.println("Saindo...");
        } else {
            System.out.println("Opção inválida");
            Menu.main(args);
        }
    }
}