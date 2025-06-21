# CompressionStrategyProblem

---

## Contexto: 

> Ferramenta de backup que comprime arquivos de forma diferente dependendo do tipo.

## Regras de negócio:
- Imagens (.png/.jpg) usam compressão por dicionário (tipo LZW).
- Arquivos de texto usam compressão Huffman.
- Vídeos usam compressão baseada em blocos (como H.264).

Cada algoritmo é uma estratégia diferente, e a seleção pode ser feita automaticamente ou pelo usuário.