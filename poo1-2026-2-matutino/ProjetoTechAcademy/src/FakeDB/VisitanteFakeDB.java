package FakeDB;

import java.util.ArrayList;

import Dominio.Visitante;

public class VisitanteFakeDB extends AbsGenericFakeDB<Visitante> {

    public VisitanteFakeDB() {
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }

    @Override
    protected void autoPreencher() {
        this.dados.add(new Visitante(101, "Marcos Oliveira", "22222222201", "marcos@email.com", "(67) 99999-0001", "Rua das Flores, 100", "Reunião com a coordenação", 1001, "Coordenação"));
        this.dados.add(new Visitante(102, "Helena Prado", "22222222202", "helena@email.com", "(67) 99999-0002", "Av. Afonso Pena, 250", "Entrega de documentos", 1002, "Secretaria"));
        this.dados.add(new Visitante(103, "Gustavo Rocha", "22222222203", "gustavo@email.com", "(67) 99999-0003", "Rua Bahia, 45", "Manutenção de equipamentos", 1003, "Laboratório de Informática"));
    }
}
