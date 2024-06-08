import java.util.HashMap;
import java.util.HashSet;

//O parque de diversões precisa armazenar dados de suas atrações e de seus visitantes. As atrações incluem,
//por exemplo; montanha-russa, roda-gigante, barco viking, carro-choque, trem-fantasma etc.

public abstract class Atracao {
    protected String atracao;
    protected HashSet<Visita> visitas;
    protected static HashMap<Atracao, HashSet<Visita>> totalAtracaoVisitas = new HashMap<>();
    protected static HashMap<Visitante, HashSet<Visita>> totalVisitanteVisitas = new HashMap<>();
    public static HashMap<String, Atracao> atracoes = new HashMap<>();

    public Atracao(String atracao) {
        this.atracao = atracao;
        this.visitas = new HashSet<>();
        totalAtracaoVisitas.put(this, visitas);
    }

    public void registrarVisita(Visita visita) {
        visitas.add(visita);
        System.out.println("A atração " + atracao + " foi visitada por " + visita.getVisitante().getNome() + " no dia " + visita.getDataVisita());
    }

    public String getNomeAtracao() {
        return atracao;
    }

    public HashSet<Visita> getVisitas() {
        return visitas;
    }

    public void getTotalVisitasDoVisitante(Visitante visitante) {
        HashSet<Visita> visitasDoVisitante = totalVisitanteVisitas.get(visitante);
        if (visitasDoVisitante != null) {
            for (Visita visita : visitasDoVisitante) {
                System.out.println("Visitante: " + visita.getVisitante().getNome() + " visitou a atração " + visita.getAtracao().getNomeAtracao() + " no dia " + visita.getDataVisita());
            }
        } else {
            System.out.println("Nenhuma visita registrada para o visitante " + visitante.getNome());
        }
    }

    public void getTotalVisitasDaAtracao() {
        HashSet<Visita> visitasDaAtracao = totalAtracaoVisitas.get(this);
        if (visitasDaAtracao != null) {
            for (Visita visita : visitasDaAtracao) {
                System.out.println("A atração " + atracao + " foi visitada por " + visita.getVisitante().getNome() + " no dia " + visita.getDataVisita());
            }
        } else {
            System.out.println("Nenhuma visita registrada para a atração " + atracao);
        }
    }

    public void visitar(String data, Ingresso ingresso, Visitante visitante) {
        Visita visita = new Visita(ingresso, this, visitante, data);
        visitas.add(visita);
        totalAtracaoVisitas.put(this, visitas);
        //Adiciona a visita ao total de visitas do visitante
        totalVisitanteVisitas.computeIfAbsent(visitante, k -> new HashSet<>()).add(visita);
        System.out.println("Visita registrada em " + atracao + " no dia " + data);
    }

    public static class Visita {
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
