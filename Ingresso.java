import java.util.HashMap;

public class Ingresso {
    private Visitante visitante;
    private final int ingresso;
    private int valor;
    private String validade;
    private final String identificador;
    private static int controleIngresso = 1;
    // HashSet para controle de ingressos do dia. Alterado para inclusão direta no HashMap em App.java ou subMenu.java
    public static HashMap<Ingresso, Visitante> ingressosDoDia = new HashMap<Ingresso, Visitante>();
    public HashMap<Ingresso, Integer> faturamentoDoDia = new HashMap<Ingresso, Integer>();
    


    public Ingresso(Visitante visitante, String data) {
        this.visitante = visitante;
        this.ingresso = incrementaIngresso(controleIngresso); // Usa a funcao incrementaIngresso(), atribuind valor a ingresso
        this.validade = subMenu.getData();
        this.identificador = data + " - Ingresso: " + String.format("%03d", ingresso) + " - Valor: " + getValor(visitante.anoDeNascimento);
        this.valor = getValor(visitante.anoDeNascimento); // Por que eu adicionei isso? getValor pode ser chamado direto do identificador.
    }

    public static void addIngresso(Ingresso ingresso, Visitante visitante) {
        ingressosDoDia.put(ingresso, visitante);
    }

    private Integer incrementaIngresso(int controleIngresso) {
        if (controleIngresso < 500) {
            final int ingresso = controleIngresso;
            controleIngresso++;
            return ingresso;
        } else {
            System.out.println("Erro: Limite de Ingressos diários atingido.");
            return null;
        }
    }

    public static boolean isVisitanteMenorDeIdade(int anoDeNascimento) {
        String dataAtual = subMenu.getData();
        //Tratamento de data. Pega o ano atual e subtrai pelo ano de nascimento do visitante.
        int anoAtual = Integer.parseInt(dataAtual.split("/")[2]);
        int idade = anoAtual - anoDeNascimento;
        // Operador ternário para verificar se o visitante é menor de idade. TRUE, FALSE.
        return idade <= 12 ? true : false;
    }

    // Verifica se o ingresso existe e se é válido.
    public static boolean isIngressoValido(Ingresso ingresso) {
        return ingressosDoDia.containsKey(ingresso) && ingresso.validade.equals(subMenu.getData());
    }


    // GETTERS

    public int getNumeroDoIngresso() {
        // Apenas o NÚMERO do ingresso
        return ingresso;
    }

    private String getIdentificador(Ingresso ingresso) {
        //String i = identificador.split("-")[-2].trim();
        //int identificador = Integer.parseInt(i);
        return identificador;
    }

    public Integer getNextIngresso() {
        try {
            incrementaIngresso(controleIngresso);
        } catch (Exception e) {
            e = new Exception("Erro: Limite de Ingressos diários atingido.");
            System.out.println("Erro: " + e);
        }
        return ingresso;
    }

    public int getValor(int anoDeNascimento) {
        // Operador ternário para verificar se o visitante é menor de idade e retornar valor. TRUE = 80, FALSE = 100.
        return isVisitanteMenorDeIdade(anoDeNascimento) ? 80 : 100;
    }

    public String getIngressoData() {
        // Pega a data do ingresso
        return identificador.split("-")[0].trim();
    }

    public String getVisitante() {
        return visitante.getNome();
    }


    public static void encerraDia() {
        // Limpa o HashMap de ingressos do dia e reseta o controle de ingressos.
        ingressosDoDia.clear();
        // Reseta a variável de controle de ingressos.
        controleIngresso = 1;
    }
}

