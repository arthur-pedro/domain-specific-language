package Tree;

public abstract class Valor {

    public Valor() {}

    public abstract <C> C acepct(Visitor<C> valor);
}
