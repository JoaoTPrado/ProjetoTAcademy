package FakeDB;

import java.util.ArrayList;

import Dominio.Estagiario;

public class EstagiarioFakeDB extends AbsGenericFakeDB<Estagiario> {

    public EstagiarioFakeDB() {
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }

    @Override
    protected void autoPreencher() {
        this.dados.add(new Estagiario(101, "Ana Beatriz Lima", "33333333301", "ana@email.com", "(67) 98888-0001", "Rua Ceará, 333", 1200.0, 30, "Tecnologia da Informação"));
        this.dados.add(new Estagiario(102, "Felipe Nunes", "33333333302", "felipe@email.com", "(67) 98888-0002", "Rua Pedro Celestino, 80", 1100.0, 25, "Biblioteca"));
        this.dados.add(new Estagiario(103, "Juliana Castro", "33333333303", "juliana@email.com", "(67) 98888-0003", "Av. Mato Grosso, 900", 1350.0, 30, "Secretaria Acadêmica"));
    }
}
