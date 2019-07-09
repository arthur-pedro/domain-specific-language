package Tree;

public class Condicao extends Exp{

    public Exp campo;
    public String operacao;
    public Exp valor;

    public Condicao(Exp campo,String operacao,Exp valor) {
        this.campo = campo;
        this.operacao = operacao;
        this.valor = valor;
    }

    public <C> C accept(Visitor<C> v) {return v.visit(this);}

    public String toString() { return campo + operacao + valor; }


}
