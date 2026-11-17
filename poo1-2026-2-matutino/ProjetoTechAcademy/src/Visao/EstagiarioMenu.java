package Visao;

import java.util.Scanner;

import Dominio.Estagiario;
import Servico.EstagiarioSrv;

public class EstagiarioMenu extends AbsMenu {

    private EstagiarioSrv servico;

    private Estagiario estagiario;

    public void executar() {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\n\n");
            opcao = this.exibirMenuEstagiario();
            switch (opcao) {
                case 1:
                    this.cadastrar();
                    break;
                case 2:
                    this.listarTodos();
                    break;
                case 3:
                    this.buscarPorCodigo();
                    break;
                case 4:
                    this.editar();
                    break;
                case 5:
                    this.excluir();
                    break;
                case 6:
                    System.out.println("Tchau!!!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private int exibirMenuEstagiario() {
        System.out.println("----- Menu [ESTAGIÁRIO] -----");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar Todos");
        System.out.println("3 - Buscar por Código");
        System.out.println("4 - Editar");
        System.out.println("5 - Excluir");
        System.out.println("6 - Sair");
        return this.lerInteiro("Selecione uma opção: ");
    }

    private void cadastrar() {
        System.out.println("\n\n");
        System.out.println("***** CADASTRAR ESTAGIÁRIO *****");
        System.out.print("Nome: ");
        String nome = this.scan.nextLine();
        System.out.print("CPF: ");
        String cpf = this.scan.nextLine();
        System.out.print("E-mail: ");
        String email = this.scan.nextLine();
        System.out.print("Telefone: ");
        String telefone = this.scan.nextLine();
        System.out.print("Endereço: ");
        String endereco = this.scan.nextLine();
        Double valorBolsa = this.lerDouble("Valor da Bolsa: ");
        int cargaHoraria = this.lerInteiro("Carga Horária Semanal: ");
        System.out.print("Área de Estágio: ");
        String areaEstagio = this.scan.nextLine();

        Estagiario novo = new Estagiario(0, nome, cpf, email, telefone, endereco,
            valorBolsa, cargaHoraria, areaEstagio);
        novo = this.servico.Incluir(novo);
        System.out.println("Estagiário cadastrado com sucesso!");
        novo.exibir();
    }

    private void listarTodos() {
        System.out.println("\n\n");
        System.out.println("***** LISTAR ESTAGIÁRIOS *****");
        if (this.servico.Listar().isEmpty()) {
            System.out.println("Nenhum estagiário cadastrado.");
            return;
        }
        for (Estagiario item : this.servico.Listar()) {
            item.exibir();
            System.out.println();
        }
    }

    private boolean buscarPorCodigo() {
        System.out.println("\n\n");
        System.out.println("***** BUSCAR ESTAGIÁRIO POR CÓDIGO *****");
        int codigo = this.lerInteiro("Informe um código: ");
        this.estagiario = this.servico.Buscar(codigo);
        if (this.estagiario == null) {
            System.out.println("Estagiário não encontrado!");
            return false;
        }
        this.estagiario.exibir();
        return true;
    }

    private void editar() {
        System.out.println("\n\n");
        System.out.println("***** EDITAR ESTAGIÁRIO *****");
        if (!this.buscarPorCodigo()) {
            return;
        }
        int escolha = 0;
        while (escolha != 9) {
            System.out.println("1 - Trocar o nome");
            System.out.println("2 - Trocar o CPF");
            System.out.println("3 - Trocar o e-mail");
            System.out.println("4 - Trocar o telefone");
            System.out.println("5 - Trocar o endereço");
            System.out.println("6 - Trocar o valor da bolsa");
            System.out.println("7 - Trocar a carga horária semanal");
            System.out.println("8 - Trocar a área de estágio");
            System.out.println("9 - Salvar");
            escolha = this.lerInteiro("Selecione uma opção: ");
            switch (escolha) {
                case 1:
                    System.out.print("Nome: ");
                    this.estagiario.setNome(this.scan.nextLine());
                    break;
                case 2:
                    System.out.print("CPF: ");
                    this.estagiario.setCpf(this.scan.nextLine());
                    break;
                case 3:
                    System.out.print("E-mail: ");
                    this.estagiario.setEmail(this.scan.nextLine());
                    break;
                case 4:
                    System.out.print("Telefone: ");
                    this.estagiario.setTelefone(this.scan.nextLine());
                    break;
                case 5:
                    System.out.print("Endereço: ");
                    this.estagiario.setEndereco(this.scan.nextLine());
                    break;
                case 6:
                    this.estagiario.setValorBolsa(this.lerDouble("Valor da Bolsa: "));
                    break;
                case 7:
                    this.estagiario.setCargaHorariaSemanal(this.lerInteiro("Carga Horária Semanal: "));
                    break;
                case 8:
                    System.out.print("Área de Estágio: ");
                    this.estagiario.setAreaEstagio(this.scan.nextLine());
                    break;
                case 9:
                    this.estagiario = this.servico.Alterar(this.estagiario);
                    System.out.println("Estagiário alterado com sucesso!");
                    this.estagiario.exibir();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private void excluir() {
        System.out.println("\n\n");
        System.out.println("***** EXCLUIR ESTAGIÁRIO *****");
        if (!this.buscarPorCodigo()) {
            return;
        }
        System.out.print("Confirma a exclusão? (S/N): ");
        String confirmacao = this.scan.nextLine();
        if (confirmacao.trim().equalsIgnoreCase("S")) {
            this.servico.Excluir(this.estagiario);
            System.out.println("Estagiário excluído com sucesso!");
        } else {
            System.out.println("Exclusão cancelada.");
        }
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(this.scan.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número inteiro.");
            }
        }
    }

    private Double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Double.parseDouble(this.scan.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número (ex.: 1200.50).");
            }
        }
    }

    public EstagiarioMenu() {
        this.scan = new Scanner(System.in);
        this.servico = new EstagiarioSrv();
    }
}
