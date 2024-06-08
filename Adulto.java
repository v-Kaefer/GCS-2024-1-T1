public class Adulto extends Visitante implements Atividades {
    public Adulto(String nome, int anoDeNascimento, int telefone) {
        super(nome, anoDeNascimento);
        this.telefone = telefone;
    }

    @Override
    public void visitar(String data, Ingresso ingresso, Visitante visitante) {
        System.out.println(nome + " está visitando.");
    }
    
    public Ingresso setIngresso() {
        this.ingresso = Ingresso.setIngresso(this);
        return this.ingresso;
    }
}