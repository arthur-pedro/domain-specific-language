package Lex;

public class Lex {

    public boolean correct(String query){
        String obj = "S";
        while(query.length() > 0 && obj.length() > 0){
            if(notTerminal(getInicio(obj))){
                obj = tabela(getInicio(obj), getInicio(query)) + obj.substring(1);
            }else if(getInicio(query).equals(getInicio(obj))){
                obj = obj.substring(1);
                query = query.substring(1);
            }else{
                return false;
            }
        }
        return query.length() == 0 && obj.length() == 0;
    }

    public String getInicio(String s){
        return s.substring(0,1);
    }
    public boolean notTerminal(String s){
        return s.equals("E")  || s.equals("O") || s.equals("S");
    }

    String tabela(String nt, String t) {
        if (nt.equals("E")) {
            return t.equals("n") ? "nO" : null;
        } else if (nt.equals("O")) {
            if (t.equals("n") || t.equals("$")) {
                return "";
            }else if(t.equals(("+"))){
                return "+E";
            }else if(t.equals(("-"))){
                return "-E";
            }else if(t.equals(("*"))){
                return "*E";
            }
        } else if (nt.equals("S")) {
            return t.equals("n") ? "E$" : null;
        }
        return null;
    }

    /**
     * QUERY -> SELECT
     * QUERY -> INSERT
     * QUERY -> DELETE
     * QUERY -> UPDATE
     *
     * SELECT -> select FIELD from TABLE
     * FIELD -> exp
     * FIELD -> exp, FIELD
     * TABLE -> exp
     * TABLE -> exp, TABLE
     *
     * INSERT...
     *
     * UPDATE...
     *
     * DELETE...
     * */
}
