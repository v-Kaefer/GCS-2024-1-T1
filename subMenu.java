import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    private HashSet<RegistroGeral> resultadosDia = new HashSet<>();

    // public RegistroGeral(String data, Visitante visitante, Ingresso ingresso, Visitas visitas, Faturamento faturamento) {
    public final HashSet<RegistroGeral> encerraDia() {
        System.out.println("Registrando resultados do dia " + getData());
        // Ajustar. Ainda estou perdido aqui. O registro em Hash é estranho...
        RegistroGeral registro = new RegistroGeral(getData());
        resultadosDia.add(registro);
        incrementaData();
        return resultadosDia;
    }
    
    private final HashSet<RegistroGeral> faturamentoDia() {
        System.out.println("Consultando faturamento do dia " + getData());
        RegistroGeral registro = new RegistroGeral(getData());
        resultadosDia.add(registro);
        incrementaData();
        return resultadosDia;
    }

    private void incrementaData() { 
        // Incrementa a data atual e finaliza o dia
        LocalDateTime incrementaData = LocalDateTime.parse(dataAtual, DateTimeFormatter.ofPattern("dd/MM/yyyy")).plusDays(1);
        dataAtual = incrementaData.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Ingresso.encerraDia(); // Reseta controleIngresso ao finalizar o dia
    }

    // Encerra dia e incrementa a data
    public void encerrarDia() {
        System.out.println("Encerrando dia " + getData());
        app.encerrarDia(getData());
        incrementaData();
    }

    public void consultarFaturamento() {
        double totalFaturamento = 0;
        for (RegistroGeral registro : app.getRegistroGeral()) {
            totalFaturamento += registro.getFaturamento();
        }
        System.out.println("Faturamento total: " + totalFaturamento);
    }
}

