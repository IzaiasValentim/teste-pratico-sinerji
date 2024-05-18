import static modelos.Secretario.CARGO_SECRETARIO;
import static modelos.Vendedor.CARGO_VENDEDOR;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import data.Data;
import modelos.Funcionario;
import modelos.Negocio;
import modelos.Secretario;
import modelos.Vendedor;

public class Main {

    public static List<Vendedor> retornaApenasVendedores(List<Funcionario> todosOsFuncionarios) {
        List<Vendedor> listaDeVendedores = new ArrayList<>();
        todosOsFuncionarios.forEach(funcionario -> {
            if (funcionario.getCargo().equals(CARGO_VENDEDOR))
                listaDeVendedores.add((Vendedor) funcionario);
        });
        return listaDeVendedores;
    }

    public static List<Secretario> retornaApenasSecretarios(List<Funcionario> todosOsFuncionarios) {
        List<Secretario> listaDeSecretarios = new ArrayList<>();
        todosOsFuncionarios.forEach(funcionario -> {
            if (funcionario.getCargo().equals(CARGO_SECRETARIO))
                listaDeSecretarios.add((Secretario) funcionario);
        });
        return listaDeSecretarios;
    }

    public static void main(String[] args) {

        Data loadData = new Data();
        var listaFuncionarios = loadData.getFuncionarios();

        Negocio Empresa = new Negocio();
        Empresa.setFuncionarios(listaFuncionarios);
        var todosOsFuncionarios = Empresa.getFuncionarios();

        List<Vendedor> listaDeVendedores = retornaApenasVendedores(todosOsFuncionarios);
        List<Secretario> listaDeSecretarios = retornaApenasSecretarios(todosOsFuncionarios);

        List<Funcionario> apenasFuncionariosComBeneficios = new ArrayList<>();
        apenasFuncionariosComBeneficios.addAll(listaDeVendedores);
        apenasFuncionariosComBeneficios.addAll(listaDeSecretarios);

        var dataDeConsulta = YearMonth.of(2022, 4);

        System.out.println("Valor total em salarios(salários+benefícios): "
                + Empresa.calcularSalariosTotaisAoMes(todosOsFuncionarios, dataDeConsulta.getMonthValue(),
                        dataDeConsulta.getYear()));

        System.out.println("Valor total dos salários(sem beneficios): " +
                Empresa.calcularApenasSalariosAoMes(todosOsFuncionarios, dataDeConsulta.getMonthValue(),
                        dataDeConsulta.getYear()));

        System.out.println("Valor total dos beneficios ao mes: " +
                Empresa.calcularBeneficiosAoMes(apenasFuncionariosComBeneficios, dataDeConsulta.getMonthValue(),
                        dataDeConsulta.getYear()));

        System.out.println("Maior salário total do mês: " +
                Empresa.retornaMaiorSalario(todosOsFuncionarios, dataDeConsulta.getMonthValue(),
                        dataDeConsulta.getYear()).getNome());

        System.out.println("Maior beneficio do mês: " +
                Empresa.retornarNomeDoMaiorBeneficiario(apenasFuncionariosComBeneficios, dataDeConsulta.getMonthValue(),
                        dataDeConsulta.getYear()));

        System.out.println("Vendedor que mais vendeu: " +
                Empresa.retornarVendedorQueMaisVendeu(listaDeVendedores, dataDeConsulta.getMonthValue(),
                        dataDeConsulta.getYear()).getNome());
    }
}