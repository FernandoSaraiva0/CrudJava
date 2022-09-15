package br.com.senac.app;

import br.com.senac.agenda.Contato;
import br.com.senac.dao.ContatoDAO;

public class Main {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		
		ContatoDAO cadastra = new ContatoDAO();
		
		contato.setNome("Maria");
		contato.setTelefone("999999999");
		contato.setEmail("teste@senac.com");
		
		cadastra.insert(contato);
		// Imprimindo os dados do Select
		for(Contato c : cadastra.selectContato()) {
			System.out.println(c.getNome());
		}
	}

}
