package Tree;

public class Delete extends Com {

    public Tabela tabela;
    public Condicao condicao;

    public Delete(Tabela tabela, Condicao condicao) {
        this.tabela = tabela;
        this.condicao = condicao;
    }

    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() {
        return "DELETE FROM (" + tabela + ") WHERE (" + condicao + ")";
    }
}
