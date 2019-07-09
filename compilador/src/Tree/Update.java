package Tree;

public class Update extends Com {

    public Exp campo;
    public Valor valor;
    public Condicao condicao;

    public Update(Exp campo, Valor valor, Condicao condicao) {
        this.campo = campo;
        this.valor = valor;
        this.condicao = condicao;
    }

    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() {
        return "UPDATE (" + campo + ") SET (" + valor + ") WHERE (" + condicao + ")";
    }
}
