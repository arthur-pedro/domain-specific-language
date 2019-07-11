package Tree;

public class Insert extends Com{

    public Exp tabela;
    public Exp valores;

    public Insert(Exp tb, Exp vals) {
        this.tabela = tb;
        this.valores = vals;
    }

    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() {
        return "INSERT INTO " + tabela + " VALUES " + valores;
    }
}
