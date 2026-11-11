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
        if (tarefa == null) {
            return;
        }
        NoTarefa novo = new NoTarefa(tarefa);
        novo.proximo = topo;
        topo = novo;
        quantidade++;
    }

    public Tarefa pop() {
        if (isVazia()) {
            return null;
        }
        Tarefa tarefa = topo.tarefa;
        topo = topo.proximo;
        quantidade--;
        return tarefa;
    }

    public Tarefa getTopo() {
        if (isVazia()) {
            return null;
        }
        return topo.tarefa;
    }

    public Tarefa buscar(int id) {
        NoTarefa atual = topo;
        while (atual != null) {
            if (atual.tarefa.getId() == id) {
                return atual.tarefa;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public void listar() {
        if (isVazia()) {
            System.out.println("Pilha vazia.");
            return;
        }
        NoTarefa atual = topo;
        while (atual != null) {
            System.out.println(atual.tarefa);
            atual = atual.proximo;
        }
    }
}
