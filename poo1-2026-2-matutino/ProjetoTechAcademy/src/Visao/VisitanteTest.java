package Visao;

import Dominio.Visitante;
import Servico.VisitanteSrv;

public class VisitanteTest extends AbsVisao {

    private VisitanteSrv srv;

    @Override
    public void executar() {
        System.out.println("\n===== TESTE VISITANTE =====");

        System.out.println("-- Listar (carga inicial) --");
        for (Visitante item : this.srv.Listar()) {
            item.exibir();
        }

        System.out.println("-- Incluir --");
        Visitante novo = this.srv.Incluir(new Visitante(0, "Teste Novo", "99999999999", "teste@email.com",
            "(67) 90000-0000", "Rua Teste, 1", "Palestra", 1999, "Auditório"));
        novo.exibir();

        System.out.println("-- Buscar --");
        Visitante achado = this.srv.Buscar(novo.getCodigo());
        achado.exibir();

        System.out.println("-- Alterar --");
        achado.setSetorVisita("Diretoria");
        this.srv.Alterar(achado).exibir();

        System.out.println("-- Excluir --");
        this.srv.Excluir(achado).exibir();
        System.out.println("Buscar após excluir: " + this.srv.Buscar(achado.getCodigo()));
        System.out.println("Total de registros: " + this.srv.Listar().size());
    }

    public VisitanteTest() {
        this.srv = new VisitanteSrv();
    }
}
