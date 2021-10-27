/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author cbobio
 */
import java.sql.*;
public class Banco {
    public Connection connection = null;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String DBNAME = "atc_portal";
    private final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
    private final String LOGIN = "root";
    private final String SENHA = "195682";

    public static void main (String[] args){
        Banco bd = new Banco();
        bd.getConnection();
        bd.close();
    }
    /**
     * metodo que faz conexao com o banco de dados
     * retorna true se houve sucesso, ou false em caso negativo
     */
    public boolean getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, LOGIN, SENHA);
            System.out.println("Conectou");
            return true;
        } catch (ClassNotFoundException erro) {
            System.out.println("Driver nao encontrado " + erro.toString());
            return false;
        } catch (SQLException erro) {
            System.out.println("Falha ao conectar " + erro.toString());
            return false;
        }
    }

    public void close() {
        try {
            connection.close();
            System.out.println("Desconectou");
        } catch (SQLException erro) {}
    }
}
