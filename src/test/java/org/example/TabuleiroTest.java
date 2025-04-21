package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TabuleiroTest {

    @Test
    void imovelMaiorValor() {
        ArrayList<Imoveis> listaImoveis = new ArrayList<>();
        Tabuleiro tabuleiro = new Tabuleiro(listaImoveis);

        tabuleiro.criarImovel("Rosa", "Loja", 175, 3000);
        tabuleiro.criarImovel("Amarelo", "Predio", 250, 5000);
        tabuleiro.criarImovel("Azul", "Casa", 100, 1000);

        Imoveis imoveisMaiorValor = tabuleiro.imovelMaiorValor(listaImoveis);

        double maiorValor = imoveisMaiorValor.getPreco();

        Assertions.assertEquals(5000, maiorValor);
    }

    @Test
    void imovelMenorValor() {
        ArrayList<Imoveis> listaImoveis = new ArrayList<>();
        Tabuleiro tabuleiro = new Tabuleiro(listaImoveis);

        tabuleiro.criarImovel("Rosa", "Loja", 175, 3000);
        tabuleiro.criarImovel("Amarelo", "Predio", 250, 5000);
        tabuleiro.criarImovel("Azul", "Casa", 100, 1000);

        Imoveis imoveisMenorValor = tabuleiro.imovelMenorValor(listaImoveis);

        double menorValor = imoveisMenorValor.getPreco();

        Assertions.assertEquals(1000, menorValor);
    }
}