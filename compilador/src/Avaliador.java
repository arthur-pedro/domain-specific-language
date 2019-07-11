import Util.SimpleSQL;
import Tree.*;
import Tabela.DataTable;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Avaliador implements Visitor<String> {

    /**
     * @apiNote insere um registro em uma tabela
     * @param select
     * @return tabela
     **/
    @Override
    public String visit(Select select) {

        /** instancia as listas das tabelas **/
        DataTable dataTable = new DataTable();
        dataTable.setBody(new ArrayList<>());
        dataTable.setHeader(new ArrayList<>());
        Map<String,String> campos = new TreeMap<>();

        /** Monta o path para o banco de dados **/
        String database = SimpleSQL.PATH + select.tabela + ".txt";

        /** Lê a tabela **/
        BufferedReader file;
        try {
            file = new BufferedReader(new FileReader(database));

            /** Pega a quantidade de linhas e colunas do arquivo (tabela) **/
            String tabela[][] = SimpleSQL.getTable(file, SimpleSQL.getDimensions(new BufferedReader(new FileReader(database))));

            /** Caso nenhum campo seja especificado, retorna todos **/
            if(select.campos == null ||
                    select.campos.toString().equals("*") ||
                    select.campos.toString().equals("all") ||
                    select.campos.toString().equals("ALL")){
                for(int index = 0; index < tabela[0].length; index++){
                    campos.put(tabela[0][index].toUpperCase(), tabela[0][index]);
                }
                campos.remove("*");
            }else{
                String[] listaCampo = select.campos.toString().split(",");
                for(int index = 0; index < listaCampo.length; index++){
                    campos.put(listaCampo[index].toUpperCase(), listaCampo[index].toString());
                }
            }

            /** percorre as linhas e colunas e cria uma TABELA **/
            for(int linha = 0; linha < tabela.length; linha++){
                for(int coluna = 0; coluna < tabela.length; coluna++){
                    if(coluna < tabela[linha].length && campos.get(tabela[0][coluna]) != null){
                        /** header **/
                        if(linha == 0){
                            dataTable.getHeader().add(tabela[linha][coluna]);
                        }
                        /** body **/
                        else{
                            dataTable.getBody().add(tabela[linha][coluna]);
                        }
                    }
                }
            }

            /** Printa a TABELA **/
            SimpleSQL.printaTabela(dataTable);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Select realizado com sucesso!";
    }

    /**
     * @apiNote atualiza um registro de uma tabela
     * @param update
     * @return tabela
     **/
    @Override
    public String visit(Update update) {
        return null;
    }

    /**
     * @apiNote insere um registro em uma tabela
     * @param insert
     * @return tabela
     **/
    @Override
    public String visit(Insert insert) {
        /** Monta o path para o banco de dados **/
        String database = SimpleSQL.PATH + insert.tabela + ".txt";

        File file = new File(database);
        try {
            /** Reescreve arquivo com dados antigos **/
            FileReader reader = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(reader);
            String linha = lerArq.readLine();
            FileWriter writer = new FileWriter(file);
            int id = 0;
            while (linha != null) {
                writer.write(linha);
                writer.write("\n");
                linha = lerArq.readLine();
                id++;
            }
            reader.close();

            /** Insere novo dado **/
            if(insert.valores.toString().split(",").length == 1){
                System.out.println("Erro ao inserir: os campos obrigatórios não foram incluídos");
            }else{
                writer.write(id + "-" + insert.valores.toString().replace(",","-"));
                System.out.println("\n-> Inserido com sucesso!\n");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @apiNote deleta um registro de uma tabela
     * @param delete
     * @return tabela
     **/
    @Override
    public String visit(Delete delete) {
        return null;
    }

    @Override
    public String visit(Tabela tabela) {
        return null;
    }

    @Override
    public String visit(Condicao condicao) {
        return null;
    }

    @Override
    public String visit(Valor valor) {
        return null;
    }

    @Override
    public String visit(Campos campos) {
        return null;
    }

    @Override
    public String visit(Valores valores) {
        return null;
    }

    @Override
    public String visit(Campo campo) {
        return null;
    }
}
