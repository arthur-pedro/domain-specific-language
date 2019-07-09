package Tree;

public class Select extends Com {

    public Exp campos;
    public Tabela tabela;

    public Select(Exp campos, Tabela tabela) {
        this.campos = campos;
        this.tabela = tabela;
    }

    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() {
        return "SELECT " + campos + " FROM " + tabela;
    }
}
