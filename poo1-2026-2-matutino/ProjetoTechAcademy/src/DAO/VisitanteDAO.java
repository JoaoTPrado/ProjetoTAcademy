package DAO;

import Dominio.Visitante;
import FakeDB.VisitanteFakeDB;

public class VisitanteDAO extends AbsGenericDAO<Visitante> {

    @Override
    public Visitante Read(int codigo) {
        for (Visitante item : this.tabela) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Visitante Edit(Visitante alterado) {
        int codigoProcurado = alterado.getCodigo();
        Visitante existente = this.Read(codigoProcurado);
        if (existente != null) {
            int index = this.tabela.indexOf(existente);
            this.tabela.set(index, alterado);
            return alterado;
        }
        return null;
    }

    @Override
    public Visitante Add(Visitante novo) {
        int novoCodigo = 1;
        if (!this.tabela.isEmpty()) {
            novoCodigo = this.tabela.get(this.tabela.size() - 1).getCodigo() + 1;
        }
        novo.setCodigo(novoCodigo);
        this.tabela.add(novo);
        return novo;
    }

    @Override
    public Visitante Delete(Visitante apagado) {
        int codigoProcurado = apagado.getCodigo();
        Visitante existente = this.Read(codigoProcurado);
        if (existente != null) {
            this.tabela.remove(existente);
            return existente;
        }
        return null;
    }

    public VisitanteDAO() {
        this.repositorio = new VisitanteFakeDB();
        this.tabela = this.repositorio.getDados();
    }
}
