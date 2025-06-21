# SortingStrategyProblem

---

## Contexto: 

Você tem uma aplicação que ordena listas grandes, mas a ordem depende do tipo de dado e da situação.

Regras de negócio:

- Dados numéricos devem usar QuickSort.

- Strings curtas com poucos caracteres usam BubbleSort (porque o custo de comparação é baixo).

- Objetos complexos com múltiplos critérios usam MergeSort com comparadores personalizados.

Aqui, você pode criar diferentes estratégias de ordenação e mudar dinamicamente dependendo da análise dos dados.