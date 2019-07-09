package Tree;

public interface Visitor<C> {

        C visit(Valor valor);

        C visit(Condicao condicao);

        C visit(ListaValores listaValores);

        C visit(ListaCondicoes listaCondicoes);

}
