package Tree;

public class Insert extends Com{

    public Campos campos;
    public Valores valores;

    public Insert(Campos campos, Valores valores) {
        this.campos = campos;
        this.valores = valores;
    }

    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() {
        return "INSERT INTO (" + campos + ") VALUES (" + valores + ")";
    }
}
