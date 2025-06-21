# Observer

![image.png](https://refactoring.guru/images/patterns/content/observer/observer.png)

<aside>

Padrão que permite notificar múltiplos objetos sempre que um estado de outro objeto muda. Como se fosse um **mecanismo de assinaturas** para **notificar os objetos** **sobre eventos** que acontecem **no** **objeto observado**.

</aside>

Os **objetos que possuem estados** de interesse são **chamados de sujeito**, mas como também vão notificar outros objetos sobre as mudanças em seu estado, **podemos chamá-los de editor**. Todos os **objetos interessados nos estados** do editor e desejam acompanhá-los **são chamados de assinantes**.

- **Temos 2 tipos de entidades aqui:**
    - Subject (Sujeito, Observable, Source, Event Source, Provedor, Gerador de Eventos) → objeto principal que desejamos monitorar um estado (objeto que contem informações interessantes);
    - Observers (Observadores, Listener) → objetos que recebem a notificação de mudança de estado do subject e reagem automaticamente (cliente, interessado na informação).

O padrão `Observer` sugere que adicionemos um mecanismo de assinatura ao editor para que objetos individuais possam inscrever-se ou cancelar a inscrição em um fluxo de eventos. Basicamente, esse mecanismo consiste em:

1. Uma campo de matriz para armazenar a lista de objetos assinantes;
2. Métodos públicos para adicionar ou remover assinantes da lista.

![image.png](https://refactoring.guru/images/patterns/diagrams/observer/solution1-en.png)

Devemos levar em consideração que um aplicativo pode ter dezenas de diferentes objetos assinantes interessados em rastrear eventos do mesmo editor. Não podemos criar uma lista de assinantes para cada tipo. Então, devemos criar uma interface que será implementada por todos os assinantes e por onde o editor se comunicará com eles.

Essa interface deve declarar o método de notificação junto com um conjunto de parâmetros que o editor pode usar para passar dados junto a notificação.

![image.png](https://refactoring.guru/images/patterns/diagrams/observer/solution2-en.png)

Podemos ir mais longe em um cenário onde temos vários tipos de editores e queremos tornar os assinantes compatíveis com todos eles. Podemos declarar uma interface para os editores, onde terá métodos de assinatura.

### Quando usar?

- Quando queremos permitir um `desacoplamento dinâmico`.
    - A área de notificações (editor ou subject) sabe que exitem apps que implementam o Observer, mas não sabe que apps são esses.
- Quando alterações no estado de um objeto pode exigir alterações de outros objetos, e o conjunto desses objetos é desconhecidos ou muda dinamicamente.
  - 
- Quando alguns objetos devem observar outros, mas apenas por um tempo limitado ou em casos específicos.
    - A lista de assinaturas é dinâmica.

### Estrutura do State

![image.png](https://refactoring.guru/images/patterns/diagrams/observer/structure-indexed.png)

1. **Publisher (subject, editor) →** emite eventos (notificações) aos objetos interessados, sempre que seu estado muda ou executa algum comportamento. Eles contêm uma infraestrutura de assinatura que pode adicionar ou remover assinantes.
2. Sempre que um evento acontece, o `editor / subject` revisa a lista de assinaturas e chama o método de notificação declarado na interface dos assinantes.
3. **O subscriber (observer)** declara a interface de notificação. Possui um método `update` que pode conter parâmetros para o **Publisher** enviar detalhes do evento junto a notificação.
4. **Os subscribers concretos (observers)** executam ações em resposta às notificações emitidas pelo editor. Elas devem implementar a interface `Subscriber / Observer` para que o editor não seja acoplado aos subscribers concretos.
5. Normalmente os assinantes passam informações pelos argumentos do `Subscriber` para que lidem corretamente com as atualizações. Podem passar eles mesmos, permitindo o assinante buscar mais informações necessárias.

### Implementação

- Implementação
    1. Observer ou Notificavel

        ```java
        public interface Observer {
        		void notificar(String mensagem);
        }
        ```

    2. Apps que implementam a interface

        ```java
        public class WhatsApp implements Observer {
        		public void notificar(String mensagem) {
        				System.out.println("WhatsApp recebeu: " + mensagem)
        		}
        }
        
        public class Email implements Observer {
            public void notificar(String mensagem) {
                System.out.println("Email recebeu: " + mensagem);
            }
        }
        ```

    3. Subject

        ```java
        public class AreaDeNotificacao {
        		private List<Observer> inscritos = new ArrayList<>();
        		
        		public void registrar(Observer o) {
        				inscritos.add(o);
        		}
        		
        		public void remover(Observer o) {
        				inscritos.remove(o);
        		}
        		
        		public void novaNotificacao(String mensagem) {
        				for (Observer o : inscritos) {
        						n.notificar(mensagem);
        				}
        		}
        }
        ```

1. Devemos dividir nossa lógica em duas partes: a funcionalidade principal (independente) como `Subject`; e o resto que se tornará `Observers`.
2. Declarar a interface assinante com um método `update`.

    ```java
    public interface Assinante {
        void update(String evento);
    }
    ```

3. Declarar a interface editor com os métodos para adicionar e remover os assinantes.

    ```java
    public interface Editor {
        void adicionarAssinante(Assinante a);
        void removerAssinante(Assinante a);
        void notificar(String evento);
    }
    ```

4. Podemos declarar uma classe abstrata que guardará a lista de assinantes e implementa a interface editor para implementar os métodos para adicionar e remover. Os `Subjects` estenderão essa classe, visto que possui o comportamento comum.

    ```java
    public abstract class EditorBase implements Editor {
        private List<Assinante> assinantes = new ArrayList<>();
    
        public void adicionarAssinante(Assinante a) {
            assinantes.add(a);
        }
    
        public void removerAssinante(Assinante a) {
            assinantes.remove(a);
        }
    
        public void notificar(String evento) {
            for (Assinante a : assinantes) {
                a.update(evento);
            }
        }
    }
    ```

   Podemos usar nos editores concretos:

    ```java
    public class Botao extends EditorBase {
        public void clicar() {
            System.out.println("Botão clicado!");
            notificar("click");
        }
    }
    ```

    - Se a classe já estende de outra, podemos usar composição:

        ```java
        public class Botao {
            private MecanismoDeAssinatura assinatura = new MecanismoDeAssinatura();
        
            public void adicionarAssinante(Assinante a) {
                assinatura.adicionar(a);
            }
        
            public void clicar() {
                assinatura.notificar("click");
            }
        }
        ```

5. Crie editores concretos que disparam os eventos de notificação.
6. Crie os assinantes concretos e implementar os métodos de notificação de atualização.

    ```java
    public class AlertaVisual implements Assinante {
        public void update(String evento) {
            System.out.println("Exibindo alerta: " + evento);
        }
    }
    ```

7. O cliente cria os assinantes e registra-os nos editores.

    ```java
    Botao botao = new Botao();
    botao.adicionarAssinante(new AlertaVisual());
    botao.adicionarAssinante(new LogDeClique());
    
    botao.clicar();
    ```


### Prós e Contras

| Prós | Contras |
| --- | --- |
| Princípio aberto / fechado (adicionamos novos assinantes pelo acréscimo de classes). | Os assinantes são notificados em ordem aleatória. |
| Podemos estabelecer relações entre objetos em tempo de execução. |  |