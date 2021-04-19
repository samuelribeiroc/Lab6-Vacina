import governo.ControllerPessoas;
import governo.Pessoa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao;

        int idadeMinima;
        String comorbidadesGoverno, profissoesGoverno;

        String nome, cpf, endereco, cartaoSUS, email, profissao, comorbidade;
        int idade;

        boolean encerrarSistema = false;

        System.out.println("Ola, bem-vinde ao sistema de cadastro de vacinacao!");

        do {
            System.out.println("Para iniciar o sistema, por favor, informe a idade minima para a campanha de vacinacao:");
            idadeMinima = sc.nextInt();
            ControllerPessoas controllerPessoas = new ControllerPessoas(idadeMinima);
            System.out.println("Por favor, informe o que deseja\n" +
                    "(1) Cadastrar pessoa ao sistema\n" +
                    "(2) Cadastrar comorbidade a fila de prioridade\n" +
                    "(3) Cadastrar profissao a fila de prioridade\n" +
                    "(4) Vacinar pessoas\n" +
                    "(5) Alterar dados do cadastro\n" +
                    "(6) Mudar o dia\n" +
                    "(7) Sair do sistema");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Informe o nome completo: ");
                    nome = sc.nextLine();
                    System.out.print("Informe o cpf: ");
                    cpf = sc.nextLine();
                    System.out.print("Informe o endereco: ");
                    endereco = sc.nextLine();
                    System.out.print("Informe o numero do cartao do sus: ");
                    cartaoSUS = sc.nextLine();
                    System.out.print("Informe o email: ");
                    email = sc.nextLine();
                    System.out.print("Informe a profissao: ");
                    profissao = sc.nextLine();
                    System.out.print("Informe a idade: ");
                    idade = sc.nextInt();
                    System.out.println("A pessoa tem comorbidades?");
                    comorbidade = sc.nextLine();
                    if (comorbidade.equals("Sim")) {
                        System.out.println("Quais?");
                        comorbidade = sc.nextLine();
                    } else if (comorbidade.equals("Nao")) {
                        comorbidade = "";
                    }
                    controllerPessoas.cadastraPessoas(nome, cpf, endereco, cartaoSUS, email, profissao,
                            idade, comorbidade);
                    System.out.println("Pessoa cadastrada!");
                    break;
                case 2:
                    System.out.print("Informe a comorbidade: ");
                    comorbidadesGoverno = sc.nextLine();
                    controllerPessoas.addComorbidades(comorbidadesGoverno);
                    System.out.println("Comorbidade cadastrada!");
                    break;
                case 3:
                    System.out.print("Informe a profissao: ");
                    profissoesGoverno = sc.nextLine();
                    controllerPessoas.cadastrarProfissao(profissoesGoverno);
                    System.out.println("Profissao cadastrada!");
                    break;
                case 4:
                    controllerPessoas.vacinarPessoas();
                    System.out.println("Pessoas vacinadas!");
                    break;
                case 5:
                    System.out.println("Quais dados deseja alterar?\n" +
                            "(1) Nome\n" +
                            "(2) CPF\n" +
                            "(3) Endereco\n" +
                            "(4) Numero do cartao do SUS\n" +
                            "(5) Email\n" +
                            "(6) Profissao\n" +
                            "(7) Comorbidade\n");
                    opcao = sc.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.print("Informe o nome completo: ");
                            nome = sc.nextLine();
                            for (Pessoa pessoa : controllerPessoas.getPessoasCadastradas()) {
                                if (pessoa.getNome().equals(nome)) {
                                    System.out.print("Digite o novo nome: ");
                                    nome = sc.nextLine();
                                    pessoa.setNome(nome);
                                }
                            }
                            break;
                        case 2:
                            System.out.print("Informe o CPF: ");
                            cpf = sc.nextLine();
                            for (Pessoa pessoa : controllerPessoas.getPessoasCadastradas()) {
                                if (pessoa.getNome().equals(cpf)) {
                                    System.out.print("Digite o novo CPF: ");
                                    cpf = sc.nextLine();
                                    pessoa.setCpf(cpf);
                                }
                            }
                            break;
                        case 3:
                            System.out.print("Informe o endereco: ");
                            endereco = sc.nextLine();
                            for (Pessoa pessoa : controllerPessoas.getPessoasCadastradas()) {
                                if (pessoa.getNome().equals(endereco)) {
                                    System.out.print("Digite o novo endereco: ");
                                    endereco = sc.nextLine();
                                    pessoa.setEndereco(endereco);
                                }
                            }
                            break;
                        case 4:
                            System.out.print("Informe o numero do cartao do SUS: ");
                            cartaoSUS = sc.nextLine();
                            for (Pessoa pessoa : controllerPessoas.getPessoasCadastradas()) {
                                if (pessoa.getNome().equals(cartaoSUS)) {
                                    System.out.print("Digite o novo numero: ");
                                    cartaoSUS = sc.nextLine();
                                    pessoa.setCartaoSUS(cartaoSUS);
                                }
                            }
                            break;
                        case 5:
                            System.out.print("Informe o email: ");
                            email = sc.nextLine();
                            for (Pessoa pessoa : controllerPessoas.getPessoasCadastradas()) {
                                if (pessoa.getNome().equals(email)) {
                                    System.out.print("Digite o novo nome: ");
                                    email = sc.nextLine();
                                    pessoa.setEmail(email);
                                }
                            }
                            break;
                        case 6:
                            System.out.print("Informe a profissao: ");
                            profissao = sc.nextLine();
                            for (Pessoa pessoa : controllerPessoas.getPessoasCadastradas()) {
                                if (pessoa.getNome().equals(profissao)) {
                                    System.out.print("Digite a nova profissao: ");
                                    profissao = sc.nextLine();
                                    pessoa.setProfissao(profissao);
                                }
                            }
                            break;
                        case 7:
                            System.out.print("Informe a comorbidade: ");
                            comorbidade = sc.nextLine();
                            for (Pessoa pessoa : controllerPessoas.getPessoasCadastradas()) {
                                if (pessoa.getNome().equals(comorbidade)) {
                                    System.out.print("Digite as novas comorbidades: ");
                                    comorbidade = sc.nextLine();
                                    pessoa.setComorbidades(comorbidade);
                                }
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + opcao);
                    }
                    break;
                case 6:
                    controllerPessoas.mudaDia();
                    break;
                case 7:
                    encerrarSistema = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + opcao);
            }
        } while (!encerrarSistema);
    }
}
