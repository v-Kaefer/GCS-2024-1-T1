import java.util.HashSet;
import java.util.HashMap;

public class App {
    private HashSet<data, HashMap<Visitante, Ingresso, Visitas>, Faturamento> registroGeral;
    private HashSet<String> datas;
    private HashMap<String, DiaRegistro> registros;

    public App() {
        datas = new HashSet<>();
        registros = new HashMap<>();
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



}