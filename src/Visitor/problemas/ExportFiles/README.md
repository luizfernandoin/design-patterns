Imagine que temos um aplicativo de geolocalização, onde podemos ter entidades complexas (cidades, por exemplo), como também entidades granulares (indústrias, locais turísticos, etc). Esses nós (objetos) podem estar conectados caso tenham estradas entre os objetos reais.

![image.png](https://refactoring.guru/images/patterns/diagrams/visitor/problem1.png)

Em determinado dia, somos designados a implementar uma funcionalidade de exportação do gráfico para formato XML. Inicialmente poderíamos fazer isso simplesmente com:

- Adicionando um método de exportação a cada classe de nó e de forma recursiva passar por cada um executando o método de exportação.
    ```java
    public interface Node {
            void exportar();
    }
    ```
    
    ```java
    public class City implements Node {
            @Override
        public void exportar() {
            System.out.println("Exportando cidade para XML...");
        }
    }
    ```
    
    ```java
    public class Main {
            public static void main(String[] args) {
                    List<Node> graph = List.of(new City());
                    
                    for (Node node : graph) {
                            node.exportar();
                    }
            }
    }
    ```

O visitor existe para evitar que se precisasse adicionar um novo comportamento, como exportar para JSON, gerar PDF ou fazer uma validação, não tivesse que adicionar métodos em todas as classes.


Entretanto, nova regra foi imposta: não se pode alterar as classes dos nós existentes, pois pode-se quebrar o código em produção e causar um bug. Além disso, essa função de exportação para XML não parece responsabilidade das classes dos nós, pois eles trabalham apenas com geodata.

![image.png](https://refactoring.guru/images/patterns/diagrams/visitor/problem2-en.png)

E se alguém pedisse para implementar novas funções de exportação para outros formatos de documento?