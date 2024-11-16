package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Model.Produto;


public class DAO {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/baseLucas?useTimezone=true&serverTimezone=UTC";
	private String user ="root";
	private String password = "admin";
	
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public boolean inserir(Produto produto) {
		String sql = "INSERT INTO produto (marca,nome,descricao) VALUES (?,?,?)";
		try(Connection con = conectar();
				PreparedStatement inserir = con.prepareStatement(sql) ) {
			
			inserir.setString(1, produto.getMarca());
			inserir.setString(2, produto.getNome());
			inserir.setString(3, produto.getDescricao());
			int linhasAfetadas = inserir.executeUpdate();
			if(linhasAfetadas > 0) {
				System.out.println("Valor Inserido");
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean atualizar(Produto produto, int id) {
	    String sql = "UPDATE Produto SET marca = ?, nome = ?, descricao = ? WHERE id = ?";
	    try (Connection con = conectar();
	         PreparedStatement inserir = con.prepareStatement(sql)) {
	        
	        inserir.setString(1, produto.getMarca());
	        inserir.setString(2, produto.getNome());
	        inserir.setString(3, produto.getDescricao());
	        inserir.setInt(4, id);

	        int linhasAfetadas = inserir.executeUpdate();
	        if(linhasAfetadas > 0) {
	        	System.out.println("Valor Atualizado");
	        	return true;
	        }else {
	        	return false;
	        }
	        
	    } catch (Exception e) {
	        System.out.println(e);
	        return false;
	    }
	}
	
	
	public List<Produto> listar() throws SQLException {
		
		List<Produto> lista = new ArrayList<>();
		String sql = "SELECT * FROM Produto";
		
		try(Connection con = conectar();
		         PreparedStatement stmt = con.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()){
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setMarca(rs.getString("marca"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				lista.add(produto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return lista;
		
	}
	
	public Produto listaUm(int id) throws SQLException{
		
		String sql = "SELECT * FROM produto where id = ?";
		
		try(Connection con = conectar();
				PreparedStatement insere = con.prepareStatement(sql);){
			insere.setInt(1, id);
			ResultSet rs = insere.executeQuery();
				if(rs.next()) {
					Produto produto = new Produto();
					produto.setId(rs.getInt("id"));
					produto.setMarca(rs.getString("marca"));
					produto.setNome(rs.getString("nome"));
					produto.setDescricao(rs.getString("descricao"));
					return produto;
				}else {
					return null;
				}
			}
	}
	
	public boolean delete(int id){
		String sql = "DELETE FROM Produto WHERE id = ?";
		try(Connection con = conectar();
				PreparedStatement buscar = con.prepareStatement(sql)){
			buscar.setInt(1,id);
			int linhasAfetadas = buscar.executeUpdate();
			if(linhasAfetadas > 0) {
				System.out.println("Valor Excluido");
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	

}
