package Tree;

public class Valor extends Exp {

    public String valor;

    public Valor(String valor) {
        this.valor = valor;
    }

    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() {
        return valor;
    }
}
