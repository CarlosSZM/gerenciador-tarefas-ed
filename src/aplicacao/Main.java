package aplicacao;

import java.util.Scanner;
import modelo.Funcionario;
import modelo.Tarefa;
import servico.GerenciadorTarefas;

public class Main {

    private static final Scanner entrada = new Scanner(System.in);
    private static final GerenciadorTarefas gerenciador = new GerenciadorTarefas();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Opcao: ");
            executar(opcao);
        } while (opcao != 0);
        entrada.close();
    }

    private static void exibirMenu() {
        System.out.println();
        System.out.println("===== Gerenciador de Tarefas Corporativas =====");
        System.out.println("1  - Cadastrar funcionario");
        System.out.println("2  - Buscar funcionario");
        System.out.println("3  - Remover funcionario");
        System.out.println("4  - Listar funcionarios (in-ordem)");
        System.out.println("5  - Listar funcionarios (pre-ordem)");
        System.out.println("6  - Listar funcionarios (pos-ordem)");
        System.out.println("7  - Criar tarefa");
        System.out.println("8  - Atribuir tarefa a funcionario");
        System.out.println("9  - Concluir proxima tarefa do backlog");
        System.out.println("10 - Excluir tarefa");
        System.out.println("11 - Desfazer exclusao");
        System.out.println("12 - Listar backlog");
        System.out.println("13 - Listar tarefas excluidas");
        System.out.println("0  - Sair");
    }

    private static void executar(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarFuncionario();
                break;
            case 2:
                buscarFuncionario();
                break;
            case 3:
                removerFuncionario();
                break;
            case 4:
                gerenciador.listarFuncionariosInOrdem();
                break;
            case 5:
                gerenciador.listarFuncionariosPreOrdem();
                break;
            case 6:
                gerenciador.listarFuncionariosPosOrdem();
                break;
            case 7:
                criarTarefa();
                break;
            case 8:
                atribuirTarefa();
                break;
            case 9:
                concluirProximaTarefa();
                break;
            case 10:
                excluirTarefa();
                break;
            case 11:
                desfazerExclusao();
                break;
            case 12:
                gerenciador.listarBacklog();
                break;
            case 13:
                gerenciador.listarExcluidas();
                break;
            case 0:
                System.out.println("Encerrando.");
                break;
            default:
                System.out.println("Opcao invalida.");
        }
    }

    private static void cadastrarFuncionario() {
        int id = lerInteiro("ID: ");
        String nome = lerTexto("Nome: ");
        String cargo = lerTexto("Cargo: ");
        if (gerenciador.cadastrarFuncionario(id, nome, cargo)) {
            System.out.println("Funcionario cadastrado.");
        } else {
            System.out.println("Nao foi possivel cadastrar (ID ja existe).");
        }
    }

    private static void buscarFuncionario() {
        Funcionario funcionario = gerenciador.buscarFuncionario(lerInteiro("ID: "));
        if (funcionario == null) {
            System.out.println("Funcionario nao encontrado.");
        } else {
            System.out.println(funcionario);
        }
    }

    private static void removerFuncionario() {
        if (gerenciador.removerFuncionario(lerInteiro("ID: "))) {
            System.out.println("Funcionario removido.");
        } else {
            System.out.println("Funcionario nao encontrado.");
        }
    }

    private static void criarTarefa() {
        Tarefa tarefa = gerenciador.criarTarefa(lerTexto("Descricao: "));
        System.out.println("Tarefa criada: " + tarefa);
    }

    private static void atribuirTarefa() {
        int idTarefa = lerInteiro("ID da tarefa: ");
        int idFuncionario = lerInteiro("ID do funcionario: ");
        if (gerenciador.atribuirTarefa(idTarefa, idFuncionario)) {
            System.out.println("Tarefa atribuida.");
        } else {
            System.out.println("Tarefa ou funcionario nao encontrado.");
        }
    }

    private static void concluirProximaTarefa() {
        Tarefa tarefa = gerenciador.concluirProximaTarefa();
        if (tarefa == null) {
            System.out.println("Backlog vazio.");
        } else {
            System.out.println("Tarefa concluida: " + tarefa);
        }
    }

    private static void excluirTarefa() {
        if (gerenciador.excluirTarefa(lerInteiro("ID da tarefa: "))) {
            System.out.println("Tarefa excluida.");
        } else {
            System.out.println("Tarefa nao encontrada no backlog.");
        }
    }

    private static void desfazerExclusao() {
        Tarefa tarefa = gerenciador.desfazerExclusao();
        if (tarefa == null) {
            System.out.println("Nada para desfazer.");
        } else {
            System.out.println("Tarefa restaurada ao backlog: " + tarefa);
        }
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String linha = entrada.nextLine().trim();
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero inteiro.");
            }
        }
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return entrada.nextLine().trim();
    }
}
