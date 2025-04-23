package org.example;

import java.util.ArrayList;

public class Jogador {

    private int posicao;
    private int dinheiro;
    private String nome;
    private int ativo;
    private ArrayList<Imoveis> imoveisjogador = new ArrayList<>();

    public Jogador(String nome, int dinheiro) {
        this.posicao = 0;
        this.dinheiro = dinheiro;
        this.nome = nome;
        this.ativo = 0;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Imoveis> getImoveisjogador() {
        return imoveisjogador;
    }

    public void setImoveisjogador(ArrayList<Imoveis> imoveisjogador) {
        this.imoveisjogador = imoveisjogador;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nJogador: ");
        sb.append("nome = ").append(nome);
        sb.append(", posicao = ").append(posicao);
        sb.append(", dinheiro = ").append(dinheiro);
        sb.append(", imoveisjogador = ").append(imoveisjogador);
        return sb.toString();
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

}
