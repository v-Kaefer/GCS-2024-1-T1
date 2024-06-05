

/*
 * O sistema deverá permitir que o operador localize um visitante por parte de seu nome ou pela identificação do ingresso. 
 * Ao localizar o visitante, o sistema deverá listar todas as atrações que o visitante foi.
 */

 public class LocalizaVisitante {
    private Visitante visitante;

    public void localizaVisitante(String nome, String ingresso) {
        if (visitante.getNome().contains(nome) || String.valueOf(visitante.getIngresso()).contains(ingresso)) {
            System.out.println("Visitante encontrado!");
            System.out.println("Nome: " + visitante.getNome());
            System.out.println("Ingresso: " + visitante.getIngresso());
            System.out.println("Atrações visitadas: ");
            for (Atracao atracoesVisitadas : visitante.getAtracoes()) {
                System.out.println(atracoesVisitadas.getNome());
            }
        } else {
            System.out.println("Visitante não encontrado!");
        }
    }
}

