import java.util.ArrayList;

public class Visitante extends atributosVisitante {
    // As variáveis de Visitante são protegidas para que possam ser acessadas por classes filhas
    // Atributos de Visitante são extendidas de atributosVisitante

    //Alternativa melhor do que ArrayList, para novosVisitantes?
    protected static ArrayList<Visitante> novoVisitante = new ArrayList<Visitante>();

    public Visitante(String nome, int anoDeNascimento) {
        this.nome = nome;
        this.anoDeNascimento = anoDeNascimento;
        // this.telefone = telefone;
        //this.ingresso = ingresso;
        
    }


}