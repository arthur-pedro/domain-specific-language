package Util;

import Tabela.DataTable;

import java.io.*;
import java.util.*;

public class SimpleSQL {

    public static final String PATH = "compilador/src/Banco/";

    /**
     * @apiNote recebe um arquivo e monta uma matriz com todos os campos
     * @param file
     * @param matriz
     * @return tabela
    **/
    public static String[][] getTable(BufferedReader file, String[][] matriz) throws IOException {
        int cont = 0;
        while(file.ready()){
            String[] linha = file.readLine().split("-");
            for(int index = 0; index < linha.length; index++){
                matriz[cont][index] = linha[index];
            }
            cont++;
        }
        file.close();
        return matriz;
    }

    /**
     * @apiNote recebe um arquivo e calcula as dimensões da tabela
     * @param file
     * @return dimensoes
    **/
    public static String[][] getDimensions(BufferedReader file) throws IOException {
        int row = 0;
        int column = 0;
        String linha;
        while((linha = file.readLine()) != null){
            row++;
            column = linha.split("-").length;
        }
        String dimensoes[][] = new String[row][column];
        file.close();
        return dimensoes;
    }

    /**
     * @apiNote Recebe uma dataTable e printa no console
     * @param dataTable
     * @return printa dataTable
     **/
    public static void printaTabela(DataTable dataTable){
        String header = "";
        String body = "";
        String skip = "\n";
        int count = 0;
        for(int index = 0; index < dataTable.getHeader().size(); index++){
            if(header.equals("")) header = dataTable.getHeader().get(index);
            else  header = header + "                           " + dataTable.getHeader().get(index);
        }
        for(int index = 0; index < dataTable.getBody().size(); index++){
            if(body.equals("")) body = dataTable.getBody().get(index);
            else {
                if(count < dataTable.getHeader().size()) {
                    body = body + "                            " + dataTable.getBody().get(index);
                }
                else{
                    body = body + skip + dataTable.getBody().get(index);
                    count = 0;
                }
            }
            count++;
        }
        System.out.println(header + "\n");
        System.out.println(body.replace("\n\n", "\n"));
    }

}
