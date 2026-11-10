# Gerenciador de Tarefas Corporativas

Projeto da disciplina Estrutura de Dados 2026.2, desenvolvido em Java para organizar funcionários e tarefas de um projeto.

## Estruturas utilizadas

- **Árvore binária de busca:** organiza funcionários pelo ID e permite inserir, localizar, remover e listar em in-ordem, pré-ordem e pós-ordem.
- **Fila encadeada:** organiza o backlog pela ordem de chegada e permite adicionar, consultar, remover e listar tarefas.
- **Pilha encadeada:** prevista para guardar tarefas excluídas e permitir desfazer a exclusão. A implementação da pilha ainda está em andamento.

As estruturas são implementadas manualmente com nós. O projeto não usa coleções prontas do Java.

## Funcionalidades do sistema

- Cadastrar, buscar, remover e listar funcionários.
- Criar tarefas, atribuir ao funcionário a próxima tarefa da fila, concluir a próxima tarefa do backlog e remover tarefas.
- Restaurar uma tarefa removida quando a implementação da pilha estiver concluída.

## Como executar no Windows

É necessário ter o JDK instalado. No PowerShell, na pasta principal do projeto, compile os arquivos com:

```powershell
javac -d out (Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
```

Depois inicie o menu com:

```powershell
java -cp out aplicacao.Main
```

No IntelliJ IDEA, abra o projeto e execute a classe `aplicacao.Main`.
