# Strategy

> O **strategy** permite definir uma família de algoritmos (estratégias), encapsulá-los e torná-los **intercambiáveis.** Permitindo:

- Alteração do comportamento do objeto em tempo de execução.

> “encapsulá-los e torná-los **intercambiáveis**”? Isso significa que vamos colocar os algoritmos em classes separadas, escondendo os detalhes internos. Além disso, tornar intercambiável significa que podemos trocar as estratégias a qualquer momento - como se trocasse peças de um jogo.

### Quando usar?

- Quando temos múltiplas variações de um algoritmo.
- Quando queremos evitar muitos ifs para decidir qual algoritmo usar;
- Quando queremos deixar o código mais flexível, limpo e reutilizável.

<aside>
💡

Basicamente é o padrão que elimina if, else, switch. Ao invés deles, nós escolhemos o comportamento através de injeção.

</aside>

Quando temos variações de um mesmo tipo de comportamento (algoritmo). Para não usarmos condicionais para definir qual variação de algoritmo usar, podemos utilizar o `Strategy`.

Vale ressaltar que esse padrão segue o princípio **open** / **closed** do SOLID.

### Estrutura do Strategy

```lua
+--------------------+        +------------------------+
| Context            | -----> | Strategy (interface)   |
| - strategy         |        +------------------------+
| + setStrategy()    |                   ▲
| + execute()        |                   |
+--------------------+      +------------------------+
                            | ConcreteStrategyA       |
                            +------------------------+
                            | ConcreteStrategyB       |
                            +------------------------+
```

Basicamente, vamos criar uma interface que agrupa a família de algoritmos, de forma que possamos escolher, trocar ou estender esses comportamentos sem modificar o código que os usa.

O contexto também deve ter um método para mudar a estratégia ativa, permitindo a mudança no comportamento do algoritmo.

![image.png](https://refactoring.guru/images/patterns/diagrams/strategy/structure-indexed.png)

- **Código ruim (sem strategy)**

  Antes de usar o strategy, nossa classe fica com muitas variações de lógicas para o mesmo algoritmo, ficando dependente de condicionais para decidir qual estratégia usar:

    ```java
    public class CalculadoraFrete {
        public double calcularFrete(String tipoFrete, double peso) {
            if (tipoFrete.equalsIgnoreCase("SEDEX")) {
                return 20 + peso * 2;
            } else if (tipoFrete.equalsIgnoreCase("PAC")) {
                return 10 + peso * 1.5;
            } else if (tipoFrete.equalsIgnoreCase("RETIRADA")) {
                return 0;
            } else {
                throw new IllegalArgumentException("Tipo de frete inválido: " + tipoFrete);
            }
        }
    }
    ```

  Já com o strategy, criamos uma interface que será referenciada no contexto e quando quisermos adicionar novas estratégias basta implementar a interface:

    1. **Context:** mantém uma referência a uma das estratégias concretas e se comunica com este objeto apenas através da interface de estratégia.

        ```java
        package Strategy.good;
        
        public class CalculadoraFrete {
            private FreteStrategy freteStrategy;
        
            public CalculadoraFrete(FreteStrategy freteStrategy) {
                this.freteStrategy = freteStrategy;
            }
        
            public void setFreteStrategy(FreteStrategy freteStrategy) {
                this.freteStrategy = freteStrategy;
            }
        
            public double calcular(double peso) {
                return freteStrategy.calcularFrete(peso);
            }
        }
        ```

    - **Strategy (Interface):** declara métodos que o contexto usa para executar uma estratégia.

        ```java
        package Strategy.good;
        
        public interface FreteStrategy {
            double calcularFrete(double peso);
        }
        ```

    - **Strategy concretas:** implementam variações de um algoritmo que o contexto usa.

        ```java
        package Strategy.good;
        
        public class FretePAC implements FreteStrategy {
            @Override
            public double calcularFrete(double peso) {
                return 10 + peso * 1.5;
            }
        }
        
        package Strategy.good;
        
        public class FreteRetiradaLoja implements FreteStrategy {
            @Override
            public double calcularFrete(double peso) {
                return 0;
            }
        }
        
        package Strategy.good;
        
        public class FreteSedex implements FreteStrategy {
            @Override
            public double calcularFrete(double peso) {
                return 20 + peso * 2;
            }
        }
        ```

    - O contexto chama o método de execução no objeto de estratégia vinculado cada vez que precisa executar o algoritmo. O contexto não sabe com que tipo de estratégia ele funciona ou como o algoritmo é executado.

### Prós e Contras

| Prós | Contras |
| --- | --- |
| Podemos trocar algoritmos dentro do objeto em tempo de execução. | Se temos poucos algoritmos e raramente mudam, não há razão para complicar o sistema. |
| Podemos isolar detalhes de implementação do algoritmo. | Clientes devem estar cientes das diferenças de estratégias, visto que eles que às escolhem. |
| Substituímos a herança pela composição. | Muitas linguagens permitem implementar versões de algoritmos em funções anônimas, com a vantagens de não inchar o código. |
| Segue o princípio aberto / fechado. |  |