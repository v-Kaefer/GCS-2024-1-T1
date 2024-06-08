public class Adulto extends Visitante implements Atividades {
    public Adulto(String nome, int anoDeNascimento, int telefone) {
        super(nome, anoDeNascimento);
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
}