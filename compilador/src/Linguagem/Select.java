package Linguagem;

import Tabela.Tabela;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Select {

    String input;
    Map<String,String> mapAtributo;
    Map<String,String> mapCondition;

    public Select(String input, Map<String, String> mapAtributo, Map<String, String> mapCondition) {
        this.input = input;
        this.mapAtributo = mapAtributo;
        this.mapCondition = mapCondition;
    }

    /**
     * @apiNote seleciona um registro de uma tabela
     * @param input
     * @param mapAtributo
     * @param mapCondition
     * @return tabela
     **/
    public static void select(String input, Map<String, String>  mapAtributo, Map<String, String> mapCondition){
        String database = SimpleSQL.PATH + input + ".txt";
        try{

            /** instancia as listas das tabelas **/
            Tabela dataTable = new Tabela();
            dataTable.setBody(new ArrayList<>());
            dataTable.setHeader(new ArrayList<>());

            /** Lê o arquivo (tabela) **/
            BufferedReader file = new BufferedReader(new FileReader(database));

            /** Pega a quantidade de linhas e colunas do arquivo (tabela) **/
            String tabela[][] = SimpleSQL.getTable(file, SimpleSQL.getDimensions(new BufferedReader(new FileReader(database))));

            /** Caso nenhum campo seja especificado, retorna todos **/
            if(mapAtributo == null || mapAtributo.get("*") != null || mapAtributo.isEmpty()){
                for(int index = 0; index < tabela[0].length; index++){
                    mapAtributo.put(tabela[0][index].toUpperCase(), tabela[0][index]);
                }
                mapAtributo.remove("*");
            }

            /** percorre as linhas e colunas e cria uma TABELA **/
            for(int linha = 0; linha < tabela.length; linha++){

                /** Adiciona a cláusula WHERE **/
                if(mapCondition == null){
                    System.out.println("Erro em campo Where, sem especificação");
                } else {
                    if(linha > 0 && mapCondition != null ) continue;;
                }
//                if(linha > 0 && condition != null && !tabela[linha][0].equals(condition)) continue;

                for(int coluna = 0; coluna < tabela.length; coluna++){
                    if(coluna < tabela[0].length && mapAtributo.get(tabela[0][coluna]) != null){
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

        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
