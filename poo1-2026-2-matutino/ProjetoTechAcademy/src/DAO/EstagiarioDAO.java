package DAO;

import Dominio.Estagiario;
import FakeDB.EstagiarioFakeDB;

public class EstagiarioDAO extends AbsGenericDAO<Estagiario> {

    @Override
    public Estagiario Read(int codigo) {
        for (Estagiario item : this.tabela) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Estagiario Edit(Estagiario alterado) {
        int codigoProcurado = alterado.getCodigo();
        Estagiario existente = this.Read(codigoProcurado);
        if (existente != null) {
            int index = this.tabela.indexOf(existente);
            this.tabela.set(index, alterado);
            return alterado;
        }
        return null;
    }

    @Override
    public Estagiario Add(Estagiario novo) {
        int novoCodigo = 1;
        if (!this.tabela.isEmpty()) {
            novoCodigo = this.tabela.get(this.tabela.size() - 1).getCodigo() + 1;
        }
        novo.setCodigo(novoCodigo);
        this.tabela.add(novo);
        return novo;
    }

    @Override
    public Estagiario Delete(Estagiario apagado) {
        int codigoProcurado = apagado.getCodigo();
        Estagiario existente = this.Read(codigoProcurado);
        if (existente != null) {
            this.tabela.remove(existente);
            return existente;
        }
        return null;
    }

    public EstagiarioDAO() {
        this.repositorio = new EstagiarioFakeDB();
        this.tabela = this.repositorio.getDados();
    }
}
