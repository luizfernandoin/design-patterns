# PaymentStrategyProblem

---

## Contexto: 

Sistema de pagamento de uma loja online com diferentes formas de pagamento.

Regras de negócio:

- Cartão de crédito cobra taxa de 3% sobre o valor.

- Boleto bancário tem 5% de desconto.

- PIX tem isenção de taxas, mas exige validação de chave.

Aqui, o Strategy ajuda a isolar cada forma de pagamento como uma estratégia diferente — facilitando manutenção e novos métodos no futuro.