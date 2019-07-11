package Tree;

public class Condicao extends Exp{

    public String campo;
    public String operacao;
    public String valor;

    public Condicao(String campo,String operacao,String valor) {
        this.campo = campo;
        this.operacao = operacao;
        this.valor = valor;
    }

    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() { return "" + campo + operacao + valor; }


}
