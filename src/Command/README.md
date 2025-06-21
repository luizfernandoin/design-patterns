# Command

**O command** é um padrão que transforma as requisições em objetos independentes que contém todas as informações da solicitação.

Dessa forma, o `command` permite:

1. Passar solicitações como argumentos:

    ```java
    Command ligarLuz = new LigarLuzCommand();
    Command desligarLuz = new DesligarLuzCommand();
    
    botao.setCommand(ligarLuz);
    botão.clicar();
    
    botao.setCommand(desligarLuz);
    botao.clicar();
    ```

2. Executar solicitações de forma atrasada (fila de comandos);

    ```java
    filaDeComandos.add(new LigarArCommand());
    filaDeComandos.add(new LigarTVCommand());
    
    for (Command cmd : filaDeComandos) {
    		cmd.executar();
    }
    ```

3. Envolver a execução

    ```java
    System.out.println("Executando...");
    comando.executar();
    System.out.println("Executado com sucesso.");
    ```

4. Suporte operações factíveis (complicadas sem command):
    1. 🔄 Desfazer/Refazer (Undo/Redo)
    2. ⏯ Pausar ou agendar execução
    3. 🗂 Armazenar sequências de comandos (macro)
5. Log de requisições

    ```java
    historicoDeComandos.add(new LigarLuzCommand());
    ```

6. Suportar operações reversíveis (Undo/Redo)
    1. Podemos implementar método para desfazer:

        ```java
        public interface Command {
        		void executar();
        		void desfazer();
        }
        
        Command ligarSom = new LigarSomCommand(som);
        ligarSom.executar();
        
        historico.push(ligarSom);
        
        // Depois:
        historico.pop().desfazer();
        ```

Normalmente, um bom design de software se baseia no *princípio de separação de preocupações*, que basicamente divide o aplicativo em camadas. Por exemplo, o aplicativo possui um interface (GUI) e uma camada para regras de negócios (services).

Na prática, sempre que um evento ocorre na interface, a GUI delega o trabalho aos services através de requisições para métodos, ou seja, temos um objeto de negócio e a interface chama um método seu passando algum parâmetro necessário.

![image.png](https://refactoring.guru/images/patterns/diagrams/command/solution1-en.png)

O `command` sugere que essas solicitações não sejam acopladas diretamente ao objeto de serviço, mas encapsular os dados da requisição em um objeto, contendo:

- Quem será chamado (service);
- O que será feito (método);
- Com quais dados (argumentos).

Esse objetos independentes são chamados `objetos de comando`, servindo como uma ponte (link) entre os objetos GUI e os serviços. Dessa forma, os objetos GUI não sabem qual objeto da regra de negócios recebe a solicitação, mas apenas um `command` que lida com os detalhes.

![image.png](https://refactoring.guru/images/patterns/diagrams/command/solution2-en.png)

Para que a interface não fique acoplada diretamente aos comandos, devemos fazer com que os comandos implementem uma interface comum. Normalmente, ela tem um único método de execução sem parâmetros. Assim, podemos alterar entre os comandos em tempo de execução:

```java
public class Botao {
		Command comando;
		
		public Botao(Command comando) {
				this.comando = comando;
		}
		
		public void setComando(Command comando) this.comando = comando;
}
```

Agora, devemos nos perguntar: e os parâmetros da requisição? Tendo em vista que o método de execução da interface não possui parâmetros. A resposta é que os commandos devem ser previamente configurados com essas informações ou capaz de obtê-los por conta própria.

![image.png](https://refactoring.guru/images/patterns/diagrams/command/solution3-en.png)

Dessa forma, agora não precisamos criar toneladas de subclasses que implementem cada comportamento de um objeto de interface, como ocorria no editor de texto. Precisamos, apenas, criar vários commandos para as operações possíveis e armazenar uma referência no objeto que irá usar esses comandos. Assim, não teremos duplicidade de código, já que podemos usar o mesmo comando em diferentes objetos.

> Os comandos tornam-se uma camada intermediária entre a GUI e as regras de negócios, reduzindo o acoplamento.
>

## Estrutura

![image.png](https://refactoring.guru/images/patterns/diagrams/command/structure-indexed.png)

1. **A classe `Sender` (invocados - invoker)** é responsável por disparar solicitações. Armazena uma referência ao objeto de comando. Ela recebe o command pelo construtor e apenas executa-o.
2. **A interface de comando** declara métodos para executar o comando ou desfazer em alguns casos.
3. **As classes de comando concretas** implementam os tipos de solicitações (comportamentos). Elas não executam as ações, mas passam a chamada para os objetos de regra de negócio.
    - Os parâmetros necessários nos métodos do `receptor` podem ser declarados como campos no comando concreto. Podemos torná-los imutáveis, permitindo apenas suas inicializações pelo construtor.
4. **A classe `Receiver`** contém a lógica de negócio. Dessa forma, os comandos manipulam os detalhes da solicitação que é passada para o receptor, e ele faz o trabalho real.
5. **O `Cliente`** cria e configura objetos de comandos. Ele deve passar os parâmetros da solicitação, incluindo uma instância do destinatário, para o construtor do comando. Esses comandos podem ser associados a vários remetentes.

## Quando Usar?

- Quando quisermos parametrizar objetos com operações.
    - O `Commando` transforma uma chamada de método em um objeto autônomo. Permitindo: passar comandos como argumentos de métodos, armazená-los em objetos, alterar comando vinculados em tempo de execução, etc.
- Quando quisermos fazer filas, agendar a execução ou executá-los remotamente.
    - Podemos serializar o comando (convertê-lo para um cadeia de caracteres) para gravar em disco e permitir restauração. Ou ainda criar filas, registrar ou enviar comandos pela rede, atrasando ou agendando a execução do mesmo.
- Quando quisermos implementar operações reversíveis.
    - Mais popular para implementar o undo/redo.
    - Para reverter operações, precisamos implementar um histórico de operações. Trata-se de uma pilha que contém os objetos de comando executados e os backups relacionados ao estado do aplicativo.

## Implementação

1. Declaramos a **interface de comando** com os métodos de execução e talvez de reversão.
2. Extrair as solicitações em **classes de comando concretas** que **implementem a interface `Command`.** Devem ter campos para armazenar os argumentos de solicitação e uma referência ao objeto receptor real. Devem ser inicializados pelo construtor.
3. Criar os **remetentes** que devem armazenar uma referência ao `Command`, comunicando através da interface. Não criam os comandos concretos, mas recebem pelo construtor.
4. Altere os remetentes para executar os comandos em vez de se comunicar diretamente com as regras de negócios (destinatário).
5. **O cliente** deve inicializar objetos na ordem:
    - Criar receptores.
    - Criar comandos e associar aos receptores, se necessário.
    - Criar remetentes e associar a comandos específicos.

## Prós e Contras

| Vantagens | Desvantagens |
| --- | --- |
| Princípio de responsabilidade única (separar classes que invocam operações das que executam) | Complexidade, pois estamos adicionando uma nova camada intermediária. |
| Princípio aberto/fechado (novos comandos apenas adicionando novas classes) |  |
| Implementar undo/redo |  |
| Implementar a execução diferida das operações (execução agendada através de filas) |  |
| Combinar comandos simples em um complexo. |  |