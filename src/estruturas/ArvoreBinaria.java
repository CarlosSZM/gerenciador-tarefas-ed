package estruturas;

import modelo.Funcionario;

public class ArvoreBinaria {

    private NoArvore raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public boolean isVazia() {
        return raiz == null;
    }

    public boolean inserir(Funcionario funcionario) {
        if (funcionario == null) {
            return false;
        }

        NoArvore novo = new NoArvore(funcionario);

        if (raiz == null) {
            raiz = novo;
            return true;
        }

        NoArvore atual = raiz;
        NoArvore pai = null;

        while (atual != null) {
            pai = atual;

            if (funcionario.getId() < atual.funcionario.getId()) {
                atual = atual.esq;
            } else if (funcionario.getId() > atual.funcionario.getId()) {
                atual = atual.dir;
            } else {
                return false;
            }
        }

        if (funcionario.getId() < pai.funcionario.getId()) {
            pai.esq = novo;
        } else {
            pai.dir = novo;
        }

        return true;
    }

    public Funcionario buscar(int id) {
        NoArvore atual = raiz;

        while (atual != null) {
            if (id == atual.funcionario.getId()) {
                return atual.funcionario;
            }

            if (id < atual.funcionario.getId()) {
                atual = atual.esq;
            } else {
                atual = atual.dir;
            }
        }

        return null;
    }

    public boolean remover(int id) {
        if (buscar(id) == null) {
            return false;
        }

        raiz = removerNo(raiz, id);
        return true;
    }

    public void preOrdem() {
        preOrdem(raiz);
    }

    public void inOrdem() {
        inOrdem(raiz);
    }

    public void posOrdem() {
        posOrdem(raiz);
    }

    private NoArvore removerNo(NoArvore atual, int id) {
        if (id < atual.funcionario.getId()) {
            atual.esq = removerNo(atual.esq, id);
        } else if (id > atual.funcionario.getId()) {
            atual.dir = removerNo(atual.dir, id);
        } else {
            if (atual.esq == null) {
                return atual.dir;
            }

            if (atual.dir == null) {
                return atual.esq;
            }

            NoArvore antecessor = atual.esq;
            while (antecessor.dir != null) {
                antecessor = antecessor.dir;
            }

            atual.funcionario = antecessor.funcionario;
            atual.esq = removerNo(atual.esq, antecessor.funcionario.getId());
        }

        return atual;
    }

    private void preOrdem(NoArvore atual) {
        if (atual == null) {
            return;
        }

        System.out.println(atual.funcionario);
        preOrdem(atual.esq);
        preOrdem(atual.dir);
    }

    private void inOrdem(NoArvore atual) {
        if (atual == null) {
            return;
        }

        inOrdem(atual.esq);
        System.out.println(atual.funcionario);
        inOrdem(atual.dir);
    }

    private void posOrdem(NoArvore atual) {
        if (atual == null) {
            return;
        }

        posOrdem(atual.esq);
        posOrdem(atual.dir);
        System.out.println(atual.funcionario);
    }
}
