package Tabela;

import java.util.List;

public class DataTable {

   private List<String> header;

   private List<String> body;

    public DataTable() {
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public List<String> getBody() {
        return body;
    }

    public void setBody(List<String> body) {
        this.body = body;
    }
}
