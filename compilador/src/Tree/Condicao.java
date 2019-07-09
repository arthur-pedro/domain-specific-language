package Tree;

public abstract class Condicao {

    public Condicao() {
    }

    public abstract <C> C accept(Visitor<C> condicao);

}
