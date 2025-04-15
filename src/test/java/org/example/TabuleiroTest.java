package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TabuleiroTest {

    @Test
    void imovelMaiorValor() {
        Tabuleiro tabuleiro = new Tabuleiro();
        Imovel imovel1 = new Imovel("A","AA","Rosa",600,100);
        Imovel imovel2 = new Imovel("B","BB","Rosa",5000,300);
        Imovel imovel3 = new Imovel("C","CC","Rosa",400,90);

        List<Imovel> listaImoveis = List.of(imovel1,imovel2,imovel3);

        Imovel imovelMaiorValor = tabuleiro.imovelMaiorValor(listaImoveis);

        double maiorValor = imovelMaiorValor.getValorCompra();

        Assertions.assertEquals(5000, maiorValor);
    }

    @Test
    void imovelMenorValor() {
        Tabuleiro tabuleiro = new Tabuleiro();
        Imovel imovel1 = new Imovel("A","AA","Rosa",600,100);
        Imovel imovel2 = new Imovel("B","BB","Rosa",5000,300);
        Imovel imovel3 = new Imovel("C","CC","Rosa",400,90);

        List<Imovel> listaImoveis = List.of(imovel1,imovel2,imovel3);

        Imovel imovelMenorValor = tabuleiro.imovelMenorValor(listaImoveis);

        double menorValor = imovelMenorValor.getValorCompra();

        Assertions.assertEquals(400, menorValor);
    }
}