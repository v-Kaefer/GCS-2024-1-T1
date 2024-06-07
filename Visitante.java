import java.util.HashSet;
import java.util.Scanner;

public class Visitante{
    protected String nome;
    protected int anoDeNascimento;
    protected int telefone;
    protected Ingresso ingresso = null;
    protected HashSet<Visitante> visitantes = new HashSet<Visitante>();
    // As variáveis de Visitante são protegidas para que possam ser acessadas por classes filhas
    Scanner sc = new Scanner(System.in);
    

    public Visitante(String nome, int anoDeNascimento) {
        this.nome = nome;
        this.anoDeNascimento = anoDeNascimento;
    }

    public void adicionaNovoVisitante(Visitante visitante) {
        try {
            if (!verificaExistencia(visitante)) {
                if (!Ingresso.isVisitanteMenorDeIdade(visitante.getAnoDeNascimento())) {
                    // Add Adulto
                    Adulto adulto = new Adulto(visitante.getNome(), visitante.getAnoDeNascimento(), visitante.getTelefone());
                    visitantes.add(adulto);
                } else {
                    // Verifica se tem Adulto registrado
                    if (!existemAdultos()) {
                        System.out.println("Não há adultos registrados. Registre um adulto primeiro.");
                        return;
                    }

                    // Add Crianca com Adulto = responsavel
                    MenorDeIdade crianca = (MenorDeIdade) visitante;
                    Adulto responsavel = crianca.getResponsavel(visitante);
                    if (responsavel != null) {
                        Crianca novaCrianca = new Crianca(visitante.getNome(), visitante.getAnoDeNascimento(), responsavel, visitante.getTelefone());
                        visitantes.add(novaCrianca);
                    } else {
                        System.out.println("Não foi possível adicionar a criança.\nÉ necessário um adulto responsável.");
                    }
                }
            }
        } catch (Exception error) {
            System.out.println("Erro ao adicionar novo visitante: " + error);
        }
    }

    private boolean existemAdultos() {
        for (Visitante visitante : visitantes) {
            if (visitante instanceof Adulto) {
                return true;
            }
        }
        return false;
    }

    public boolean verificaExistencia(Visitante novoVisitante) {
        // Verificar
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

    public int getAnoDeNascimento() {
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