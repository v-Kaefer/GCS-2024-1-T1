import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

public class App {
    private HashSet<data, HashMap<Visitante, Ingresso, Visitas>, Faturamento> registroGeral;
    private HashSet<String> datas;
    private HashMap<String, DiaRegistro> registros;

    public App() {
        registroGeral = new HashSet<>();
        datas = new HashSet<>();
        registros = new HashMap<>();
        atracoes = new ArrayList<>();
        initializeData();
    }

    private void initializeData() {
        atracoes.add(new montanhaRussa());
        atracoes.add(new rodaGigante());
        atracoes.add(new barcoViking());
        atracoes.add(new carroChoque());
        atracoes.add(new tremFantasma());
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

    public Map<String, Integer> getUsoDasAtracoes(String data) {
        Map<String, Integer> atracaoUso = new HashMap<>();
        for (RegistroGeral registro : registroGeral) {
            if (registro.getData().equals(data)) {
                String atracaoNome = registro.getVisitas().getAtracao().getNomeAtracao();
                atracaoUso.put(atracaoNome, atracaoUso.getOrDefault(atracaoNome, 0) + 1);
            }
        }
        return atracaoUso.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
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
        double totalFaturamento = 0.0;
        for (RegistroGeral registro : registroGeral) {
            if (registro.getData().equals(data)) {
                totalFaturamento += registro.getFaturamento().getValor();
            }
        }
        System.out.println("Faturamento do dia " + data + ": " + totalFaturamento);
    }

    public static void main(String[] args) {
        App app = new App();
        // Add code to interact with the app
    }

}