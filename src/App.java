import java.util.Scanner;

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

// Made by: a5ur4