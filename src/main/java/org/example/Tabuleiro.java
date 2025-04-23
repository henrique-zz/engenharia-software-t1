package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {

    private ArrayList<Imoveis> imoveistabuleiro;

    public Tabuleiro(ArrayList<Imoveis> imoveistabuleiro) {
        this.imoveistabuleiro = imoveistabuleiro;
    }

    //inserir e remover imoveis
    public void criarImovel(String cor, String nome, int aluguel, int preco) {
        Imoveis imovel = new Imoveis(nome, preco, aluguel, cor);
        imoveistabuleiro.add(imovel);
    }

    public void removerImovel(Imoveis imovel) {
        imoveistabuleiro.remove(imovel);
    }

    //codigo pro jogador comprar imoveis e pagar aluguel
    public void comprarImovel(Imoveis imovel, Jogador jogador) {
        if (imovel.getPreco() <= jogador.getDinheiro()) {
            jogador.setDinheiro(jogador.getDinheiro() - imovel.getPreco());
            jogador.getImoveisjogador().add(imovel);
            imovel.setDono(jogador);
        } else {
            System.out.println("Dinheiro insuficiente");
        }
    }

    public void pagarAluguel(Imoveis imovel, Jogador jogador) {
        jogador.setDinheiro(jogador.getDinheiro() - imovel.getAluguel());
        imovel.getDono().setDinheiro(imovel.getDono().getDinheiro() + imovel.getAluguel());
    }

    // dado que move o jogador
    public void dado(Jogador jogador) {
        int max = imoveistabuleiro.size();
        int dado = (int) Math.round(Math.random() * max) + 1;
        System.out.println("Dado: " + dado);
        int novaPosicao;
        if (jogador.getPosicao() + dado < max) {
            novaPosicao = jogador.getPosicao() + dado;
        } else {
            novaPosicao = jogador.getPosicao() + dado - max;
        }
        jogador.setPosicao(novaPosicao);
        System.out.println("Nova posicao do jogador: " + novaPosicao);
    }

    // mostrar imovel
    public void mostrarImovel(Imoveis imovel) {
        System.out.println(imovel.toString());
    }

    public ArrayList<Imoveis> getImoveistabuleiro() {
        return imoveistabuleiro;
    }

    public void setImoveistabuleiro(ArrayList<Imoveis> imoveistabuleiro) {
        this.imoveistabuleiro = imoveistabuleiro;
    }

    // açoes do jogador
    public void jogadorAcoes(Jogador jogador) {
        int pos = jogador.getPosicao();
        Imoveis imovel = imoveistabuleiro.get(pos);
        mostrarImovel(imovel);
        if (imovel.getDono() == null) {
            int result = JOptionPane.showConfirmDialog(null, "Comprar imovel?", "Comprar", JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                comprarImovel(imovel, jogador);
            }

        } else {
            if (imovel.getDono() != jogador) {
                System.out.println("Voce deve pagar aluguel");
                pagarAluguel(imovel, jogador);
            } else {
                System.out.println("Voce e o dono do imovel");
            }
        }
    }

    public Imoveis imovelMaiorValor(List<Imoveis> listaImoveis){
        double maiorValor = Integer.MIN_VALUE;
        Imoveis imoveis = null;

        for(Imoveis i: listaImoveis){
            if(i.getPreco() > maiorValor){
                maiorValor = i.getPreco();
                imoveis = i;
            }
        }

        return imoveis;
    }

    public Imoveis imovelMenorValor(List<Imoveis> listaImoveis){
        double menorValor = Integer.MAX_VALUE;
        Imoveis imoveis = null;

        for(Imoveis i: listaImoveis){
            if(i.getPreco() < menorValor){
                menorValor = i.getPreco();
                imoveis = i;
            }
        }

        return imoveis;
    }
}
