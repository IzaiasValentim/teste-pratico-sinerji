import data.Data;
import modelos.Negocio;

public class Main {
    public static void main(String[] args) {

        Data loadData = new Data();
        var listaFuncionarios = loadData.getFuncionarios();

        Negocio Empresa = new Negocio();
        Empresa.setFuncionarios(listaFuncionarios);
        var todosOsFuncionarios = Empresa.getFuncionarios();
        
    }
}