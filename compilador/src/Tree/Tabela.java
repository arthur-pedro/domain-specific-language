package Tree;

public class Tabela extends Exp{

    public String tabela;

    public Tabela(String tabela) {
        this.tabela = tabela;
    }

    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() { return tabela; }
}
