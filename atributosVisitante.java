import java.util.ArrayList;
import java.util.Scanner;

public abstract class atributosVisitante {
    Scanner sc = new Scanner(System.in);
    protected String nome;
    protected int anoDeNascimento;
    protected String responsavel;
    protected int telefone;
    protected Integer ingresso = null;
    protected static ArrayList<Visitante> visitantes = new ArrayList<Visitante>();


    public void adicionaNovoVisitante(Visitante novoVisitante) {
        try {// Verifica se "visitantes" contém novoVisitante antes de adicionar
            if (verificaExistencia(novoVisitante) == false && Ingresso.isVisitanteMenorDeIdade(novoVisitante.anoDeNascimento) == false) {
                Adulto adulto = new Adulto(novoVisitante.nome, novoVisitante.anoDeNascimento, novoVisitante.telefone);
                visitantes.add(adulto);
            } else if (verificaExistencia(novoVisitante) == false && Ingresso.isVisitanteMenorDeIdade(novoVisitante.anoDeNascimento) == true) {
                Crianca crianca = new Crianca(novoVisitante.nome, novoVisitante.telefone, novoVisitante.anoDeNascimento);
                visitantes.add(crianca);
            }
        } catch (Exception error) {
            System.out.println("Erro ao adicionar visitante: " + error);
        }
    }

    public boolean verificaExistencia(Visitante novoVisitante) {
        // Verifica se o visitante já foi adicionado
        if (visitantes.contains(novoVisitante)) {
            return true;
        } else { return false; }
    }

    interface Atividades {
        public void visitar();
        public Integer setIngresso();
    }

    interface MenorDeIdade {
        public String getResponsavel(String responsavel);
        public String setResponsavel();
        public int setTelefoneResponsavel(String responsavel);
    }

    public class Adulto extends Visitante implements Atividades {
        // Sobre os visitantes adultos deseja-se armazenar nome, ano de nascimento e telefone.
        public Adulto(String nome, int anoDeNascimento, int telefone) {
            super(nome, anoDeNascimento);
            
        }

        public void visitar() {
            // Ajustar para método de registro de visita (Atracoes.java || subMenu.java?)
            System.out.println(nome + " está visitando.");
        }

        public Integer setIngresso() {
            // Ajustar (Implementar lista static de ingressos?)
            this.ingresso = Ingresso.getNextIngresso();
            return ingresso;
        }
    }

    // Para crianças com menos de 12 anos, deve-se armazenar
    // o nome, o ano de nascimento, o nome do responsável e seu telefone de contato. 
    public class Crianca extends Visitante implements Atividades, MenorDeIdade {
        public Crianca(String nome, int telefone, int anoDeNascimento) {
            super(nome, anoDeNascimento);
            this.responsavel = setResponsavel();
            this.telefone = setTelefoneResponsavel(responsavel);
        }

        public void visitar() {
            // Registra visita no parque
        }

        public Integer setIngresso() {
            this.ingresso = Ingresso.getNextIngresso();
            return ingresso;
        }

        public String getResponsavel(String responsavel) {
            // Ajustar para busca por nome
            System.out.println("Responsável: " + responsavel);
            return responsavel;
        }

        public String setResponsavel() {
            //Ajustar
            System.out.println("Menores de 12 anos devem estar acompanhados de um responsável.");
            try {
                
                System.out.println("Insira o nome do responsável: ");
                String responsavel = getResponsavel(sc.nextLine());
                // Ajustar
                
            } catch (Exception e) {
                System.out.println("Erro: " + e + "\nCancelando registro.");
            }
            return responsavel;
        }

        public int setTelefoneResponsavel(String responsavel) {
            // Ajustar
            System.out.println("Telefone do Responsável: " + telefoneResponsavel);
        }
    }

    /*
     * GETTERS && SETTERS
     */

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return anoDeNascimento;
    }

    public int getTelefone() {
        return telefone;
    }

    public Integer getIngresso() {
        return ingresso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.anoDeNascimento = idade;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
