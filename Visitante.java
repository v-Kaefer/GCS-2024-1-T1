import java.util.HashSet;

public class Visitante{
    protected String nome;
    protected int anoDeNascimento;
    protected int telefone;
    protected Ingresso ingresso = null;
    // As variáveis de Visitante são protegidas para que possam ser acessadas por classes filhas

    protected static HashSet<Visitante> novoVisitante = new HashSet<Visitante>();
    protected HashSet<Visitante> visitantes = new HashSet<Visitante>();

    public Visitante(String nome, int anoDeNascimento) {
        this.nome = nome;
        this.anoDeNascimento = anoDeNascimento;
    }

    public void adicionaNovoVisitante(Visitante visitante) {
        try {
            if (!verificaExistencia(novoVisitante) && !Ingresso.isVisitanteMenorDeIdade(novoVisitante.getAnoDeNascimento())) {
                Adulto adulto = new Adulto (novoVisitante.getNome(), novoVisitante.getAnoDeNascimento(), novoVisitante.getTelefone());
                visitantes.add(adulto);
            } else if (!verificaExistencia(novoVisitante) && Ingresso.isVisitanteMenorDeIdade(novoVisitante.getAnoDeNascimento())) {
                Crianca crianca = new Crianca (novoVisitante.getNome(), novoVisitante.getAnoDeNascimento(), novoVisitante,getResponsavel(), novoVisitante.getTelefone());
                visitantes.add(crianca);
            }
        } catch (Exception error) {
            System.out.println("Erro ao adicionar novo visitante: " + error);
        }
    }

    public boolean verificaExistencia(HashSet<Visitante> novoVisitante) {
        return visitantes.contains(novoVisitante);
    }

    public boolean existemVisitantes() {
        return !visitantes.isEmpty();
    }


    // GETTERS && SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int anoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(int anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }
}