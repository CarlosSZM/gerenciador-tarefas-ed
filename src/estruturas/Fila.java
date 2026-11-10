package estruturas;

import modelo.Tarefa;

public class Fila {

    private NoTarefa inicio;
    private NoTarefa fim;
    private int quantidade;

    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
    }

    public boolean isVazia() {
        return inicio == null;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void enfileirar(Tarefa tarefa) {
        NoTarefa novo = new NoTarefa(tarefa);
        if (isVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
        quantidade++;
    }

    public Tarefa desenfileirar() {
        if (isVazia()) {
            return null;
        }
        Tarefa tarefa = inicio.tarefa;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        quantidade--;
        return tarefa;
    }

    public Tarefa buscar(int id) {
        NoTarefa aux = inicio;
        while (aux != null) {
            if (aux.tarefa.getId() == id) {
                return aux.tarefa;
            }
            aux = aux.proximo;
        }
        return null;
    }

    public Tarefa remover(int id) {
        if (isVazia()) {
            return null;
        }
        if (inicio.tarefa.getId() == id) {
            return desenfileirar();
        }
        NoTarefa anterior = inicio;
        NoTarefa atual = inicio.proximo;
        while (atual != null) {
            if (atual.tarefa.getId() == id) {
                anterior.proximo = atual.proximo;
                if (atual == fim) {
                    fim = anterior;
                }
                quantidade--;
                return atual.tarefa;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return null;
    }

    public void listar() {
        if (isVazia()) {
            System.out.println("Backlog vazio.");
            return;
        }
        NoTarefa aux = inicio;
        while (aux != null) {
            System.out.println(aux.tarefa);
            aux = aux.proximo;
        }
    }
}
