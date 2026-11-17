package Visao;

import Dominio.Estagiario;
import Servico.EstagiarioSrv;

public class EstagiarioTest extends AbsVisao {

    private EstagiarioSrv srv;

    @Override
    public void executar() {
        System.out.println("\n===== TESTE ESTAGIÁRIO =====");

        System.out.println("-- Listar (carga inicial) --");
        for (Estagiario item : this.srv.Listar()) {
            item.exibir();
        }

        System.out.println("-- Incluir --");
        Estagiario novo = this.srv.Incluir(new Estagiario(0, "Teste Novo", "99999999999", "teste@email.com",
            "(67) 90000-0000", "Rua Teste, 1", 1000.0, 20, "Marketing"));
        novo.exibir();

        System.out.println("-- Buscar --");
        Estagiario achado = this.srv.Buscar(novo.getCodigo());
        achado.exibir();

        System.out.println("-- Alterar --");
        achado.setValorBolsa(1500.0);
        this.srv.Alterar(achado).exibir();

        System.out.println("-- Excluir --");
        this.srv.Excluir(achado).exibir();
        System.out.println("Buscar após excluir: " + this.srv.Buscar(achado.getCodigo()));
        System.out.println("Total de registros: " + this.srv.Listar().size());
    }

    public EstagiarioTest() {
        this.srv = new EstagiarioSrv();
    }
}
