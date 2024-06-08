public class Crianca extends Visitante implements Atividades, MenorDeIdade {
    private Adulto responsavel;

    public Crianca(String nome, int anoDeNascimento, Adulto responsavel, int telefone) {
        super(nome, anoDeNascimento);
        this.responsavel = responsavel;
        this.telefone = telefone;
    }
    
    public void visitar(String data, Ingresso ingresso, Visitante visitante) {
        System.out.println(nome + " está visitando.");
    }

    public Ingresso setIngresso() {
        this.ingresso = Ingresso.setIngresso(this);
        return this.ingresso;
    }

    @Override
    public Adulto getResponsavel(Visitante visitante) {
        try {
            System.out.println("Insira aqui o nome do responsável (ou digite 'cancelar' para cancelar a inscrição): ");
            String nomeDoResponsavel = sc.nextLine();
            
            if (nomeDoResponsavel.equalsIgnoreCase("cancelar")) {
                System.out.println("Inscrição cancelada.");
                return null;
            }
            
            Adulto adulto = buscaAdulto(nomeDoResponsavel);
            if (adulto != null) {
                return adulto;
            } else {
                System.out.println("Não foi possível adicionar a criança. É necessário um adulto responsável.");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar obter o responsável: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Adulto buscaAdulto(String nomeDoResponsavel) {
        for (Visitante visitante : visitantes) {
            if (visitante instanceof Adulto && visitante.getNome().equals(nomeDoResponsavel)) {
                return (Adulto) visitante;
            }
        }
        return null;
    }

    @Override
    public int setTelefoneResponsavel(int telefone) {
        this.telefone = telefone;
        return telefone;
    }
}