import Visao.EgressoTest;
import Visao.EstagiarioMenu;
import Visao.EstagiarioTest;
import Visao.VisitanteTest;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length > 0 && args[0].equalsIgnoreCase("teste")) {
            new EgressoTest().executar();
            new VisitanteTest().executar();
            new EstagiarioTest().executar();
        } else {
            EstagiarioMenu menu = new EstagiarioMenu();
            menu.executar();
        }
    }
}
