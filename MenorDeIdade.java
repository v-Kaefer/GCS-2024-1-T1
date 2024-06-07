public interface MenorDeIdade {
    Adulto getResponsavel(Visitante visitante);
    Adulto buscaAdulto(String nomeDoResponsavel);
    int setTelefoneResponsavel(int telefone);
}