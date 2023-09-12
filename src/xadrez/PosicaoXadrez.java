package xadrez;

import tabuleiro.Posicao;

public class PosicaoXadrez {
    private Character coluna;
    private Integer linha;

    public PosicaoXadrez(char coluna, int linha) {
        if ((coluna < 'a' || coluna > 'h') && (linha < 1 || linha > 8)) {
            throw new XadrezExcecao("Erro ao instânciar PosicaoXadrez. Os valores válidos são de a1 a h8");
        }
        this.coluna = coluna;
        this.linha = linha;
    }

    public Character getColuna() {
        return coluna;
    }

    public Integer getLinha() {
        return linha;
    }

    protected Posicao toPosicao() {
        return new Posicao(8 - linha, coluna - 'a');
    }

    protected static PosicaoXadrez fromPosicao(Posicao posicao) {
        return new PosicaoXadrez((char) ('a' - posicao.getColuna()), 8 - posicao.getLinha());
    }

    @Override
    public String toString() {
        return "" + coluna + linha;
    }
}
