package com.example.ac1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ac1.models.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

    List<Categoria> findBycatNomeStartingWith(String nome);

    @Query("SELECT c FROM Categoria c LEFT JOIN FETCH c.produtos WHERE c.idCategoria = :idCategoria")
    Categoria findCategoriaWithProdutosById(@Param("idCategoria") Long idCategoria);

}
