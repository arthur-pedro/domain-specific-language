
import java_cup.runtime.*;
import java.io.*;
%%
%cup
%line
%column
%char
%class Scanner
%{

%}
%eofval{
    return new Symbol(sym.EOF);
%eofval}

%%
"select" { return new Symbol(sym.SELECT);}
"insert" { return new Symbol(sym.INSERT);}
"into" { return new Symbol(sym.INTO);}
"update" { return new Symbol(sym.UPDATE);}
"delete" { return new Symbol(sym.DELETE);}
"set" { return new Symbol(sym.SET);}
"from" {return new Symbol (sym.FROM);}
"where" { return new Symbol(sym.WHERE);}
"values" { return new Symbol (sym.VALUES);}
[a-zA-Z][a-zA-Z0-9]* { return new Symbol(sym.VALOR, yytext()); }
[ \t\f\r\n] { /* ignore white space. */ }
. { System.err.println("Illegal character: "+yytext()); }
