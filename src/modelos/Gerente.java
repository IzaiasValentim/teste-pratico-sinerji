package modelos;

import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class Gerente extends Funcionario {

    private static final Double SALARIO_BASE = 20000.0;
    private static final Double ADICIONAL_AO_ANO = 3000.0;
    private static final Double BENEFICIO = 0.0;
    public static final String CARGO_GERENTE = "Gerente";

    public Gerente(String nome, YearMonth dataContratacao) {
        super(nome, CARGO_GERENTE, dataContratacao, SALARIO_BASE);
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

    @Override
    public Double calculoAdicionalAoAno(int mes, int ano) {
        if (ano < this.getDataContratacao().getYear()) {
            return 0.0;
        } else {
            YearMonth inicio = this.getDataContratacao();
            YearMonth dataAtual = YearMonth.of(ano, mes);
            Long anosDeTrabalho = inicio.until(dataAtual, ChronoUnit.YEARS);
            return anosDeTrabalho * ADICIONAL_AO_ANO;
        }
    }
    
}
