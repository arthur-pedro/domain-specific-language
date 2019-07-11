
import java.io.*;
import java_cup.runtime.*;
import Tree.Com;

public class Main {

    public static void main(String[] args) throws Exception{

        InputStream stream = new FileInputStream("compilador/input.imp");
        Reader reader = new InputStreamReader(stream);
        Scanner scanner = new Scanner(reader);
        Parser parser = new Parser(scanner);

        Symbol s = parser.parse();
        Com result = (Com)s.value;
		System.out.println("Arvore = " + result.toString());
		System.out.println("Executando:\n");
        System.out.println("__________________________________________________________________________________________\n");
		result.accept(new Avaliador());
        System.out.println("__________________________________________________________________________________________");
		System.out.println("\nFim da execução");
    }
}
