import java.util.ArrayList;

public class Ingresso {

    /* Cada ingresso tem um número identificador sequencial daquele dia (ex. “03/04/2024 seq 001”, “03/04/2024 seq 002” etc)
    * e deve estar associado ao registro de um visitante (seja adulto ou criança).
    */

    private static int controleIngresso = 1;
    private final int ingresso;
    private int valor;
    private atributosVisitante visitante;
    private final String identificador;

    /* Considerar implementação de enum para validade do ingresso ou manter comparação de datas.
    enum validadeIngresso {
        INVALIDO, VALIDO
    }
    */

    public Ingresso(atributosVisitante visitante, String data, int anoDeNascimento) {
        this.visitante = visitante;
        this.ingresso = incrementaIngresso(controleIngresso); // Usa a funcao incrementaIngresso(), atribuind valor a ingresso
        this.identificador = subMenu.getData() + " - Ingresso: " + String.format("%03d", ingresso) + " - Valor: " + getIngressoValor(anoDeNascimento);
        this.valor = getIngressoValor(anoDeNascimento); // Por que eu adicionei isso?
    }

    private Integer incrementaIngresso(int controleIngresso) {
        if (controleIngresso < 500) {
            final int ingresso = controleIngresso;
            controleIngresso++;
            return ingresso;
        } else if (controleIngresso == 500){
            System.out.println("Erro: Limite de Ingressos diários atingido.");
        }
        // Retorna null. Ajustar?
        return null; 
    }

    public boolean isVisitanteMenorDeIdade(int anoDeNascimento) {
        String dataAtual = subMenu.getData();
        //Tratamento de data
        int anoAtual = Integer.parseInt(dataAtual.split("/")[2]);
        int idade = anoAtual - anoDeNascimento;
        if (idade <= 12) {
            return true;
        } else {
            return false;
        }
    }

    private int getIngressoValor(int anoDeNascimento) {
        try {
            if (isVisitanteMenorDeIdade(anoDeNascimento) == false) {
                // ArrayList com informações duplicadas. Corrigir p/ somente retono do valor, adicionado direto em ingressosDoDia.
                return 100;
            } else if (isVisitanteMenorDeIdade(anoDeNascimento) == true) {
                return 80;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            // Para evitar erros, retorna null. Necessita ser Integer.
            return null;
        }
    };

    // Verifica se o ingresso é válido e se o visistante pode visitar uma atracao.
    public static boolean isIngressoValido(int ingresso) {
        for (Ingresso i : ingressosDoDia) {
            if (i.getIngresso() == ingresso && i.getIngressoData().equals(subMenu.getData())) {
                return true;
            }
        }
        { return false; }
    }

    public String getIngressoData() {// Pega a data do ingresso
        return identificador.split("-")[0].trim();
    }

    // ArrayList para controle de ingressos do dia
    public static ArrayList<Ingresso> ingressosDoDia = new ArrayList<>();
    public static ArrayList<Ingresso> getAllIngressos() {
        ArrayList<Ingresso> allIngressos = new ArrayList<>();
        for (Ingresso ingresso : ingressosDoDia) {
            allIngressos.add(ingresso);
        }
        return allIngressos;
    }

    public static void addIngresso(Ingresso ingresso) {
        ingressosDoDia.add(ingresso);
    }

    public static ArrayList<Ingresso> getIngressosDoDia() {// Pega os ingressos do dia
        return ingressosDoDia;
    }

    public int getIngresso() {// ajustar p/ necessidade
        return ingresso;
    }

    public Integer getNextIngresso() {
        try {
            incrementaIngresso(controleIngresso);
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
        return ingresso;
    }

    public String getVisitante() {
        return visitante.getNome();
    }

    private int getIdentificador(Ingresso ingresso) {
        String i = identificador.split("-")[-2].trim();
        int identificador = Integer.parseInt(i);
        return identificador;
    }

    public final int encerraDia(int controleIngresso) {
        // reseta ingressos
        // reseta arrayControleIngresso
        // reseta vendasIngressoDia
        return controleIngresso;
    }

    // encerraMes
    // encerraAno

}

