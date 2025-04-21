package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //inicializa o tabuleiro
        ArrayList<Imoveis> imoveistabuleiro = new ArrayList<>();
        ArrayList<Jogador> listaJogadores = new ArrayList<>();

        Tabuleiro tabuleiro = new Tabuleiro(imoveistabuleiro);

        //inicializa 3 jogadores
        for (int i = 1; i < 4; i++) {
            System.out.println("Nome do jogador " + i);
            String nome = input.nextLine();
            Jogador jogador = new Jogador(nome);
            listaJogadores.add(jogador);
        }

        //cria e insere os imoveis (cor, nome, aluguel, preco) (algo muito errado aqui)
        tabuleiro.criarImovel("Rosa", "Loja", 175, 3000);
        tabuleiro.criarImovel("Amarelo", "Predio", 250, 5000);
        tabuleiro.criarImovel("Azul", "Casa", 100, 1000);
        tabuleiro.criarImovel("Roxo", "Shopping", 350, 7000);

        tabuleiro.removerImovel(tabuleiro.getImoveistabuleiro().remove(0));
        System.out.println(tabuleiro.getImoveistabuleiro().toString());

        //jogo??
        int continuar;
        do {
            for (Jogador jogador : listaJogadores) {
                if (jogador.getAtivo() == 0) {
                    tabuleiro.dado(jogador);
                    tabuleiro.jogadorAcoes(jogador);
                    System.out.println(jogador.getDinheiro());
                    if (jogador.getDinheiro() < 0) {
                        System.out.println("Jogador faliu");
                        jogador.setAtivo(1);
                    }
                }
            }
            continuar = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirmation", JOptionPane.YES_NO_OPTION);
        } while (continuar == 0);

    }
}
