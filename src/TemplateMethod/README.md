# Template Method

> **Método de modelo** é um padrão que define o esqueleto de um algoritmo na superclasse, mas permite que as subclasses substituam etapas específicas do algoritmo sem alterar a estrutura.

O `Template Method` sugere que se percebermos que diferentes classes executam algoritmos parecidos, **com a mesma** **estrutura de passos,** mas alguns passos são diferentes do contexto, podemos criar um template modelo que agrupe esses métodos. Esse métodos (etapas do algoritmo) podem ser `abstract`(exigindo a implementação nas subclasses), ou ter alguma implementação padrão.

- Dentro dessa classes, vamos ter um template method - método que define as etapas do algoritmo inteiro (sequência de passos). O cliente não pode alterar esse método.

No problema da mineração de dados, podemos criar a seguinte estrutura:

![image.png](https://refactoring.guru/images/patterns/diagrams/template-method/solution-en.png)

Dessa forma, as etapas sendo `abstract` força as subclasses implementarem seus próprios comportamentos, sendo necessário a compatibilidade de assinaturas com a classe base.

Em relação ao código duplicado, não temos muito o que fazer em métodos cujas implementações variam de acordo com o tipo de arquivo. Mas nos que as implementações são iguais / semelhantes, podemos puxá-los para classe base.

Dessa forma, temos dois tipos de passos:

- *Os passos abstratos devem ser implementados nas subclasses;*
- *As etapas opcionais já têm alguma implementação padrão, mas ainda podem ser substituídas se necessário.*

Há outro recurso chamado **gancho (hook),** onde podemos declará-lo como um método vazio ou com implementação simples, servindo como ponto para execução de uma ação extra para modificar ou adicionar algo. Podemos usá-los quando queremos dar a possibilidade das subclasses executarem ações antes ou depois de etapas do algoritmo.

- Método abstrato x Gancho


    **Método abstrato**
    
    **Gancho (Hook)**
    
    ---
    
    - Obrigado implementar
    - Define uma etapa essencial
    - Sem implementação na classe base
    
    - Opcional implementar
    - Define uma etapa secundária
    - Corpo vazio ou padrão simples


## Estrutura

![image.png](https://refactoring.guru/images/patterns/diagrams/template-method/structure-indexed.png)

1. **Uma classe abstrata** para declarar métodos que representam as etapas do algoritmo, bem como o template method que chama esses métodos em uma ordem. Os métodos podem ser `abstract` ou ter uma implementação padrão.
2. **As classes concretas** podem subscrever todos esses métodos, mas não o template method.

## Quando usar?

- Quando quisermos permitir que clientes estendam apenas etapas específicas de um algoritmo, mas não todo o algoritmo ou sua estrutura.
    - Permite transformar um algoritmo monolítico em etapas individuais, mantendo a estrutura da superclasse e permitindo a extensão.
- Quando tivermos várias classes que contêm algoritmos quase idênticos com pequenas diferenças.Como resultado, podemos precisar modificar todas as classes quando o algoritmo mudar.
    - Podemos usar o template method para armazenar códigos idênticos na superclasse, evitando repetição de código.

## Implementação

1. Dividir o algoritmo monolítico em etapas e verificar quais são comuns e quais são únicos.
2. Criar a **classe base abstrata** e declarar o `template method` e os métodos abstratos que representam os passos do algoritmo. Definir a estrutura no template method para executar as etapas.
    - O `template method` deve ser do tipo `final` para evitar sobreposição.
3. Subclasses podem implementar ou não os métodos definidos na superclasse, caso a implementação padrão seja suficiente.
4. Podemos adicionar ganchos entre as etapas cruciais do algoritmo.
5. Para cada variação do algoritmo, devemos criar subclasses concretas.

## Prós e Contras

| **Vantagens** | **Desvantagens** |
| --- | --- |
| Possibilidade dos clientes substituírem apenas partes do algoritmo, diminuindo o impacto de alteração em outras partes do algoritmo. | Clientes limitados a estrutura fornecida do algoritmo. |
| Diminuir o código duplicado através das superclasses. | Violação do princípio da substituição de Liskov (tendo em vista as mudanças na subclasse) |
|  | Template method são difíceis de manter a medida que acrescentamos passos. |