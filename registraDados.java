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

public class registraDados {

    public static void main(String[] args) {
        // Cria um visitante
        Visitante visitante = new Visitante("João Pedro", "999999999", Ingresso());
        // Adiciona o visitante na atração
        atracao.adicionarVisitante(visitante);
    }
    
    interface Registros {
        public boolean registraVisita(atributosVisitante visitante, Ingresso ingresso);
        private boolean isIngressoValido(Ingresso ingresso) {};
        //public boolean getDataVisita(Ingresso dataAtual); // Alterar para dia Global
    }

    public class montanhaRussa extends Atracao implements Registros {
    public montanhaRussa() {
        this.atracao = "Montanha Russa";
    }


    public boolean registraVisita(atributosVisitante visitante, Ingresso ingresso) {
        try {
            if (ingresso != null && isIngressoValido(ingresso)) { // ajustar array de visitas
                visitas.add(new Visita());
                ingresso.registraVisita(this);
                return true;
            } else {
                System.out.println("Visitante não possui ingresso válido.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao registrar visita.");
            return false;
        }
    }

}
    
    public class rodaGigante extends Atracao implements Registros {
        public rodaGigante() {
            this.atracao = "Roda Gigante";
        }

        public boolean registraVisita(atributosVisitante visitante, Ingresso ingresso) {
            try {
                if (ingresso != null && isIngressoValido(ingresso)) { // ajustar array de visitas
                    visitas.add(new Visita());
                    ingresso.registraVisita(this);
                    return true;
                } else {
                    System.out.println("Visitante não possui ingresso válido.");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Erro ao registrar visita.");
                return false;
            }
        }
    }

    public class barcoViking extends Atracao implements Registros {
        public barcoViking() {
            this.atracao = "Barco Viking";
        }

        public boolean registraVisita(atributosVisitante visitante, Ingresso ingresso) {
            try {
                if (ingresso != null && isIngressoValido(ingresso)) { // ajustar array de visitas
                    visitas.add(new Visita());
                    ingresso.registraVisita(this);
                    return true;
                } else {
                    System.out.println("Visitante não possui ingresso válido.");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Erro ao registrar visita.");
                return false;
            }
        }
    }

    public class carroChoque extends Atracao implements Registros {
        public carroChoque() {
            this.atracao = "Carro Choque";
        }

        public boolean registraVisita(atributosVisitante visitante, Ingresso ingresso) {
            try {
                if (ingresso != null && isIngressoValido(ingresso)) { // ajustar array de visitas
                    visitas.add(new Visita());
                    ingresso.registraVisita(this);
                    return true;
                } else {
                    System.out.println("Visitante não possui ingresso válido.");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Erro ao registrar visita.");
                return false;
            }
        }
    }

    public class tremFantasma extends Atracao implements Registros {
        public tremFantasma() {
            this.atracao = "Trem Fantasma";
        }

        public boolean registraVisita(atributosVisitante visitante, Ingresso ingresso) {
            try {
                if (ingresso != null && isIngressoValido(ingresso)) { // ajustar array de visitas
                    visitas.add(new Visita());
                    ingresso.registraVisita(this);
                    return true;
                } else {
                    System.out.println("Visitante não possui ingresso válido.");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Erro ao registrar visita.");
                return false;
            }
        }
    }

    public class tiroAoAlvo extends Atracao implements Registros {
        public tiroAoAlvo() {
            this.atracao = "Tiro ao Alvo";
        }

        public boolean registraVisita(atributosVisitante visitante, Ingresso ingresso) {
            try {
                if (ingresso != null && isIngressoValido(ingresso)) { // ajustar array de visitas
                    visitas.add(new Visita());
                    ingresso.registraVisita(this);
                    return true;
                } else {
                    System.out.println("Visitante não possui ingresso válido.");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Erro ao registrar visita.");
                return false;
            }
        }
    }

    public class bocaDoPalhaco extends Atracao implements Registros {
        public bocaDoPalhaco() {
            this.atracao = "Boca do Palhaço";
        }

        public boolean registraVisita(atributosVisitante visitante, Ingresso ingresso) {
            try {
                if (ingresso != null && isIngressoValido(ingresso)) { // ajustar array de visitas
                    visitas.add(new Visita());
                    ingresso.registraVisita(this);
                    return true;
                } else {
                    System.out.println("Visitante não possui ingresso válido.");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Erro ao registrar visita.");
                return false;
            }
        }
    }

}



