import model.User;
import service.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

void main() {
    Scanner sc = new Scanner(System.in);
    UserService service = new UserService();

    int opc;

    do {
        System.out.println("\n=== CRUD DE USUÁRIOS ===");
        System.out.println("1 - Criar usuário");
        System.out.println("2 - Listar usuários");
        System.out.println("3 - Atualizar usuário");
        System.out.println("4 - Deletar usuário");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");

        opc = sc.nextInt();
        sc.nextLine();
        switch (opc) {
            case 1:
                System.out.println("Nome: ");
                String nome = sc.nextLine();

                System.out.println("Email: ");
                String email = sc.nextLine();

                service.criar(nome, email);
                System.out.println("Usuário Criado com Sucesso");
                break;

            case 2:
                List<User> users = service.listar();
                if (users.isEmpty()) {
                    System.out.println("Nenhum usuário cadastrado.");
                } else {
                    users.forEach(u -> System.out.println(u.getId() + " - " + u.getNome() + " - " + u.getEmail()));
                }
                break;

            case 3:
                System.out.print("ID do usuário: ");
                Long idAtualizar = sc.nextLong();
                sc.nextLine();

                System.out.print("Novo nome: ");
                String novoNome = sc.nextLine();

                System.out.print("Novo email: ");
                String novoEmail = sc.nextLine();

                if (service.atualizar(idAtualizar, novoNome, novoEmail)) {
                    System.out.println("Atualizado com sucesso!");
                } else {
                    System.out.println("Usuário não encontrado.");
                }
                break;

            case 4:
                System.out.println("ID do Usuário: ");
                Long idDeletar = sc.nextLong();

                if (service.deletar(idDeletar)) {
                    System.out.println("Usuário deletado com sucesso");
                } else {
                    System.out.println("Usuário não encontrado");
                }
                break;

            case 0:
                System.out.println("Saindo do Sistema");
                break;
            default:
                System.out.println("Opção Inválida");
        }
    } while (opc != 0);
    sc.close();
}
