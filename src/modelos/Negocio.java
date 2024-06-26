package modelos;

import java.time.YearMonth;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static modelos.Gerente.CARGO_GERENTE;

public class Negocio {
    private Set<Funcionario> funcionarios = new HashSet<Funcionario>();

    public Negocio() {
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios.stream().toList();
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Double calcularSalariosTotaisAoMes(List<Funcionario> listaFuncionarios, int mes, int ano) {
        Double total = 0.0;
        for (Funcionario funcionario : listaFuncionarios) {
            total += funcionario.calculoSalarioTotal(mes, ano);
        }
        return total;
    }

    public Double calcularApenasSalariosAoMes(List<Funcionario> listaFuncionarios, int mes, int ano) {
        Double total = 0.0;
        for (Funcionario funcionario : listaFuncionarios) {
            if (YearMonth.of(ano, mes).isBefore(funcionario.getDataContratacao()))
                total += 0.0;
            total += funcionario.calculoSalario(mes, ano);
        }
        return total;
    }

    public Double calcularBeneficiosAoMes(List<Funcionario> listaComBeneficio, int mes, int ano) {
        Double total = 0.0;
        for (Funcionario funcionario : listaComBeneficio) {
            if (!funcionario.getCargo().equals(CARGO_GERENTE))
                total += funcionario.calculoBeneficio(mes, ano);
        }
        return total;
    }

    public Funcionario retornaMaiorSalario(List<Funcionario> listaMaiorSalario, int mes, int ano) {
        Double maiorSalario = 0.0;
        Funcionario funcionarioDeMaiorSalario = listaMaiorSalario.get(0);

        for (Funcionario funcionario : listaMaiorSalario) {
            var salarioDaIteracao = funcionario.calculoSalarioTotal(mes, ano);
            if (salarioDaIteracao > maiorSalario) {
                maiorSalario = salarioDaIteracao;
                funcionarioDeMaiorSalario = funcionario;
            }
        }
        return funcionarioDeMaiorSalario;
    }

    public String retornarNomeDoMaiorBeneficiario(List<Funcionario> listaBeneficiarios, int mes, int ano) {
        Double maiorBeneficio = 0.0;
        Funcionario maiorBeneficiario = listaBeneficiarios.get(0);

        for (Funcionario funcionario : listaBeneficiarios) {
            var beneficio = funcionario.calculoBeneficio(mes, ano);

            if (beneficio > maiorBeneficio) {
                maiorBeneficiario = funcionario;
                maiorBeneficio = beneficio;
            }
        }
        return maiorBeneficiario.getNome();
    }

    public Vendedor retornarVendedorQueMaisVendeu(List<Vendedor> vendedores, int mes, int ano) {
        Double maiorVenda = 0.0;
        Vendedor maiorVendedor = vendedores.get(0);

        for (Vendedor vendedor : vendedores) {
            var totalVendaDoMes = vendedor.valorVendasAoMes(mes, ano);

            if (totalVendaDoMes > maiorVenda) {
                maiorVendedor = vendedor;
                maiorVenda = totalVendaDoMes;
            }
        }
        return maiorVendedor;
    }

}
