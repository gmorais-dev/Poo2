import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adicionar Pessoa");
            System.out.println("2. Listar Pessoas");
            System.out.println("3. Atualizar Pessoa");
            System.out.println("4. Remover Pessoa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da pessoa: ");
                    String nome = scanner.nextLine();
                    Pessoa novaPessoa = new Pessoa(nome);
                    pessoaDAO.adicionarPessoa(novaPessoa);
                    System.out.println("Pessoa adicionada com sucesso!");
                    break;
                case 2:
                    List<Pessoa> pessoas = pessoaDAO.listarPessoas();
                    for (int i = 0; i < pessoas.size(); i++) {
                        System.out.println("Índice " + i + ": " + pessoas.get(i));
                    }
                    break;
                case 3:
                    System.out.print("Digite o índice da pessoa a ser atualizada: ");
                    int indiceAtualizacao = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    if (indiceAtualizacao >= 0 && indiceAtualizacao < pessoaDAO.listarPessoas().size()) {
                        System.out.print("Digite o novo nome: ");
                        String novoNome = scanner.nextLine();
                        Pessoa pessoaAtualizada = new Pessoa(novoNome);
                        pessoaDAO.atualizarPessoa(indiceAtualizacao, pessoaAtualizada);
                        System.out.println("Pessoa atualizada com sucesso!");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o índice da pessoa a ser removida: ");
                    int indiceRemocao = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    if (indiceRemocao >= 0 && indiceRemocao < pessoaDAO.listarPessoas().size()) {
                        pessoaDAO.removerPessoa(indiceRemocao);
                        System.out.println("Pessoa removida com sucesso!");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 5:
                    System.out.println("Encerrando...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}