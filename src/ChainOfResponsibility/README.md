# Chain of Responsibility

> **Chain of Responsibility** é um padrão que permite passar solicitações por uma cadeia de manipuladores. Cada manipulador processa a solicitação ou passa para o próximo manipulador da cadeia.

![image.png](https://refactoring.guru/images/patterns/content/chain-of-responsibility/chain-of-responsibility.png)

Basicamente, o `Chain of Responsibility` é uma cadeia de middlewares, onde cada comportamento particular do sistema (verificações) se transformam em objetos autônomos (chamados de **manipuladores**). Essas classes possuem:

- Um método único para realizar a verificação;
- Recebe como argumentos a solicitação e seus dados.

Esse padrão também implementa uma lógica de `fila encadeada`, visto que cada manipulador é vinculado em uma cadeia, possuindo uma referência ao próximo. A solicitação é passada por todos os manipuladores, a não ser que um manipulador decida não passá-la adiante e parar o processamento adicional.

![image.png](https://refactoring.guru/images/patterns/diagrams/chain-of-responsibility/solution1-en.png)

Entretanto, outra abordagem diferente corresponde ao manipulador decidir se pode processar uma solicitação ao recebê-la. Se puder, a solicitação não passa adiante, ou seja, apenas um manipulador realizará a requisição. Isso é comum em uma hierarquia de componentes em uma GUI:

![image.png](https://refactoring.guru/images/patterns/diagrams/chain-of-responsibility/solution2-en.png)

exemplo: ao clicar em um botão, o evento se propaga pelos componentes até chegar a janela principal, sendo processado pelo primeiro manipulador da cadeia capaz de processá-lo.

Ademais, as classes de manipuladores devem implementar a mesma interface, evitando o acoplamento entre as mesmas. Devendo apenas se preocupar se possuem um método comum entre elas (`execute`) imposta no contrato.

## Estrutura

![image.png](https://refactoring.guru/images/patterns/diagrams/chain-of-responsibility/structure-indexed.png)

1. **O `Handler`** declara a interface, comum a todos os manipuladores concretos. Normalmente possui um único método para executar solicitação, mas pode ter um segundo para definir o próximo manipulador da cadeia.
2. **O Manipulador de Base** é uma classe opcional que podemos adicionar código boilerplate comum a todos os manipuladores.
    1. Normalmente, temos um campo para referenciar o próximo manipulador. Podemos passar o manipulador para o construtor ou setter do manipulador anterior. A classe pode implementar o comportamento padrão que é passar a execução para o próximo manipulador após verificar sua existência.
3. **Os manipuladores concretos** contêm o código real para processar solicitações. Ao receber uma solicitação, cada manipulador deve decidir se vai processar e passar ao longo da cadeia.
    1. Geralmente são auto-suficientes e imutáveis, aceitando os dados apenas uma vez pelo construtor.
4. **O cliente** pode compor/definir uma cadeia fixa no início da execução ou compor-nas dinamicamente. Entretanto, podemos começar de qualquer pondo na cadeia, não necessariamente do primeiro manipulador.

## Quando usar?

- Quando se espera que o programa processe diferentes tipos de solicitações de várias maneiras, mas os tipos exatos de solicitação e as sequências são desconhecidas de antemão.
    - Permite vincular vários manipuladores em uma cadeia e permitir que o manipulador decida se vai processar ou passar ao longo da cadeia.
- Quando é essencial executar vários manipuladores em uma ordem específica.
    - Ao vincular os manipuladores em uma ordem, todas as requisições passaram exatamente como planejado.
- Quando o conjunto de manipuladores e sua ordem devem mudar em tempo de execução.
    - Precisamos fornecer setters para a referência dentro dos manipuladores, permitindo inserir, remover ou reordená-los.

## Implementação

1. Declaramos a **interface do manipulador** e crie um método para lidar com as solicitações.

   Devemos decidir se vamos passar os dados da solicitação no método. A maneira flexível é converter a solicitação em um objeto e passá-lo como argumento.

2. Podemos criar uma classe de manipulador base abstrata que implemente a interface do manipulador. Isso evita código boilerplate duplicado nos manipuladores concretos.
    - Deve ter um campo para referenciar o próximo manipulador da cadeia. Se desejarmos modificar cadeias em tempo de execução, podemos definir um setter.
    - Podemos implementar o comportamento padrão para o método de manipulação, que é encaminhar a solicitação para o próximo objeto. Os manipuladores concretos poderão chamar o método pai.
3. Criar subclasses de manipuladores de concreto e implementar os métodos de manuseio. Eles tomam duas decisões ao receber uma requisição:
    - Se vai processar o pedido;
    - Se vai passar o pedido ao longo da cadeia.
4. **O cliente** pode montar cadeias ou receber pré-construidas de outros objetos (classes de fábrica constroem cadeias com as configurações de ambiente).
5. **O cliente** pode acionar qualquer manipulador, não apenas o primeiro. A solicitação é passada pela cadeia até algum se recusar a passar ou chegar ao final da cadeia.
6. Devido a dinamicidade da cadeia, o cliente deve estar pronto para lidar com cenários:
    - A cadeia pode consistir em um único elo.
    - Alguns pedidos podem não chegar ao fim da cadeia.
    - Outros podem chegar ao fim de cadeia sem manusear.

## Prós e Contras

| Vantagens | Desvantagens |
| --- | --- |
| Podemos controlar a ordem dos manipuladores. | Algumas requisições podem acabar sem manuseamento. |
| Princípio de responsabilidade única (classes que invocam operações são separadas das que executam) |  |
| Princípio aberto/fechado (introduzir manipuladores apenas criando novas classes sem quebrar o código do cliente) |  |