package com.example.ac1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ac1.models.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    
    @Query("SELECT p FROM Produto p WHERE p.prodPreco > :valor")
    List<Produto> findProdutosComPrecoMaiorQue(@Param("valor") Double valor);

    @Query("SELECT p FROM Produto p WHERE p.prodPreco <= :valor")
    List<Produto> findProdutosComPrecoMenorOuIgualA(@Param("valor") Double valor);

    @Query("SELECT p FROM Produto p WHERE p.prodNome LIKE :nome%")
    List<Produto> findProdutosComNomeQueComecaCom(@Param("nome") String nome);
}

