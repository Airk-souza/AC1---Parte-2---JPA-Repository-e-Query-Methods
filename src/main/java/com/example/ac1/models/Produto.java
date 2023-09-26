package com.example.ac1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @Column(length = 200, nullable = false)
    private String prodNome;

    @Column(nullable = false)
    private double prodPreco;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoriaProduto;

    public Produto(Long idProduto, String prodNome, double prodPreco, Categoria categoriaProduto) {
        this.idProduto = idProduto;
        this.prodNome = prodNome;
        this.prodPreco = prodPreco;
        this.categoriaProduto = categoriaProduto;
    }

    public Produto() {

    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getProdNome() {
        return prodNome;
    }

    public void setProdNome(String prodNome) {
        this.prodNome = prodNome;
    }

    public double getProdPreco() {
        return prodPreco;
    }

    public void setProdPreco(double prodPreco) {
        this.prodPreco = prodPreco;
    }

    public Categoria getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(Categoria categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    @Override
    public String toString() {
        return "Produto [idProduto=" + idProduto + ", prodNome=" + prodNome + ", prodPreco=" + prodPreco + "]";
    }


}
