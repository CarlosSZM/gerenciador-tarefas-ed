package servico;

import estruturas.ArvoreBinaria;
import estruturas.Fila;
import estruturas.Pilha;
import modelo.Funcionario;
import modelo.StatusTarefa;
import modelo.Tarefa;

public class GerenciadorTarefas {

    private final ArvoreBinaria funcionarios = new ArvoreBinaria();
    private final Fila backlog = new Fila();
    private final Pilha excluidas = new Pilha();
    private int proximoIdTarefa = 1;

    public boolean cadastrarFuncionario(int id, String nome, String cargo) {
        return funcionarios.inserir(new Funcionario(id, nome, cargo));
    }

    public Funcionario buscarFuncionario(int id) {
        return funcionarios.buscar(id);
    }

    public boolean removerFuncionario(int id) {
        return funcionarios.remover(id);
    }

    public void listarFuncionariosInOrdem() {
        funcionarios.inOrdem();
    }

    public void listarFuncionariosPreOrdem() {
        funcionarios.preOrdem();
    }

    public void listarFuncionariosPosOrdem() {
        funcionarios.posOrdem();
    }

    public Tarefa criarTarefa(String descricao) {
        Tarefa tarefa = new Tarefa(proximoIdTarefa++, descricao);
        backlog.enfileirar(tarefa);
        return tarefa;
    }

    public boolean atribuirTarefa(int idTarefa, int idFuncionario) {
        Funcionario funcionario = funcionarios.buscar(idFuncionario);
        Tarefa tarefa = backlog.buscar(idTarefa);
        Tarefa proximaTarefa = backlog.consultarInicio();
        if (funcionario == null || tarefa == null || proximaTarefa == null
                || proximaTarefa.getId() != idTarefa
                || tarefa.getStatus() != StatusTarefa.PENDENTE) {
            return false;
        }
        tarefa.setResponsavelId(idFuncionario);
        tarefa.setStatus(StatusTarefa.EM_ANDAMENTO);
        return true;
    }

    public Tarefa concluirProximaTarefa() {
        if (backlog.isVazia()) {
            return null;
        }
        Tarefa tarefa = backlog.desenfileirar();
        if (tarefa != null) {
            tarefa.setStatus(StatusTarefa.CONCLUIDA);
        }
        return tarefa;
    }

    public boolean excluirTarefa(int idTarefa) {
        Tarefa tarefa = backlog.remover(idTarefa);
        if (tarefa == null) {
            return false;
        }
        excluidas.push(tarefa);
        return true;
    }

    public Tarefa desfazerExclusao() {
        if (excluidas.isVazia()) {
            return null;
        }
        Tarefa tarefa = excluidas.pop();
        if (tarefa != null) {
            backlog.enfileirar(tarefa);
        }
        return tarefa;
    }

    public void listarBacklog() {
        backlog.listar();
    }

    public void listarExcluidas() {
        excluidas.listar();
    }
}
