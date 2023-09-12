package xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8, 8);
        configuracaoInicial();
    }

    public PecaXadrez[][] getPecas() {
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
            }
        }
        return mat;
    }

    public void configuracaoInicial() {
        tabuleiro.colocaPeca(new Rei(tabuleiro, Cor.BRANCO), new Posicao(0, 4));
        tabuleiro.colocaPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(0, 0));
        tabuleiro.colocaPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(7, 4));
        tabuleiro.colocaPeca(new Torre(tabuleiro, Cor.PRETO), new Posicao(7, 0));
    }
}
