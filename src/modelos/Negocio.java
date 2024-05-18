package modelos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

}
