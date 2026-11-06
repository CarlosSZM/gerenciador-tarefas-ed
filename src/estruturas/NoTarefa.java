package estruturas;

import modelo.Tarefa;

class NoTarefa {

    Tarefa tarefa;
    NoTarefa proximo;

    NoTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
        this.proximo = null;
    }
}
