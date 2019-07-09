package Tree;

public class Valores extends Exp {

    public String valor1;
    public String valor2;

    public Valores(String valor1,String valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }
    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() {
        return valor1 + "," + valor2;
    }
}
