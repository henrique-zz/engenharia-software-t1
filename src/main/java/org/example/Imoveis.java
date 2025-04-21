package org.example;

public class Imoveis {

    private String nome;
    private int preco;
    private int aluguel;
    private String cor;
    private Jogador dono;

    public Imoveis(String nome, int preco, int aluguel, String cor) {
        this.nome = nome;
        this.preco = preco;
        this.aluguel = aluguel;
        this.cor = cor;
        this.dono = null;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getAluguel() {
        return aluguel;
    }

    public void setAluguel(int aluguel) {
        this.aluguel = aluguel;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Jogador getDono() {
        return dono;
    }

    public void setDono(Jogador dono) {
        this.dono = dono;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nImovel: ");
        sb.append("nome = ").append(nome);
        sb.append(", preco = ").append(preco);
        sb.append(", aluguel = ").append(aluguel);
        sb.append(", cor = ").append(cor);
        sb.append(", dono = ").append(dono);
        return sb.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

