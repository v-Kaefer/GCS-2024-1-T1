import java.util.HashSet;

public class RegistroGeral {
    private String data;
    private HashSet<Visitante> visitantes;
    private HashSet<Ingresso> ingressos;
    private HashSet<Atracao> atracoes;

    public RegistroGeral(String data) {
        this.data = data;
        this.visitantes = new HashSet<>();
        this.ingressos = new HashSet<>();
        this.atracoes = new HashSet<>();
    }
    public void addVisitante(Visitante visitante) {
        visitantes.add(visitante);
    }

    public void addIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    public void addAtracao(Atracao atracao) {
        atracoes.add(atracao);
    }

    public String getData() {
        return data;
    }

    public HashSet<Visitante> getVisitantes() {
        return visitantes;
    }

    public HashSet<Ingresso> getIngressos() {
        return ingressos;
    }

    public HashSet<Atracao> getAtracoes() {
        return atracoes;
    }
    public int getFaturamento() {
        int faturamento = 0;
        for (Ingresso ingresso : ingressos) {
            faturamento += ingresso.getPreco();
        }
        return faturamento;
    }

}