package tabuleiro;

import tabuleiro.excecoes.TabuleiroExcecao;

public class Tabuleiro {
    private Integer linhas;
    private Integer colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if (linhas < 1 || colunas < 1) {
            throw new TabuleiroExcecao("Erro na criação do tabuleiro: É preciso que tenha pelo menos 1 linha e 1 coluna");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public Integer getLinhas() {
        return linhas;
    }

    public Integer getColunas() {
        return colunas;
    }

    public Peca peca(int linha, int coluna) {
        if (Boolean.FALSE.equals(existePosicao(linha, coluna))) {
            throw new TabuleiroExcecao("Erro: Esta posição não existe");
        }
        return pecas[linha][coluna];
    }

    public Peca peca(Posicao posicao) {
        if (Boolean.FALSE.equals(existePosicao(posicao))) {
            throw new TabuleiroExcecao("Erro: Esta posição não existe");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void colocaPeca(Peca peca, Posicao posicao) {
        if (Boolean.TRUE.equals(existePeca(posicao))) {
            throw new TabuleiroExcecao("Erro: Já existe uma peça nesta posição " + posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    public Boolean existePosicao(int linha, int coluna) {
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }

    public Boolean existePosicao(Posicao posicao) {
        return existePosicao(posicao.getLinha(), posicao.getColuna());
    }

    public Boolean existePeca(Posicao posicao) {
        if (Boolean.FALSE.equals(existePosicao(posicao))) {
            throw new TabuleiroExcecao("Erro: Esta posição não existe");
        }
        return peca(posicao) != null;
    }

    public Peca removePeca(Posicao posicao) {
        if (Boolean.FALSE.equals(existePosicao(posicao))) {
            throw new TabuleiroExcecao("Erro: Esta posição não existe");
        }
        if (peca(posicao) == null) {
            return null;
        }
        Peca aux = peca(posicao);
        aux.posicao = null;
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        return aux;
    }
}
