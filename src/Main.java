import service.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner sc = new Scanner(System.in);
    UserService service = new UserService();

    int opc;

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
            System.out.println("ID: ");
            Long id = sc.nextLong();
            sc.nextLine();

            System.out.println("Nome: ");
            String nome = sc.nextLine();

            System.out.println("Email: ");
            String email = sc.nextLine();

            service.criar(id,nome,email);
            System.out.println("Usuário Criado com Sucesso");
            break;


    }
}
