package Tree;

public class Delete extends Com {

    public Exp tabela;
    public Exp condicao;

    public Delete(Exp tabela, Exp condicao) {
        this.tabela = tabela;
        this.condicao = condicao;
    }

    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() {
        return "DELETE FROM (" + tabela + ") WHERE (" + condicao + ")";
    }
}
