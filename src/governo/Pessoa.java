package governo;

import status.NaoHabilitada;
import status.Status;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private String nome;

    private String cpf;

    private String endereco;

    private String cartaoSUS;

    private String email;

    private String profissao;

    private List<String> comorbidades;

    private int idade;

    private Status status;

    public int diaPrimeiraDose;

    public int diaAtual;

    public Pessoa(String nome, String cpf, String endereco, String cartaoSUS, String email,
                  String profissao, int idade, int diaAtual) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cartaoSUS = cartaoSUS;
        this.email = email;
        this.profissao = profissao;
        this.comorbidades = new ArrayList<>();
        this.idade = idade;
        this.status = new NaoHabilitada();
        this.diaAtual = diaAtual;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getComorbidades() {
        return this.comorbidades;
    }

    public String getProfissao() {
        return this.profissao;
    }

    public int getIdade() {
        return this.idade;
    }

    public void atualizaStatus() {
        this.status.atualiza(this);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void mudaDia() {
        this.diaAtual++;
    }

    public void setDiaPrimeiraDose() {
        this.diaPrimeiraDose = this.diaAtual;
    }

    public Status getStatus() {
        return this.status;
    }

    public int getDiaPrimeiraDose() {
        return this.diaPrimeiraDose;
    }

    public int getDiaAtual() {
        return diaAtual;
    }

    public void setCartaoSUS(String cartaoSUS) {
        this.cartaoSUS = cartaoSUS;
    }

    public void setComorbidades(String comorbidades) {
        this.comorbidades.clear();
        String[] comorbs = comorbidades.split(" ");
        for (String com : comorbs) {
            this.comorbidades.add(com);
        }
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}
