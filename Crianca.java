public class Crianca extends Visitante implements Atividades, MenorDeIdade {
    private String responsavel;

    public Crianca(String nome, int anoDeNascimento, String responsavel, int telefone) {
        super(nome, anoDeNascimento);
        this.responsavel = responsavel;
        this.telefone = telefone;
    }
    

    @Override
    public void visitar() {
        System.out.println(nome + " está visitando.");
    }

    @Override
    public Integer setIngresso() {
        this.ingresso = Ingresso.getNextIngresso();
        return ingresso;
    }

    @Override
    public String getResponsavel() {
        return responsavel;
    }

    @Override
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public int setTelefoneResponsavel(int telefone) {
        this.telefone = telefone;
        return telefone;
    }
}