import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class subMenu {
    private static String dataStart = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now());
    private static String dataAtual = dataStart;
    private App app;

    public subMenu(App app) {
        this.app = app;
    }

    public static String getData() {
        return dataAtual;
    }

    // Funções "Globais"
    // Para controle geral do parque
    /*
     * 6) O sistema deverá permitir ao operador consultar o faturamento de um determinado mês/ano, somando os valores dos ingressos dos respectivos dias.
     * 7) O sistema deverá permitir ao operador consultar, para uma determinada data, todas as atrações do parque e a quantidade de visitantes que utilizou cada uma delas, ordenadas da mais visitada à menos visitada.
     * 8) Duas funcionalidades a mais, à escolha do grupo.
    */

    private HashSet<RegistroGeral> registroGeral = new HashSet<>();


    public final ArrayList<RegistrosDia> encerraDia() {
        ArrayList<RegistrosDia> resultadosDia = new ArrayList<>();
        System.out.println("Registrando resultados do dia " + getData());
        resultadosDia.add(new RegistrosDia(getData()));

        incrementaData();
        return resultadosDia;
    }
    
    private final ArrayList<registrosDia> faturamentoDia() {
        ArrayList<registrosDia> registrosDia = new ArrayList<>();
        System.out.println("Consultando faturamento do dia " + getData());
        registrosDia.add(getData());

        incrementaData();
        return faturamento;
    }

    // encerraDiaResultados()
    // ArraysLists : diaArray, atracoesArray, visitantesArray, ingressosArray
    // isIngressoValido()


    //private static String dataControle = dataAtual;



    private void incrementaData() { 
        // Incrementa a data atual e finaliza o dia
        LocalDateTime incrementaData = LocalDateTime.parse(dataAtual, DateTimeFormatter.ofPattern("dd/MM/yyyy")).plusDays(1);
        dataAtual = incrementaData.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Ingresso.encerraDia(); // Reseta controleIngresso ao finalizar o dia
    }

    // Encerra dia

    public void encerrarDia() {
        System.out.println("Encerrando dia " + getData());
        app.encerrarDia(getData());
        incrementaData();
    }

    public void consultarFaturamento() {
        System.out.println("Faturamento total: " + app.getRegistroGeral().stream().mapToDouble(r -> r.getFaturamento().getValor()).sum());
    }
}

