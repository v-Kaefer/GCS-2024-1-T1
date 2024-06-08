import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    private HashSet<RegistroGeral> registroGeral = new HashSet<>();
    private HashSet<RegistroGeral> resultadosDia = new HashSet<>();
    private HashSet<RegistroGeral> RegistroGeral = new HashSet<>();


    // public RegistroGeral(String data, Visitante visitante, Ingresso ingresso, Visitas visitas, Faturamento faturamento) {
    public final HashSet<RegistroGeral> encerraDia() {
        System.out.println("Registrando resultados do dia " + getData());
        // Ajustar
        RegistroGeral registro = new RegistroGeral(getData(), null, null, null, null); // Adjust as needed
        resultadosDia.add(registro);
        incrementaData();
        return resultadosDia;
    }
    
    private final HashSet<RegistroGeral> faturamentoDia() {
        System.out.println("Consultando faturamento do dia " + getData());
        // Ajustar
        RegistroGeral registro = new RegistroGeral(getData());
        registrosDia.add(registro);
        incrementaData();
        return registrosDia;
    }

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

