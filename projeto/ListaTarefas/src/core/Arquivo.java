/*
 * Classe responsável por realizar a manipulação do arquivo que contém as informações
 * para conexão do banco de dados.
 * Nesta classe, contém métodos para realizar a leitura, bem como escrita do arquivo.
 */
package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Filipi
 */
public class Arquivo {

    Path caminho;

    FileReader reader;
    BufferedReader bufferRead;
    FileWriter writer;
    BufferedWriter bufferWriter;
    FileInputStream fis = null;
    PrintWriter pw;

    String linha = new String();
    int contador = 0;
    File arquivo;
    String[] config = {"", "", ""};

    public Arquivo() {
        arquivo = new File("config.txt");

    }

    public String[] leitura() {

        try {
            reader = new FileReader(arquivo);
            bufferRead = new BufferedReader(reader);

           
            while (contador != 3) {

                config[contador] = bufferRead.readLine();

               
                contador++;

            }

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, "Erro de I/O: " + erro,
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return config;
    }

    public void escrita(String[] config) {
        try {

            writer = new FileWriter(arquivo);

            bufferWriter = new BufferedWriter(writer);

            bufferWriter.write(config[0]);
            bufferWriter.newLine();
            bufferWriter.write(config[1]);
            bufferWriter.newLine();
            bufferWriter.write(config[2]);
            
            
   
         

            

        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void fecharEscrita() {
        try {

            bufferWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void fecharLeitura() {
        try {

            bufferRead.close();
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

