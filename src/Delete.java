import entity.User;

import DAO.UserDAO;

import java.util.Scanner;

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
        } else {
            System.out.println("Erro: o campo id deve ser preenchido.");
        }
    }
}
