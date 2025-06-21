# Visitor

---

![image.png](https://refactoring.guru/images/patterns/content/visitor/visitor.png)


Padrão que permite separar algoritmos dos objetos em que operam. Permite adicionar comportamentos a objetos existentes sem alterar suas classes.

</aside>

O `visitor` sugere a colocação dos novos comportamentos de classes separadas (chamados de visitantes), em vez de integrá-los a própria classe. O objeto original que deve executar o comportamento é passado como argumento.

- **Caso tenhamos diferentes classes** que implementam o comportamento, mas **com alguma diferença,** podemos criar um conjunto de métodos que se adéquem a essas classes.

    ```java
    class ExportVisitor implements Visitor {
    		public void fazerParaCidade(City c) {...}
    		public void fazerParaIndustria(Industry i) {...}
    }
    ```


Mas como iriamos chamar esses métodos, tendo em vista que temos diferentes tipos de objetos? Não podemos usar polimorfismo, pois as assinaturas são diferentes. Então teríamos que verificar o tipo do objeto:

```java
public class Main {
		public static void main() {
				List<Node> graph = List.of(
						new City(),
            new Industry(),
		        new SightSeeing()
				);
				
				Visitor visitor = new Visitor();
				
				for (Node node : graph) {
						if (node instanceof City) {
								exportVisitor.doForCity((City) node);
						} else if (node instanceof Industry) {
								exportVisitor.doForIndustry((Industry) node);
						}
				}
		}
}
```

- **Por que não podemos usar sobrecarga (overloading)?**
  Overloading é quando declaramos um conjunto de métodos com o mesmo nome, mas com parâmetros diferentes.

    </aside>

    ```java
    void imprimir (City city) {...}
    void imprimir (Industry industry) {...}
    void imprimir (SightSeeing sightseeing) {...}
    ```

  Isso não funciona no nosso caso porque o overloading é resolvido em tempo de compilação, não em tempo de execução.

    ```java
    Node node = new City();
    imprimir(node);
    ```

  O compilador olha o tipo da variável (`Node`), não o tipo real do objeto (`City`).

  ### Tempo de Compilação x Tempo de Execução

  **Tempo de Compilação (Compile Time)** é quando o código é convertido em bytecode (em Java) pelo compilador (`javac`).

  **Tempo de Execução (Runtime)** é quando o programa já está rodando, ou seja, a JVM está executando o bytecode.

  Em nosso contexto, o **Overloading ocorre em tempo de compilação**, ou seja, o compilador olha os tipos das variáveis e escolhe qual método chamar, independentemente do tipo real.

  Já no override (**polimorfismo**) o que vale é o tipo real do objeto, e não o tipo da variável.


No entanto, o `visitor` usa a técnica de **Double Dispatch,** que ajuda a executar o método adequado sem precisar de condicionais. Então, em vez do cliente selecionar o método, essa escolha é feita pelos dois objetos:

1. O objeto visitado (ex.: `City`)
2. O visitante (ex.: `ExportVisitor`)

Cada objeto sabe seu próprio tipo, então ele pode dizer ao visitante: “**Ei, eu sou uma `City`, chama `visitCity(this)`**”.

Embora tenhamos que mudar as classes visitadas (classes de nó), pois precisamos adicionar um método accept(Visitor visitor), isso é uma mudança simples (trivial). Além disso, nunca mais precisaremos alterar essas classes se quisermos adicionar novos comportamentos, pois basta criar novos visitantes que implementam a interface visitor.

### Estrutura

![image.png](https://refactoring.guru/images/patterns/diagrams/visitor/structure-en-indexed.png)

1. **O `visitor`** declara um conjunto de métodos de visita que recebem tipos de objetos diferentes.

    ```java
    public interface Visitor {
    		void visitCity(City city);
        void visitIndustry(Industry industry);
        void visitSightSeeing(SightSeeing sightSeeing);
    }
    ```

2. **Os `visitantes`** implementam várias versões dos mesmos comportamentos, adaptadas para diferentes classes de elementos concretos.

    ```java
    class ExportToXMLVisitor implements Visitor {
        @Override
        public void visitCity(City city) {
            System.out.println("<City>" + city.getName() + "</City>");
        }
    
        @Override
        public void visitIndustry(Industry industry) {
            System.out.println("<Industry>" + industry.getName() + "</Industry>");
        }
    
        @Override
        public void visitSightSeeing(SightSeeing sightSeeing) {
            System.out.println("<SightSeeing>" + sightSeeing.getName() + "</SightSeeing>");
        }
    }
    ```

3. **A interface `Element`** declara o método para aceitar visitantes.

    ```java
    interface Element {
        void accept(Visitor visitor);
    }
    ```

4. **Os `elementos concretos`** implementam o método de aceitação. Esse método vai redirecionar para o método do visitante adequado que corresponde a seu tipo.

    ```java
    class City implements Element {
        private String name;
    
        public City(String name) {
            this.name = name;
        }
    
        public String getName() {
            return name;
        }
    
        @Override
        public void accept(Visitor visitor) {
            visitor.visitCity(this);
        }
    }
    ```

5. **O `cliente`** geralmente possuí uma coleção de objetos (lista, árvore, grafo) do tipo Element (abstrações) e aplica visitantes sobre ele. Isso porque normalmente não estão cientes de todos os elementos concretos

    ```java
    public class Client {
        public static void main(String[] args) {
            List<Element> elements = List.of(
                    new City("São Paulo"),
                    new Industry("Fábrica X"),
                    new SightSeeing("Cristo Redentor")
            );
    
            Visitor exportVisitor = new ExportToXMLVisitor();
    
            for (Element element : elements) {
                element.accept(exportVisitor);
            }
        }
    }
    ```


### Quando usar?

- Quando precisamos executar uma operação em todos os elementos de uma estrutura de objetos (arvore, grafo, lista).
    - Permite executar operações em classes diferentes, tendo um objeto visitante que tenha variações correspondentes a todos os tipos de classes.
- Quando precisamos limpar a lógica de negócios dos comportamentos auxiliares.
    - As classes primárias ficarão focadas em suas responsabilidades, deixando outros comportamentos em visitantes.
- Quando um comportamento faz sentido apenas em algumas classes de uma hierarquia, mas não em todas.
    - Nos visitantes, vamos implementar métodos apenas para os tipos de classes que podem aceitá-lo.

### Implementação

1. Criamos a interface visitante com os métodos de visita para cada tipo de elemento concreto.
2. Declaramos a interface `Element`. Se estivermos trabalhando com uma hierarquia de classes, devemos adicionar um método de aceitação que deve aceita um visitante como argumento.
3. Implementar o método de aceitação em todas as classes de elementos concretos. Devem redirecionar o visitante para o método correspondente ao tipo da classe.
4. Os elementos concretos só se relacionam com os visitantes através da interface `Visitor`.
5. Para cada comportamento devemos criar uma nova classe visitante que implemente os métodos de visita.
    1. **Em algumas situações os visitantes precisam acessar estados, comportamentos privados das classes visitadas. Podemos solucionar esse problema de 2 formas:**
        - Deixar campos/métodos públicos (viola o encapsulamento) ou criar getters:

            ```java
            public class City implements Element {
                private String nome;
            
                public String getNome() {
                    return nome;
                }
            
                @Override
                public void accept(Visitor visitor) {
                    visitor.visit(this);
                }
            }
            ```

        - Criar os visitantes aninhados aos elementos:

            ```java
            public class City implements Element {
                private String nome;
            
                public City(String nome) {
                    this.nome = nome;
                }
            
                @Override
                public void accept(Visitor visitor) {
                    visitor.visit(this);
                }
            
                public static class ExportVisitor implements Visitor {
                    @Override
                    public void visit(City city) {
                        // Acesso direto ao membro privado
                        System.out.println("<City>" + city.nome + "</City>");
                    }
            
                    // Outros métodos visit()...
                }
            }
            ```

6. Os clientes devem criar os objetos visitantes e passá-los para elementos através dos métodos de aceitação.

### Prós e Contras

| Prós | Contras |
| --- | --- |
| Princípio aberto / fechado (novos comportamentos que trabalham com diferentes classes sem alterá-las). | Sempre que adicionamos uma classe de elemento ou removida precisamos alterar os visitantes. |
| Princípio de responsabilidade única | Os visitantes podem não ter acesso aos elementos das classes visitadas. |
| Visitantes podem acumular informações e guardar resultados de cada visita. (útil quando temos uma estrutura de objetos e aplicamos o visitante) |  |