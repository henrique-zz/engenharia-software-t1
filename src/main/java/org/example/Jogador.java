package org.example;

import java.util.List;

public class Jogador {
    private String nome;
    private List<Imovel> listaImoveis;
    private double valorCarteira;

    public Jogador(String nome, List<Imovel> listaImoveis) {
        this.nome = nome;
        this.listaImoveis = listaImoveis;
        this.valorCarteira = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Imovel> getListaImoveis() {
        return listaImoveis;
    }

    public void setListaImoveis(List<Imovel> listaImoveis) {
        this.listaImoveis = listaImoveis;
    }

    public double getValorCarteira() {
        return valorCarteira;
    }

    public void setValorCarteira(double valorCarteira) {
        this.valorCarteira = valorCarteira;
    }
}
