package modelos;

import java.time.YearMonth;

public abstract class Funcionario {

    private String nome;
    private String cargo;
    private YearMonth dataContratacao;
    private Double salarioBase;

    public Funcionario(String nome, String cargo, YearMonth dataContratacao, Double salarioBase) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public YearMonth getDataContratacao() {
        return dataContratacao;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public abstract Double calculoSalario(int mes, int ano);

    public abstract Double calculoBeneficio(int mes, int ano);

    public abstract Double calculoSalarioTotal(int mes, int ano);

    public abstract Double calculoAdicionalAoAno(int mes, int ano);

}
