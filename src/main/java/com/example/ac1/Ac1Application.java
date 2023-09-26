package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.Categoria;
import com.example.ac1.models.Produto;
import com.example.ac1.repository.CategoriaRepository;
import com.example.ac1.repository.ProdutoRepository;

@SpringBootApplication
public class Ac1Application {

@Bean
public CommandLineRunner init(@Autowired ProdutoRepository produtoRepository,
@Autowired CategoriaRepository categoriaRepository) {
	return args -> {
		Categoria categoria1 = new Categoria();
		categoria1.setCatNome("Computadores");

		Categoria categoria2 = new Categoria();
		categoria2.setCatNome("Vestimentas");

		Categoria categoria3= new Categoria();
		categoria3.setCatNome("Outros");

		categoriaRepository.save(categoria1);
		categoriaRepository.save(categoria2);
		categoriaRepository.save(categoria3);

		Produto produto1 = new Produto();
		produto1.setProdNome("Notebook");
		produto1.setProdPreco(10000.0);
		produto1.setCategoriaProduto(categoria1);

		Produto produto2 = new Produto();
		produto2.setProdNome("Camisetas");
		produto2.setProdPreco(80.0);
		produto2.setCategoriaProduto(categoria2);

		Produto produto3 = new Produto();
		produto3.setProdNome("Lapis");
		produto3.setProdPreco(2.0);
		produto3.setCategoriaProduto(categoria3);

		produtoRepository.saveAll(List.of(produto1, produto2, produto3));

		System.out.println("Produtos com preço maior que 15:");
		List<Produto> produtosPrecoMaiorQue15 = produtoRepository.findProdutosComPrecoMaiorQue(15.0);
		produtosPrecoMaiorQue15.forEach(System.out::println);

		System.out.println("Produtos com preço menor ou igual a 25:");
		List<Produto> produtosPrecoMenorOuIgual25 = produtoRepository.findProdutosComPrecoMenorOuIgualA(25.0);
		produtosPrecoMenorOuIgual25.forEach(System.out::println);

		System.out.println("Produtos que o nome começa com 'Note':");
		List<Produto> produtosNomeComecaComProduto = produtoRepository.findProdutosComNomeQueComecaCom("Note");
		produtosNomeComecaComProduto.forEach(System.out::println);

		System.out.println("Categorias que começam com 'Comp':");
		List<Categoria> categoriasComE = categoriaRepository.findBycatNomeStartingWith("Comp");
		categoriasComE.forEach(System.out::println);

		System.out.println("Categoria com produtos pelo ID:");
		Categoria categoriaComProdutos = categoriaRepository.findCategoriaWithProdutosById(1L);
		System.out.println(categoriaComProdutos.getCatNome());
		categoriaComProdutos.getProdutos().forEach(produto -> System.out.println("- " + produto.getProdNome()));
	};
}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
