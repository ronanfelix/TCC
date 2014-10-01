/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.view;

import java.io.FileReader;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import sistema.bean.Funcionario;
import sistema.dao.FuncionarioDAO;

/**
 *
 * @author ambiental.pelotas
 */
public class TestarImportacao {

    public static void main(String[] args) {
        try {
            Reader in = new FileReader("C:/temp/teste.txt");
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader().parse(in);

            String nome = "";
            String sexo = "";
            String dataNascimento = "";
            String endereco = "";
            String complemento = "";
            String bairro = "";
            String cidade = "";
            String cpf = "";
            String rg = "";
            String dataadmissao = "";
            String funcao = "";
            String pis = "";

            for (CSVRecord record : records) {
                nome = record.get("Nome");
                sexo = record.get("Sexo");
                dataNascimento = record.get("DataNascimento");
                endereco = record.get("Endereco");
                complemento = record.get("Complemento");
                bairro = record.get("Bairro");
                cidade = record.get("Cidade");
                cpf = record.get("Cpf");
                rg = record.get("Rg");
                dataadmissao = record.get("DataAdmissao");
                funcao = record.get("Funcao");
                pis = record.get("Pis");

                Funcionario f1 = new Funcionario();

                f1.setNome(nome);
                f1.setSexo(sexo);
                f1.setDtNascimento(dataNascimento);
                f1.setEndereco(endereco);
                f1.setComplemento(complemento);
                f1.setBairro(bairro);
                f1.setCidade(cidade);
                f1.setCpf(cpf);
                f1.setRg(rg);
                f1.setDtAdmissao(dataadmissao);
                f1.setFuncao(funcao);
                f1.setPis(pis);

                FuncionarioDAO funcI = new FuncionarioDAO(TelaPrincipal.getConexao());

                System.out.println("Nome:" + f1.getNome() + " Sexo:" + f1.getSexo() + " Data de Nascimento:" + f1.getDtNascimento() + " Endereço:" + f1.getEndereco() + " Complemento:" + f1.getComplemento() + " Bairro:" + f1.getBairro() + " Cidade:" + f1.getCidade() + " CPF:" + f1.getCpf() + " RG:" + f1.getRg() + " Data de Admissão:" + f1.getDtAdmissao() + " Função:" + f1.getFuncao() + " PIS:" + f1.getPis());

                funcI.inserir(f1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
