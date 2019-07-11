package Tree;

public class Select extends Com {

    public Exp campos;
    public Exp tabela;

    public Select(Exp campos, Exp tabela) {
        this.campos = campos;
        this.tabela = tabela;
    }

    public Select(String s, String tabela) {
        super();
    }

    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() {
        return "SELECT " + campos + " FROM " + tabela;
    }
}
