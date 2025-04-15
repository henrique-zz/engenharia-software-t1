package org.example;

import java.util.List;

public class Imovel {
    private String nome, localizacao, cor;
    private double valorCompra, valorAluguel;

    public Imovel(String nome, String localizacao, String cor, double valorCompra, double valorAluguel) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.cor = cor;
        this.valorCompra = valorCompra;
        this.valorAluguel = valorAluguel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "nome='" + nome + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", cor='" + cor + '\'' +
                ", valorCompra=" + valorCompra +
                ", valorAluguel=" + valorAluguel +
                '}';
    }
}
