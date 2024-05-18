package data;

import modelos.Funcionario;
import modelos.Gerente;
import modelos.Secretario;
import modelos.Vendedor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Data {
    private Set<Funcionario> funcionarios = new HashSet<>();

    public Set<Funcionario> getFuncionarios() {
        carregarFuncionariosDeArquivo();
        return this.funcionarios;
    }

    public Data(){
    }

    private void carregarFuncionariosDeArquivo() {

        try (BufferedReader br = new BufferedReader(new FileReader("data/funcionarios.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                String tipo = dados[0];
                String nome = dados[1];
                YearMonth dataContratacao = YearMonth.parse(dados[2]);

                switch (tipo) {
                    case "Secretario":
                        funcionarios.add(new Secretario(nome, dataContratacao));
                        break;
                    case "Vendedor":
                        List<Vendedor.Venda> vendas = new ArrayList<>();
                        for (int i = 3; i < dados.length; i++) {
                            String[] vendaDados = dados[i].split(",");
                            Double valor = Double.parseDouble(vendaDados[0]);
                            YearMonth dataDaVenda = YearMonth.parse(vendaDados[1]);
                            vendas.add(new Vendedor.Venda(valor, dataDaVenda));
                        }
                        funcionarios.add(new Vendedor(nome, dataContratacao, vendas));
                        break;
                    case "Gerente":
                        funcionarios.add(new Gerente(nome, dataContratacao));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
