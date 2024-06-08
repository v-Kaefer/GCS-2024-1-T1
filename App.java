import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App {
    private HashSet<RegistroGeral> registroGeral;
    private HashSet<String> datas;
    private HashSet<RegistroGeral> faturamentoDia;
    private HashMap<String, HashSet<RegistroGeral>> registros;
    private ArrayList<Atracao> atracoes;
    private HashSet<RegistroGeral> registroFinal;


    public App() {
        registroGeral = new HashSet<>();
        datas = new HashSet<>();
        registros = new HashMap<>();
        atracoes = new ArrayList<>();
        InserirDados.inserirDadosAoParque();
    }

    

    public Ingresso emitirIngresso(Visitante visitante) {
        if (!Visitante.existemVisitantes()) {
            return null;
        }
        try {
            Ingresso ingresso = new Ingresso(visitante, subMenu.getData());
            return ingresso;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void addRegistro(String data, Visitante visitante, Ingresso ingresso, Atracao atracao) {
        RegistroGeral diaRegistro = registros.getOrDefault(data, new RegistroGeral(data));
        diaRegistro.addVisitante(visitante);
        diaRegistro.addIngresso(ingresso);
        diaRegistro.addAtracao(atracao);
        // Adiciona o registro do dia, com data, ao HashMap
        registros.put(data, diaRegistro);
        // Add ao RegistroGeral
        registroGeral.add(diaRegistro);
    }

    public HashSet<RegistroGeral> getRegistro(String data) {
        HashSet<RegistroGeral> result = new HashSet<>();
        RegistroGeral registro = registros.get(data);
        if (registro != null) {
            result.add(registro);
        }
        return result;
    }

    public HashSet<String> getDatas() {
        return datas;
    }

    public int getFaturamentoDia(String data) {
        int total = 0;
        for (RegistroGeral registro : registroGeral) {
            if (registro.getData().equals(data)) {
                total += registro.getIngresso().getValor();
            }
        }
        return total;
    }
    
    public int getFaturamentoMes(String mes, String ano) {
        int total = 0;
        for (RegistroGeral registro : registroGeral) {
            if (registro.getData().contains(mes + "/" + ano)) {
                total += registro.getIngresso().getValor();
            }
        }
        return total;
    }
    
    public int getFaturamentoAno(String ano) {
        int total = 0;
        for (RegistroGeral registro : registroGeral) {
            if (registro.getData().contains(ano)) {
                total += registro.getIngresso().getValor();
            }
        }
        return total;
    }

    public void encerrarDia(String data) {
        int totalFaturamento = 0;
        for (RegistroGeral registro : registroGeral) {
            if (registro.getData().equals(data)) {
                totalFaturamento += registro.getFaturamento().getPreco();
            }
        }
        System.out.println("Faturamento do dia " + data + ": " + totalFaturamento);
    }

    public static void main(String[] args) {
        App app = new App();
        subMenu submenu = new subMenu(app);
        InserirDados inserirDados = new InserirDados();
        inserirDados.inserirDadosAoParque();
    }

}