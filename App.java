import java.util.HashSet;
import java.util.HashMap;

public class App {
    private HashSet<data, HashMap<Visitante, Ingresso, Visitas>, Faturamento> registroGeral;
    private HashSet<String> datas;
    private HashMap<String, DiaRegistro> registros;

    public App() {
        registroGeral = new HashSet<>();
        initializeData();
    }

    private void initializeData() {
        // Initialize sample data for visitors, tickets, attractions, etc.
    }

    public Ingresso emitirIngresso(Visitante visitante) {
        if (VisitanteAtributos.existemVisitantes() == false) {return null;}
        Ingresso ingresso = new Ingresso(visitante, null, visitante.anoDeNascimento);
        return ingresso;
    }




    public void addRegistro(String data, Visitante visitante, Ingresso ingresso, Atracao atracao) {
        datas.add(data);
        DiaRegistro diaRegistro = registros.getOrDefault(data, new DiaRegistro());
        diaRegistro.addVisitante(visitante);
        diaRegistro.addIngresso(ingresso);
        diaRegistro.addAtracao(atracao);
        // Adiciona o registro do dia, com data, ao HashMap
        registros.put(data, diaRegistro);
    }

    public DiaRegistro getRegistro(String data) {
        return registros.get(data);
    }

    public HashSet<String> getDatas() {
        return datas;
    }



    public static void main (String args[]) {
        
    }


    // GETTERS

    public int getFaturamentoDia() {}
    public int getFaturamentoMes() {}
    public int getFaturamentoAno() {}

    public HashSet<Visitas.visitas> getUsoDasAtracoes() {}


    public void encerrarDia(String data) {
        double totalFaturamento = 0.0;
        for (RegistroGeral registro : registroGeral) {
            if (registro.getData().equals(data)) {
                totalFaturamento += registro.getFaturamento().getValor();
            }
        }
        System.out.println("Faturamento do dia " + data + ": " + totalFaturamento);
    }

}