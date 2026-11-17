package DAO;

import Dominio.Egresso;
import FakeDB.EgressoFakeDB;

public class EgressoDAO extends AbsGenericDAO<Egresso> {

    @Override
    public Egresso Read(int codigo) {
        for (Egresso item : this.tabela) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Egresso Edit(Egresso alterado) {
        int codigoProcurado = alterado.getCodigo();
        Egresso existente = this.Read(codigoProcurado);
        if (existente != null) {
            int index = this.tabela.indexOf(existente);
            this.tabela.set(index, alterado);
            return alterado;
        }
        return null;
    }

    @Override
    public Egresso Add(Egresso novo) {
        int novoCodigo = 1;
        if (!this.tabela.isEmpty()) {
            novoCodigo = this.tabela.get(this.tabela.size() - 1).getCodigo() + 1;
        }
        novo.setCodigo(novoCodigo);
        this.tabela.add(novo);
        return novo;
    }

    @Override
    public Egresso Delete(Egresso apagado) {
        int codigoProcurado = apagado.getCodigo();
        Egresso existente = this.Read(codigoProcurado);
        if (existente != null) {
            this.tabela.remove(existente);
            return existente;
        }
        return null;
    }

    public EgressoDAO() {
        this.repositorio = new EgressoFakeDB();
        this.tabela = this.repositorio.getDados();
    }
}
