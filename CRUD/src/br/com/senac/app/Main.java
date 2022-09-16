package br.com.senac.app;

import br.com.senac.agenda.Contato;
import br.com.senac.dao.ContatoDAO;

public class Main {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		
		ContatoDAO cadastra = new ContatoDAO();
		
		contato.setNome("Maurilio");
		contato.setTelefone("999999999");
		contato.setEmail("teste@senac.com");
		
//		cadastra.insert(contato);
		
//		Utilizando o método Update
		
		Contato c2 = new Contato();
		
		c2.setNome("Marcelo de Pádua");
		c2.setTelefone("12345");
		c2.setEmail("teste@teste");
		c2.setId(1);
		
//		cadastra.update(c2);
		
//		Utilizando o método delete
		
		cadastra.delete(3);
		
		// Imprimindo os dados do Select
		for(Contato c : cadastra.selectContato()) {
			System.out.println(c.getNome());
		}
	}

}
