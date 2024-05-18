package modelos;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Funcionario {

    private static final Double SALARIO_BASE = 12000.0;
    private static final Double ADICIONAL_AO_ANO = 1800.0;
    private static final Double BENEFICIO = 0.30;
    public static final String CARGO_VENDEDOR = "Vendedor";

    public static class Venda {
        private Double valor;
        private YearMonth dataDaVenda;

        public Venda(Double valor, YearMonth dataDaVenda) {
            this.valor = valor;
            this.dataDaVenda = dataDaVenda;
        }

        public Double getValor() {
            return valor;
        }

        public void setValor(Double valor) {
            this.valor = valor;
        }

        public YearMonth getDataDaVenda() {
            return dataDaVenda;
        }

        public void setDataDaVenda(YearMonth dataDaVenda) {
            this.dataDaVenda = dataDaVenda;
        }
    }

    private List<Venda> vendas = new ArrayList<>();

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas.addAll(vendas);
    }

    public Vendedor(String nome, YearMonth dataContratacao, List<Venda> vendas) {
        super(nome, CARGO_VENDEDOR, dataContratacao, SALARIO_BASE);
        this.setVendas(vendas);
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
