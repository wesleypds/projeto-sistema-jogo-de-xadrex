package xadrez;

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

    private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
        tabuleiro.colocaPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
    }

    public void configuracaoInicial() {
        colocarNovaPeca('b', 6, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
        colocarNovaPeca('e', 1,  new Rei(tabuleiro, Cor.BRANCO));
    }
}
