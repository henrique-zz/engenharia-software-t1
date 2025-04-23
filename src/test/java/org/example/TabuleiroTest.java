package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TabuleiroTest {

    @Test
    void criarImovelTestaListaTamanho1() {
        ArrayList<Imoveis> listaImoveis = new ArrayList<>();
        Tabuleiro tabuleiro = new Tabuleiro(listaImoveis);

        tabuleiro.criarImovel("Rosa", "Loja", 175, 3000);

        // verifica se a lista de imóveis contém o imóvel criado e se ele foi adicionado corretamente, verificando se seu nome corresponde e se o tamanho da lista também,
        Assertions.assertEquals(1, listaImoveis.size());
        Assertions.assertEquals("Loja", listaImoveis.get(0).getNome());
    }

    @Test
    void removerImovelTestaListaVaziaAposRemocao() {
        ArrayList<Imoveis> listaImoveis = new ArrayList<>();
        Tabuleiro tabuleiro = new Tabuleiro(listaImoveis);

        tabuleiro.criarImovel("Rosa", "Loja", 175, 3000);
        Imoveis imovel = listaImoveis.get(0);

        // removemos o imovel, para então verificarmos se a lista ficou vazia após a remoção
        tabuleiro.removerImovel(imovel);

        Assertions.assertTrue(listaImoveis.isEmpty());
    }

    @Test
    void comprarImovelVerificaListaImoveis() {
        ArrayList<Imoveis> listaImoveis = new ArrayList<>();
        Tabuleiro tabuleiro = new Tabuleiro(listaImoveis);

        Jogador jogador = new Jogador("Jogador1", 5000);
        tabuleiro.criarImovel("Rosa", "Loja", 175, 3000);
        Imoveis imovel = listaImoveis.get(0);

        tabuleiro.comprarImovel(imovel, jogador);

        // verifica se o jogador terá o dinheiro descontado corretamente após a compra
        Assertions.assertEquals(5000 - 3000, jogador.getDinheiro());

        // verifica se o imóvel foi adicionado corretamente à lista de imóveis do jogador
        Assertions.assertTrue(jogador.getImoveisjogador().contains(imovel));
    }

    @Test
    void pagarAluguelVerificaValoresDosJogadores() {
        ArrayList<Imoveis> listaImoveis = new ArrayList<>();
        Tabuleiro tabuleiro = new Tabuleiro(listaImoveis);

        Jogador jogador1 = new Jogador("Jogador1", 5000); // jogador que vai pagar o aluguel
        Jogador jogador2 = new Jogador("Jogador2", 1000); // dono do imóvel
        tabuleiro.criarImovel("Rosa", "Loja", 175, 3000);

        Imoveis imovel = listaImoveis.get(0);
        imovel.setDono(jogador2);

        // o jogador1 paga o aluguel para o jogador2
        tabuleiro.pagarAluguel(imovel, jogador1);

        // verifique se o dinheiro foi subtraído de jogador1 e adicionado ao jogador2 de forma correta
        Assertions.assertEquals(5000 - 175, jogador1.getDinheiro());
        Assertions.assertEquals(1000 + 175, jogador2.getDinheiro());
    }

    @Test
    void dadoVerificaPosicaoJogadorDentroDoTabuleiro() {
        ArrayList<Imoveis> listaImoveis = new ArrayList<>();
        Tabuleiro tabuleiro = new Tabuleiro(listaImoveis);
        Jogador jogador = new Jogador("Jogador1", 5000);


        tabuleiro.criarImovel("Cor 1", "Imóvel 1", 100, 1000);
        tabuleiro.criarImovel("Cor 2", "Imóvel 2", 190, 2000);
        tabuleiro.criarImovel("Cor 3", "Imóvel 3", 250, 3000);


        jogador.setPosicao(0);

        // movimenta o jogador
        tabuleiro.dado(jogador);

        // verifica se a nova posição está dentro do tamanho do tabuleiro
        int novaPosicao = jogador.getPosicao();
        Assertions.assertTrue(novaPosicao >= 0 && novaPosicao < listaImoveis.size());
    }

    @Test
    void jogadorAcoesComprarVerificaSeComprouOImovelCorretamente() {
        ArrayList<Imoveis> listaImoveis = new ArrayList<>();
        Tabuleiro tabuleiro = new Tabuleiro(listaImoveis);

        Jogador jogador = new Jogador("Jogador1", 5000);
        tabuleiro.criarImovel("Rosa", "Loja", 175, 3000);
        Imoveis imovel = listaImoveis.get(0);

        tabuleiro.jogadorAcoes(jogador);

        // verifica se o jogador comprou o imóvel
        Assertions.assertTrue(jogador.getImoveisjogador().contains(imovel));
    }

    @Test
    void jogadorAcoesAluguelVerificaPagamentoAluguel() {
        ArrayList<Imoveis> listaImoveis = new ArrayList<>();
        Tabuleiro tabuleiro = new Tabuleiro(listaImoveis);

        Jogador jogador1 = new Jogador("Jogador1", 5000);
        Jogador jogador2 = new Jogador("Jogador2", 1000);

        tabuleiro.criarImovel("Rosa", "Loja", 175, 3000);

        Imoveis imovel = listaImoveis.get(0);
        imovel.setDono(jogador2);

        // simula o pagamento de aluguel
        tabuleiro.jogadorAcoes(jogador1);

        // verifique se o pagamento de aluguel ocorreu corretamente
        Assertions.assertEquals(5000 - 175, jogador1.getDinheiro());
        Assertions.assertEquals(1000 + 175, jogador2.getDinheiro());
    }



    @Test
    void imovelMaiorValorRetorna5000() {
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
    void imovelMenorValorRetorna1000() {
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