/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import banco.Banco;
import basico.Abertura;
import java.sql.*;
public class AberturaDao{
	public Abertura abertura;
	public Banco bd;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private String men, sql;
	public static final byte INCLUSAO = 1;
	public static final byte ALTERACAO = 2;
	public static final byte EXCLUSAO = 3;
	
	public AberturaDao(){
		bd = new Banco();
		abertura = new Abertura();
	}
	public boolean localizar(){
		sql = "select * from abertura where codigo = ?";
		try{
			statement = bd.connection.prepareStatement(sql);
			statement.setLong(1, abertura.getCodigo()); 
			resultSet = statement.executeQuery();
			resultSet.first();
			abertura.setCodigo(resultSet.getLong(1));
			abertura.setMat(resultSet.getInt(2));
			abertura.setNome(resultSet.getString(3));
			abertura.setData(resultSet.getDate(4));
			abertura.setDesc(resultSet.getString(5));
			return true;
		}
		catch (SQLException erro){
			return false;
		}
	}
	public String atualizar(int operacao){
		men = "Operação realizada com sucesso !";
		try{
			if (operacao==INCLUSAO){
				sql = "insert into abertura values (?,?,?,?,?)";
				statement = bd.connection.prepareStatement(sql);
				statement.setLong(1, abertura.getCodigo());
				statement.setInt(2, abertura.getMat());
                                statement.setString(3, abertura.getNome());
				statement.setDate(4, (Date) abertura.getData());
				statement.setString(5, abertura.getDesc());
				
			}
			else if (operacao==ALTERACAO){
				sql = "update abertura set mat = ?, nome = ?, data = ?, " + "desc = ? where codigo = ?";
                                statement = bd.connection.prepareStatement(sql);
				statement.setLong(5, abertura.getCodigo());
				statement.setInt(1, abertura.getMat());
                                statement.setString(2, abertura.getNome());
				statement.setDate(3, (Date) abertura.getData());
				statement.setString(4, abertura.getDesc());
			}
			else if (operacao==EXCLUSAO){
				sql = "delete from abertura where codigo = ?";
				statement = bd.connection.prepareStatement(sql);
				statement.setLong(1, abertura.getCodigo());
			}
			if (statement.executeUpdate() == 0){
                            men = "Falha na operação !";
                        }
		}
		catch (SQLException erro){
			men = "Falha na operação " + erro.toString();
		}
		return men;
	}
}