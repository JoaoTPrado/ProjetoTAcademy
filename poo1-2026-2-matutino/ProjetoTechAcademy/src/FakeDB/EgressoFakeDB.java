package FakeDB;

import java.util.ArrayList;

import Dominio.Egresso;

public class EgressoFakeDB extends AbsGenericFakeDB<Egresso> {

    public EgressoFakeDB() {
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }

    @Override
    protected void autoPreencher() {
        this.dados.add(new Egresso(101, "Carla Menezes", "11111111101", 2019, "Ciência da Computação", "Desenvolvimento Backend"));
        this.dados.add(new Egresso(102, "Rafael Torres", "11111111102", 2021, "Análise e Desenv. de Sistemas", "Segurança da Informação"));
        this.dados.add(new Egresso(103, "Beatriz Alves", "11111111103", 2023, "Engenharia de Software", "Ciência de Dados"));
        this.dados.add(new Egresso(104, "Lucas Ferreira", "11111111104", 2020, "Ciência da Computação", "Infraestrutura e Cloud"));
    }
}
