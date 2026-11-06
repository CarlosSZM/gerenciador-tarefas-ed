package estruturas;

import modelo.Tarefa;

public class Pilha {

    private NoTarefa topo;
    private int quantidade;

    public Pilha() {
        this.topo = null;
        this.quantidade = 0;
    }

    public boolean isVazia() {
        return topo == null;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void push(Tarefa tarefa) {
    }

    public Tarefa pop() {
        return null;
    }

    public Tarefa getTopo() {
        return null;
    }

    public Tarefa buscar(int id) {
        return null;
    }

    public void listar() {
    }
}
