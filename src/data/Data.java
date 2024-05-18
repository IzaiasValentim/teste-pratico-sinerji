package data;

import modelos.Funcionario;

import java.util.HashSet;
import java.util.Set;

public class Data {
    private Set<Funcionario> funcionarios = new HashSet<>();

    public Set<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public Data() {
    }

}
