import java.util.ArrayList;
import java.util.List;

//O parque de diversões precisa armazenar dados de suas atrações e de seus visitantes.
//As atrações incluem, por exemplo;
// montanha-russa, roda-gigante, barco viking, carro-choque, trem-fantasma etc

public abstract class Atracao {
    protected String atracao;
    protected List<Visita> visitas;
    protected ArrayList<Atracao> atracoes;
    private ArrayList<Visitante> visitantes;

    public class Visita {
        private String dataVisita;
        private Atracao atracao;
        private atributosVisitante visitante;
        private Ingresso ingresso;

        public Visita(Ingresso ingresso, Atracao atracao, atributosVisitante visitante, String dataVisita) {
            this.dataVisita = dataVisita;
            this.atracao = atracao;
            this.visitante = visitante;
            this.ingresso = ingresso;
            
        }
    }

    public Atracao() {
        atracoes = new ArrayList<>();
        visitas = new ArrayList<>();
    }


    interface Registros {
        public boolean registraVisita(atributosVisitante visitante, Ingresso ingresso);
        public boolean getDataVisita(Ingresso dataAtual); // Alterar para dia Global
    }

    private boolean isValido(Visitante visitante) {
        for (Ingresso ingresso : Ingresso.ingressos) {
            if (visitante.ingresso.getVisitante() == visitante && ingresso != null) {
                return true;
            }
        }
        return false;
    }

    public String getNomeAtracao() {
        return atracao;
    }


    /*
    public boolean registraVisita(herancaVisitante visitante, Ingresso ingresso) {
        if (ingresso != null && ingresso.getVisitante() == visitante.getNome()) {
            return true;
        } else if (ingresso != null && ingresso.isValido()) {
            this.visitante.add(visitante);
            ingresso.registraVisita(this);
            return true;
        } else {
            System.out.println("Visitante não possui ingresso válido.");
            return false;
        }
    }
    */
}
