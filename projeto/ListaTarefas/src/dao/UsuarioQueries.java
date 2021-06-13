/*
 * Classe para execução do insert da tabela usuário do banco de dados.
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
public class UsuarioQueries {
    
    
    private Connection connection;
    private PreparedStatement insertUsuario;
    

    
    public UsuarioQueries(){
        try {
            connection = MysqlConnect.connectDB();
            insertUsuario = connection.prepareStatement("INSERT INTO usuario "
                    + "(usuario,senha) VALUES (?, ?)");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public boolean addUsuario(String usuario,String senha) {
        int result = 0;
        try {
            insertUsuario.setString(1, usuario);
            insertUsuario.setString(2, senha);
           

            result = insertUsuario.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false;

        }
        return true;
    }
    
    
}
