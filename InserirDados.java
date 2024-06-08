import java.util.HashSet;
import java.util.HashMap;
import java.util.Random;

/*
     * O sistema deve permitir que o operador registre a entrada de visitantes no parque.
     * O sistema deve ter um método que gere um nome aleatório para o visitante.
     * O sistema deve ter um método que gere um número, do ano de nascimento aleatório entre 0 e 120 para o visitante.
     * Caso a idade seja menor ou igual a 12 anos, o visitante deve ser criado como Child, utilizando a referencia de Visitante.java.
     * Caso a idade seja maior que 12 anos, o visitante deve ser criado como Parent, utilizando a referencia de Visitante.java.
     * O sistema deve ter um método que gere um número de telefone aleatório para o visitante.
     * O sistema deve ter um método que gere um número de ingresso aleatório para o visitante.
     */

public class InserirDados {

    private HashSet<Visitante> visitantes;
    private HashMap<String, Atracao> atracoes;
    
    public InserirDados() {
        visitantes = new HashSet<>();
        atracoes = new HashMap<>();
        inserirDadosAoParque();
    }

    public void inserirDadosAoParque() {
        // Cria alguns Visitantes Adultos
        for (int i = 0; i<5; i++) {
            Visitante visitante = new Visitante (gerarNomes(), gerarAnoDeNascimento());
        }

        // Cria algumas Atrações
        atracoes.put("Montanha Russa", new MontanhaRussa());
        atracoes.put("Roda Gigante", new RodaGigante());
        atracoes.put("Barco Viking", new BarcoViking());
        atracoes.put("Carro Choque", new CarroChoque());
        atracoes.put("Trem Fantasma", new TremFantasma());
        atracoes.put("Boca do Palhaço", new BocaDoPalhaco());
    }


    private String gerarNomes() {
        String[] names = {"João Vitor", "Maria Antonia", "Pedro Almeida", "Ana Lúcia", "Lucas Almeida", "Fernando Oliveira"};
        return names[new Random().nextInt(names.length)];
    }

    private int gerarAnoDeNascimento() {
        return new Random().nextInt(120);
    }

    public static void main(String[] args) {
        InserirDados inserirDados = new InserirDados();
        // debugger
    }

    public class MontanhaRussa extends Atracao implements Atividades {
        public MontanhaRussa() {
            super("Montanha Russa");
        }

        public void visitar(String data, Ingresso ingresso, Visitante visitante) {
            Visita visita = new Visita(ingresso, this, visitante, data);
            visitas.add(visita);
            System.out.println("Visita registrada em Montanha Russa no dia " + data);
        }
    }


    public class RodaGigante extends Atracao implements Atividades {
        public RodaGigante() {
            super("Roda Gigante");
        }

        public void visitar(String data, Ingresso ingresso, Visitante visitante) {
            Visita visita = new Visita(ingresso, this, visitante, data);
            visitas.add(visita);
            System.out.println("Visita registrada em Roda Gigante no dia " + data);
        }
    }

    public class BarcoViking extends Atracao implements Atividades {
        public BarcoViking() {
            super("Barco Viking");
        }

        public void visitar(String data, Ingresso ingresso, Visitante visitante) {
            Visita visita = new Visita(ingresso, this, visitante, data);
            visitas.add(visita);
            System.out.println("Visita registrada em Barco Viking no dia " + data);
        }
    }

    public class CarroChoque extends Atracao implements Atividades {
        public CarroChoque() {
            super("Carro Choque");
        }

        public void visitar(String data, Ingresso ingresso, Visitante visitante) {
            Visita visita = new Visita(ingresso, this, visitante, data);
            visitas.add(visita);
            System.out.println("Visita registrada em Carro Choque no dia " + data);
        }
    }

    public class TiroAoAlvo extends Atracao implements Atividades {
        public TiroAoAlvo() {
            super("Tiro ao Alvo");
        }

        public void visitar(String data, Ingresso ingresso, Visitante visitante) {
            Visita visita = new Visita(ingresso, this, visitante, data);
            visitas.add(visita);
            System.out.println("Visita registrada em Trem Fantasma no dia " + data);
        }
    }

    public class TremFantasma extends Atracao implements Atividades {
        public TremFantasma() {
            super("Trem Fantasma");
        }

        public void visitar(String data, Ingresso ingresso, Visitante visitante) {
            Visita visita = new Visita(ingresso, this, visitante, data);
            visitas.add(visita);
            System.out.println("Visita registrada em Trem Fantasma no dia " + data);
        }
    }

    public class BocaDoPalhaco extends Atracao implements Atividades {
        public BocaDoPalhaco() {
            super("Boca do Palhaço");
        }

        public void visitar(String data, Ingresso ingresso, Visitante visitante) {
            Visita visita = new Visita(ingresso, this, visitante, data);
            visitas.add(visita);
            System.out.println("Visita registrada em Trem Fantasma no dia " + data);
        }
    }

}



