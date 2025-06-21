package Visitor.problemas.Passagens.good;

public interface Visitor {
    double visitar(PassagemEstudante passagemEstudante);
    double visitar(PassagemComum passagemComum);
    double visitar(PassagemIdoso passagemIdoso);
    double visitar(PassagemCrianca passagemCrianca);
}
