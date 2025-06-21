# State

![image.png](https://refactoring.guru/images/patterns/diagrams/state/problem1.png)

Permite que um objeto altere seu comportamento quando um estado interno muda, como se mudasse de classe.


Ele sugere que devemos criar classes específicas para todos os estados e extrair seus comportamentos nas mesmas.

Em vez do contexto o comportamento dos estados, ele armazenará uma referência a um dos objetos de estado e delegara todo o trabalho relacionado ao estado a esse objeto.

### Quando usar?

- **Temos um objeto que pode ter vários estados e em cada estado temos comportamentos diferentes, podendo mudar o código com frequência.**
    - Vamos extrair os códigos específicos de cada estado e colocá-los em classes distintas, deixando-os independentes uns dos outros.
- **Quando tivermos classes com muitas condicionais que alteram o comportamento da classe de acordo com os valores dos atributos.**
  - 
- **Quando temos muito código duplicado em estados semelhantes e transições baseadas em condicionais.**
    - Na prática temos hierarquias de classes de estados e redução de duplicação de código através de classes abstratas.

### Estrutura do State

![image.png](https://refactoring.guru/images/patterns/diagrams/state/structure-en-indexed.png)

1. **O contexto** armazena uma referencia ao estado atual concreto através de seu objeto e delega todo o trabalho ao estado.
    - Ele se comunica com os estados através de uma **interface**.
    - Um método setter é responsável por mudar o objeto de estado.
2. **A interface** declara os métodos específicos para todos os estados.
3. **Os estados concretos** fornecem suas próprias implementações para os métodos específicos do estado.
    - Classes abstratas intermediárias podem ser criadas caso tenhamos código duplicado em vários estados, encapsulando comportamentos comuns.
    - Podemos armazenar uma referência ao **contexto,** facilitando as transições de estado e a busca por informações necessárias.
    - Tanto aqui, como no contexto, podemos definir quais os próximos estados e realizar as transições substituindo o objeto do contexto.

### Implementação

1. Escolhemos a classe de contexto, podendo ser uma nova ou uma existente que já tenha código específico para cada estado.
2. Declaramos a interface do estado.
3. Para cada estado real, criamos classes que implementem a interface e colocamos o código específico dele.
4. Adicione um campo de referência ao estado através do tipo da interface e um método setter público para anular o valor do campo de estado.
5. Substituir as condicionais de estado no contexto por chamadas para métodos do objeto de estado.
6. Para mudar o contexto, devemos instanciar o estado que queremos e passar para o contexto. Isso pode ser feito dentro do próprio contexto, dentro dos estados ou no cliente.

### Prós e Contras

| Prós | Contras |
| --- | --- |
| Princípio de responsabilidade única (organização do código específico de cada estado em classes separadas). | Se a máquina de estados tiver poucos estados ou raramente mudar, isso é exagero. |
| Princípio aberto / fechado (introdução de novos estados por meio de novas classes). |  |
| Simplificação do contexto e eliminação de condicionais volumosas. |  |

### State x Strategy

A diferença é que no state, cada **estado normalmente tem conhecimento dos outros** e iniciar transições entre eles. Enquanto que no strategy, **quase nunca as estratégias conhecem umas as outras**.