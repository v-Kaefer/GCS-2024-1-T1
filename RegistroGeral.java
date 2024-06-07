public class RegistroGeral {
    private String data;
    private Visitante visitante;
    private Ingresso ingresso;
    private Visitas visitas;
    private Faturamento faturamento;

    public RegistroGeral(String data, Visitante visitante, Ingresso ingresso, Visitas visitas, Faturamento faturamento) {
        this.data = data;
        this.visitante = visitante;
        this.ingresso = ingresso;
        this.visitas = visitas;
        this.faturamento = faturamento;
    }

    public String getData() {
        return data;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public Visitas getVisitas() {
        return visitas;
    }

    public Faturamento getFaturamento() {
        return faturamento;
    }
}