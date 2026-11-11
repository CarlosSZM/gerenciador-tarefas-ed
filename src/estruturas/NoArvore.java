package estruturas;

import modelo.Funcionario;

class NoArvore {

    Funcionario funcionario;
    NoArvore esq;
    NoArvore dir;

    NoArvore(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
