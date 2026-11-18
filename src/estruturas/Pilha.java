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
        return null == topo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void push(Tarefa tarefa) {
        NoTarefa novo = new NoTarefa(tarefa);
        novo.setProximo(topo);
        topo = novo;
        quantidade++;
    }

    public Tarefa pop() {
        if (isVazia()) {
            return null;
        }
        Tarefa removida = topo.getTarefa();
        topo = topo.getProximo();
        quantidade--;
        return removida;
    }

    public Tarefa getTopo() {
        if (isVazia()) {
            return null;
        }
        return topo.getTarefa();
    }

    public Tarefa buscar(int id) {
        NoTarefa atual = topo;
        while (atual != null) {
            if (atual.getTarefa().getId() == id) {
                return atual.getTarefa();
            }
            atual = atual.getProximo();
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
            System.out.println(atual.getTarefa());
            atual = atual.getProximo();
        }
    }
}
}
