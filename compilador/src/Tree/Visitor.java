package Tree;

public interface Visitor<C> {

        C visit(Select condicao);

        C visit(Tabela tabela);

        C visit(Update update);

        C visit(Insert insert);

        C visit(Delete delete);

        C visit(Condicao condicao);

        C visit(Valor valor);

        C visit(Campos campos);

        C visit(Valores valores);
}
