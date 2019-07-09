package Tree;

public abstract class Com {
    public abstract <C> C accept(Visitor<C> v);
}
