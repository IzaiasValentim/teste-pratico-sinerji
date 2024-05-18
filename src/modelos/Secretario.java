package modelos;

import java.time.YearMonth;

public class Secretario extends Funcionario {
    
    private static final Double SALARIO_BASE = 7000.0;
    private static final Double ADICIONAL_AO_ANO = 1000.0;
    private static final Double BENEFICIO = 0.20;
    public static final String CARGO_SECRETARIO = "Secretario";

    public Secretario(String nome, YearMonth dataContratacao) {
        super(nome, CARGO_SECRETARIO, dataContratacao, SALARIO_BASE);
    }

    @Override
    public Double calculoAdicionalAoAno(int mes, int ano) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double calculoBeneficio(int mes, int ano) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double calculoSalario(int mes, int ano) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double calculoSalarioTotal(int mes, int ano) {
        // TODO Auto-generated method stub
        return null;
    }

}
