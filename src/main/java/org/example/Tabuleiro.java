package org.example;

import java.util.List;

public class Tabuleiro {

    public Imovel imovelMaiorValor(List<Imovel> listaImoveis){
        double maiorValor = Integer.MIN_VALUE;
        Imovel imovel = null;

        for(Imovel i: listaImoveis){
            if(i.getValorCompra() > maiorValor){
                maiorValor = i.getValorCompra();
                imovel = i;
            }
        }

        return imovel;
    }

    public Imovel imovelMenorValor(List<Imovel> listaImoveis){
        double menorValor = Integer.MAX_VALUE;
        Imovel imovel = null;

        for(Imovel i: listaImoveis){
            if(i.getValorCompra() < menorValor){
                menorValor = i.getValorCompra();
                imovel = i;
            }
        }

        return imovel;
    }
}
