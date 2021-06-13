/*
 * Classe para manipular os dados da tabela Tarefa.
 */
package dao;

import java.sql.Date;

/**
 *
 * @author Filipi
 */
public class Tarefa {
    
    
    
    private int codigo;
    private String descricao;
    private java.sql.Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    

    public Tarefa(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Tarefa() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
}
