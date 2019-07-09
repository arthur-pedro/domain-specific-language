package Tree;

public class Select extends Com {

    public Campos campos;
    public Tabela tabela;

    public Select(Campos campos, Tabela tabela) {
        this.campos = campos;
        this.tabela = tabela;
    }

    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() {
        return "SELECT " + campos + " FROM " + tabela;
    }
}
