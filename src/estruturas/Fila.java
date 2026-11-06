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
    }

    public Tarefa desenfileirar() {
        return null;
    }

    public Tarefa buscar(int id) {
        return null;
    }

    public Tarefa remover(int id) {
        return null;
    }

    public void listar() {
    }
}
