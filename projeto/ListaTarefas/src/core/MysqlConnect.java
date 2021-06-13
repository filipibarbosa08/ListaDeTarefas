/*
 * Classe que contém um método responsável por retornar
 * uma conexão com o banco de dados.
 * 
 */
package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Filipi
 */
public class MysqlConnect {

    // -- Conexão via código --
    private static final String URL = "jdbc:mysql://localhost/tarefas";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Arquivo arquivo;

    public static Connection connectDB() throws SQLException {

        
        // -- Conexão via código -- 
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;
        
       

        /*
          Conexão via arquivo txt utilizada no executável do programa.
          No código abaixo foi feito uma leitura no arquivo txt que contém 
          as informações necessárias para conexão com o banco de dados
          e removido o caracter inicial e final de cada linha que trata-se apenas
          de um indicador para o início e término de uma String no arquivo.
        
        
        
        
        arquivo = new Arquivo();
        String[] config = {"", "", ""};
        config = arquivo.leitura();
        
        String url = config[0].substring(1, config[0].length()-1);
        String user = config[1].substring(1, config[1].length()-1);
        String pass;
        
        if(config[2].equals("* *")){
            pass = "";
        } else {
            pass = config[2].substring(1, config[2].length()-1);
        }
        
         Connection conn = DriverManager.getConnection(url, user, pass);
         return conn;
         */
       

    }
}
