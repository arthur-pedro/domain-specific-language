package Tree;

public class Campo extends Exp {

    public String campo;

    public Campo(String campo) {
        this.campo = campo;
    }

    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() {
        return "" + campo;
    }
}
