package br.com.senac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
			
			pstm = con.prepareStatement(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
