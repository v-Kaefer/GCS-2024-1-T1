import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class App {
    private HashSet<RegistroGeral> registroGeral;
    private HashSet<String> datas;
    //private HashSet<RegistroGeral> faturamentoDia;
    private HashMap<String, RegistroGeral> registros;
    private ArrayList<Atracao> atracoes;
    //private HashSet<RegistroGeral> registroFinal;


    public App() {
        registroGeral = new HashSet<>();
        datas = new HashSet<>();
        registros = new HashMap<>();
        atracoes = new ArrayList<>();
    }

    public Ingresso emitirIngresso(Visitante visitante) {
        if (!Visitante.existemVisitantes()) {
            return null;
        }
        try {
            Ingresso ingresso = new Ingresso(visitante, subMenu.getData());
            Ingresso.addIngresso(ingresso, visitante);
            return ingresso;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void addRegistro(String data, Visitante visitante, Ingresso ingresso, Atracao atracao) {
        RegistroGeral diaRegistro = registros.get(data);
        if (diaRegistro == null) {
            diaRegistro = new RegistroGeral(data);
            registros.put(data, diaRegistro);
        }
        diaRegistro.addVisitante(visitante);
        diaRegistro.addIngresso(ingresso);
        diaRegistro.addAtracao(atracao);
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
        RegistroGeral registro = registros.get(data);
        if (registro != null) {
            total = registro.getFaturamento();
        }
        return total;
    }
    
    public int getFaturamentoMes(String mes, String ano) {
        int total = 0;
        for (RegistroGeral registro : registroGeral) {
            String[] dataParts = registro.getData().split("/");
            if (dataParts[1].equals(mes) && dataParts[2].equals(ano)) {
                total += registro.getFaturamento();
            }
        }
        return total;
    }
    
    public int getFaturamentoAno(String ano) {
        int total = 0;
        for (RegistroGeral registro : registroGeral) {
            if (registro.getData().endsWith(ano)) {
                total += registro.getFaturamento();
            }
        }
        return total;
    }

    public void encerrarDia(String data) {
        int totalFaturamento = 0;
        for (RegistroGeral registro : registroGeral) {
            if (registro.getData().equals(data)) {
                totalFaturamento += registro.getFaturamento();
            }
        }
        System.out.println("Faturamento do dia " + data + ": " + totalFaturamento);
    }

    public HashSet<RegistroGeral> getRegistroGeral() {
        return registroGeral;
    }

    public static void main(String[] args) {
        App app = new App();
        subMenu submenu = new subMenu(app);
        InserirDados inserirDados = new InserirDados();
        inserirDados.inserirDadosAoParque();
    }

}