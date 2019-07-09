package Tree;

public class Campos extends Exp {

    public String campo1;
    public String campo2;

    public Campos(String campo1,String campo2) {
        this.campo1 = campo1;
        this.campo2 = campo2;
    }
    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() {
        return campo1 + "," + campo2;
    }
}
