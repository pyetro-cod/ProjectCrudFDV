import model.User;
import service.UserService;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final UserService service = new UserService();

    public static void main(String[] args) {
        int opc = -1;

        do {
            exibirMenu();
            try {
                opc = sc.nextInt();
                sc.nextLine();

                switch (opc) {
                    case 1 -> cadastrarUsuario();
                    case 2 -> listarUsuarios();
                    case 3 -> atualizarUsuario();
                    case 4 -> deletarUsuario();
                    case 0 -> System.out.println("Saindo do Sistema...");
                    default -> System.out.println("⚠️ Opção Inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Erro: Digite apenas números.");
                sc.nextLine();
            }
        } while (opc != 0);

        sc.close();
    }

    private static void exibirMenu() {
        System.out.println("\n" + "=".repeat(20));
        System.out.println("  CRUD DE USUÁRIOS");
        System.out.println("=".repeat(20));
        System.out.println("1 - Criar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private static void cadastrarUsuario() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        if (nome.isBlank() || email.isBlank()) {
            System.out.println("⚠️ Nome e Email são obrigatórios.");
            return;
        }

        service.criar(nome, email);
        System.out.println("✅ Usuário Criado com Sucesso!");
    }

    private static void listarUsuarios() {
        List<User> users = service.listar();
        if (users.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("\nID  | NOME           | EMAIL");
            System.out.println("-".repeat(30));
            users.forEach(u ->
                    System.out.printf("%-3d | %-14s | %s%n", u.getId(), u.getNome(), u.getEmail())
            );
        }
    }

    private static void atualizarUsuario() {
        System.out.print("ID do usuário a atualizar: ");
        try {
            Long id = sc.nextLong();
            sc.nextLine();
            System.out.print("Novo nome: ");
            String nome = sc.nextLine();
            System.out.print("Novo email: ");
            String email = sc.nextLine();

            if (service.atualizar(id, nome, email)) {
                System.out.println("✅ Atualizado com sucesso!");
            } else {
                System.out.println("❌ Usuário não encontrado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("❌ ID inválido.");
            sc.nextLine();
        }
    }

    private static void deletarUsuario() {
        System.out.print("ID do Usuário a deletar: ");
        try {
            Long id = sc.nextLong();
            if (service.deletar(id)) {
                System.out.println("✅ Usuário deletado com sucesso!");
            } else {
                System.out.println("❌ Usuário não encontrado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("❌ ID inválido.");
            sc.nextLine();
        }
    }
}