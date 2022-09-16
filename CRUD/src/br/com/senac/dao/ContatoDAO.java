package br.com.senac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import br.com.senac.agenda.Contato;
import br.com.senac.factory.ConexaoFactory;

public class ContatoDAO {
	// CRUD - Create, Read, Update e Delete
	
	// Método para inserir os dados no bd
	public void insert(Contato contato) {
		// Variável para registrar a consulta
		String query = "INSERT INTO contato (nome, telefone, email) VALUES (? , ?, ?)";
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			// Criar conexão com bd
			con = ConexaoFactory.createConnectionToMySQL();
			// Preparando Query para ser Executada
			pstm = con.prepareStatement(query);
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getTelefone());
			pstm.setString(3, contato.getEmail());
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} // Garantindo que a conexão será finalizada
		finally {
//			Fechando conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	// Método para mostrar os dados do BD
	public List<Contato> selectContato() {
		String query = "SELECT * FROM contato";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		// Objeto para receber os resultados
		ResultSet rset = null;
		
		try {
			con = ConexaoFactory.createConnectionToMySQL();
			// Preparando Query para ser Executada
			pstm = con.prepareStatement(query);
			// Receber array do BD
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Contato contato = new Contato();
				contato.setNome(rset.getString("nome"));
				
				contatos.add(contato);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			Fechando conexões
			try {
				if(rset!=null) {
					rset.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contatos;
		}
	
	// Método para atualizar os dados do DB
	public void update(Contato contato) {
		
		String query = "UPDATE contato SET nome = ?, telefone = ?, email = ?"+"WHERE id_contato = ?";
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			// Criar conexão com bd
			con = ConexaoFactory.createConnectionToMySQL();
			// Preparando Query para ser Executada
			pstm = con.prepareStatement(query);
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getTelefone());
			pstm.setString(3, contato.getEmail());
			pstm.setInt(4, contato.getId());
			
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
//			Fechando conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	}
	
	// Método para apagar dados do DB
	public void delete(int id) {
		String query = "DELETE FROM contato WHERE id_contato = ?";
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			// Criar conexão com bd
			con = ConexaoFactory.createConnectionToMySQL();
			// Preparando Query para ser Executada
			pstm = con.prepareStatement(query);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			Fechando conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	}
}
 	
	