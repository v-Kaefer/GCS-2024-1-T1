import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//O parque de diversões precisa armazenar dados de suas atrações e de seus visitantes.
//As atrações incluem, por exemplo;
// montanha-russa, roda-gigante, barco viking, carro-choque, trem-fantasma etc

public abstract class Atracao {
    protected String atracao;
    protected List<Visita> visitas;
    protected HashMap<Atracao, List<Visita>> totalAtracaoVisitas;
    protected HashMap<Visitante, List<Visita>> totalVisitanteVisitas;
    public static HashMap<String, Atracao> atracoes = new HashMap<>();

    public Atracao(String atracao) {
        this.atracao = atracao;
        this.visitas = new ArrayList<>();
    }

    public String getNomeAtracao() {
        return atracao;
    }

    public void getTotalVisitasDoVisitante(Visitante visitante) {
        for (Visita visita : visitas) {
            System.out.println("Visitante: " + visita.getVisitante().getNome() + " visitou a atração " + atracao + " no dia " + visita.getDataVisita());
        }
    }

    public void getTotalVisitasDaAtracao(Atracao atracao) {
        for (Visita totalAtracaoVisitas : visitas) {
            System.out.println("A atração " + atracao + " foi visitada por " + visita.getVisitante().getNome() + " no dia " + visita.getDataVisita());
        }
    }

    public void visitar(String data, Ingresso ingresso, Visitante visitante) {
        Visita visita = new Visita(ingresso, this, visitante, data);
        visitas.add(visita);
        System.out.println("Visita registrada em " + atracao + " no dia " + data);
    }

    public class Visita {
        private String dataVisita;
        private Atracao atracao;
        private Visitante visitante;
        private Ingresso ingresso;

        public Visita(Ingresso ingresso, Atracao atracao, Visitante visitante, String dataVisita) {
            this.dataVisita = dataVisita;
            this.atracao = atracao;
            this.visitante = visitante;
            this.ingresso = ingresso;
        }

        public String getDataVisita() {
            return dataVisita;
        }

        public Atracao getAtracao() {
            return atracao;
        }

        public Visitante getVisitante() {
            return visitante;
        }

        public Ingresso getIngresso() {
            return ingresso;
        }
    }    
}
