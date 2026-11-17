package Visao;

import Dominio.Egresso;
import Servico.EgressoSrv;

public class EgressoTest extends AbsVisao {

    private EgressoSrv srv;

    @Override
    public void executar() {
        System.out.println("\n----- TESTE EGRESSO -----");

        System.out.println("-- Listar (carga inicial) --");
        for (Egresso item : this.srv.Listar()) {
            item.exibir();
        }

        System.out.println("-- Incluir --");
        Egresso novo = this.srv.Incluir(new Egresso(0, "Teste Novo", "99999999999", 2024, "Sistemas de Informação", "QA"));
        novo.exibir();

        System.out.println("-- Buscar --");
        Egresso achado = this.srv.Buscar(novo.getCodigo());
        achado.exibir();

        System.out.println("-- Alterar --");
        achado.setAreaAtuacao("Gestão de Projetos");
        this.srv.Alterar(achado).exibir();

        System.out.println("-- Excluir --");
        this.srv.Excluir(achado).exibir();
        System.out.println("Buscar após excluir: " + this.srv.Buscar(achado.getCodigo()));
        System.out.println("Total de registros: " + this.srv.Listar().size());
    }

    public EgressoTest() {
        this.srv = new EgressoSrv();
    }
}
