package Tree;

public class Insert extends Com{

    public Exp campo;
    public Valor valor;

    public Insert(Exp campo, Valor valor) {
        this.campo = campo;
        this.valor = valor;
    }

    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() {
        return "INSERT INTO (" + campo + ") VALUES (" + valor + ")";
    }
}
