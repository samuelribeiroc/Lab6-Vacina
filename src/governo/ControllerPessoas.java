package governo;

import status.HabilitadaPrimeiraDose;
import status.NaoHabilitada;

import java.util.ArrayList;
import java.util.List;

public class ControllerPessoas {

    public List<Pessoa> pessoasCadastradas;

    public int diaAtual;

    public int idadeMinima;

    public List<String> comorbidadesCadastradas;

    public List<String> profissoesCadastradas;

    public ControllerPessoas(int idadeMinima) {
        this.pessoasCadastradas = new ArrayList<>();
        this.diaAtual = 0;
        this.idadeMinima = idadeMinima;
        this.comorbidadesCadastradas = new ArrayList<>();
        this.profissoesCadastradas = new ArrayList<>();
    }

    public void cadastraPessoas(String nome, String cpf, String endereco, String cartaoSUS, String email,
                                String profissao, int idade, String comorbidades) {
        Pessoa pessoa = new Pessoa(nome, cpf, endereco, cartaoSUS, email, profissao, idade, this.diaAtual);
        String[] comorbs = comorbidades.split(" ");
        Boolean comorbids = false;
        for (String com : comorbs) {
            if (this.comorbidadesCadastradas.contains(com)) {
                comorbids = true;
            }
            pessoa.getComorbidades().add(com);
        }
        if (pessoa.getIdade() >= this.idadeMinima || this.profissoesCadastradas.contains(pessoa.getProfissao()) ||
        comorbids) {
            pessoa.setStatus(new HabilitadaPrimeiraDose());
        } else {
            pessoa.setStatus(new NaoHabilitada());
        }
        this.pessoasCadastradas.add(pessoa);
    }

    public void mudaDia() {
        this.diaAtual++;
        for (Pessoa pessoa : this.pessoasCadastradas) {
            pessoa.mudaDia();
            if (pessoa.getStatus().toString().equals("Tomou a primeira dose.") &&
                    (pessoa.getDiaAtual() - pessoa.getDiaPrimeiraDose()) == 20) {
                pessoa.atualizaStatus();
            }
        }
    }

    public void addComorbidades(String comorbidade) {
        this.comorbidadesCadastradas.add(comorbidade);
        for (Pessoa pessoa : this.pessoasCadastradas) {
            if (pessoa.getComorbidades().contains(comorbidade) &&
            pessoa.getStatus().toString().equals("Nao habilitada para vacina.")) {
                pessoa.atualizaStatus();
            }
        }
    }

    public void diminuiIdadeMinima(int idade) {
        this.idadeMinima =- idade;
        for (Pessoa pessoa : this.pessoasCadastradas) {
            if (pessoa.getIdade() >= idade &&
                    pessoa.getStatus().toString().equals("Nao habilitada para vacina.")) {
                pessoa.atualizaStatus();
            }
        }
    }

    public void cadastrarProfissao(String profissao) {
        this.profissoesCadastradas.add(profissao);
        for (Pessoa pessoa : this.pessoasCadastradas) {
            if (pessoa.getProfissao().equals(profissao) &&
                    pessoa.getStatus().toString().equals("Nao habilitada para vacina.")) {
                pessoa.atualizaStatus();
            }
        }
    }

    public void vacinarPessoas() {
        for (Pessoa pessoa : this.pessoasCadastradas) {
            if (pessoa.getStatus().toString().equals("Habilitada para tomar a primeira dose.") ||
                    pessoa.getStatus().toString().equals("Habilitada para tomar a segunda dose.")) {
                pessoa.atualizaStatus();
            }
        }
    }

    public List<Pessoa> getPessoasCadastradas() {
        return pessoasCadastradas;
    }
}
