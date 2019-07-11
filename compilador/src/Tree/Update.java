package Tree;

public class Update extends Com {

    public Exp campo;
    public Exp valor;
    public Exp condicao;

    public Update(Exp campo, Exp valor, Exp condicao) {
        this.campo = campo;
        this.valor = valor;
        this.condicao = condicao;
    }

    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() {
        return "UPDATE (" + campo + ") SET (" + valor + ") WHERE (" + condicao + ")";
    }
}
