import entity.User;

import java.util.Scanner;

import DAO.UserDAO;

public class Create {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o nome do usuário: ");
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
        } else {
            System.out.println("Erro: todos os campos devem ser preenchidos.");
        }
    }
}
