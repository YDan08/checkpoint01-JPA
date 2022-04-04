package br.com.fiap.jpa;

import java.time.LocalDate;

import br.com.fiap.impl.LivroServiceImpl;
import br.com.fiap.jpa.entity.Livro;

public class Main {
  public static void main(String[] args) {
	LivroServiceImpl livroService = LivroServiceImpl.getInstance();
	
	Livro livro3 = new Livro("livro3","Daniel", LocalDate.of(2020, 1, 1));
	livroService.cadastrar(new Livro("livro1","Clarice Lispector", LocalDate.of(2020, 1, 1)));
	livroService.cadastrar(new Livro("livro2","Yamashita", LocalDate.of(2020, 1, 1)));
	livroService.cadastrar(livro3);
	
	livroService.listar();
	
	
	livroService.remover(1L);
	
	livro3.setDataPublicacao(LocalDate.of(2022, 03, 10));
	livroService.atualizar(livro3);
}
}
