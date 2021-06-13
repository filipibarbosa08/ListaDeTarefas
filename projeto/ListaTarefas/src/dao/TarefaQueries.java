/*
 * Classe para execução das Queries e updates da tabela Tarefa do banco de dados.
 */
package dao;

import core.MysqlConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Filipi
 */
public class TarefaQueries {

    private Connection connection;
    private PreparedStatement selectAllTarefas;
    private PreparedStatement insertTarefa;
    private PreparedStatement updateTarefa;
    private PreparedStatement deleteTarefa;

    public TarefaQueries() {
        try {
            connection = MysqlConnect.connectDB();

            selectAllTarefas = connection.prepareStatement("select * from"
                    + " tarefa where descricao LIKE ?");

            insertTarefa = connection.prepareStatement("INSERT INTO tarefa"
                    + " (descricao,data,usuario)"
                    + " VALUES (?, ?,?)");

            updateTarefa = connection.prepareStatement("UPDATE tarefa "
                    + "SET data = ?,descricao = ?,usuario = ?"
                    + " WHERE codigo=?");

            deleteTarefa = connection.prepareStatement("DELETE FROM tarefa"
                    + " WHERE codigo = ?");

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle);
            System.exit(1);
        }
    }

    public boolean addTarefa(String descricao, java.sql.Date data,String usuario) {
        int result = 0;
        try {
            insertTarefa.setString(1, descricao);
            insertTarefa.setDate(2, data);
            insertTarefa.setString(3, usuario);

            result = insertTarefa.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);

        }
        return true;
    }
    
    public boolean updateTarefa(int codigo,String descricao, java.sql.Date data,String usuario){
        int result = 0;
        
        try {
            updateTarefa.setDate(1, data);
            updateTarefa.setString(2, descricao);
            updateTarefa.setString(3, usuario);
            updateTarefa.setInt(4, codigo);
             result = updateTarefa.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TarefaQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    
      public boolean deleteTarefa(int codigo){
        int result = 0;
        try{
            deleteTarefa.setInt(1, codigo);
            result = deleteTarefa.executeUpdate();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, sqle);
        }
        return true;
    }
    

}
