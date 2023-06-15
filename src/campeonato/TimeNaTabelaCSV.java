package campeonato;

import time.Time;


public class TimeNaTabelaCSV implements InterfaceTimeNaTabela {
    private final Time time;
    private final int pontos;
    private final int numeroDeJogos;
    private final int numeroDeVitorias;
    private final int numeroDeEmpates;
    private final int numeroDeDerrotas;
    private final int saldoDeGols;
    private final int golsPro;
    private final int golsContra;
    private final double percentualAproveitamento;

    public TimeNaTabelaCSV(Time time, int pontos, int numeroDeJogos, int numeroDeVitorias, int numeroDeEmpates, int numeroDeDerrotas, int saldoDeGols, int golsPro, int golsContra, double percentualAproveitamento) {
        this.time = time;
        this.pontos = pontos;
        this.numeroDeJogos = numeroDeJogos;
        this.numeroDeVitorias = numeroDeVitorias;
        this.numeroDeEmpates = numeroDeEmpates;
        this.numeroDeDerrotas = numeroDeDerrotas;
        this.saldoDeGols = saldoDeGols;
        this.golsPro = golsPro;
        this.golsContra = golsContra;
        this.percentualAproveitamento = percentualAproveitamento;
    }

    @Override
    public String getNome() {
        return time.getNome();
    }

    @Override
    public int getPontosTime() {
        return pontos;
    }

    @Override
    public int getNumeroDeJogos() {
        return numeroDeJogos;
    }

    @Override
    public int getNumeroDeVitorias() {
        return numeroDeVitorias;
    }

    @Override
    public int getNumeroDeEmpates() {
        return numeroDeEmpates;
    }

    @Override
    public int getNumeroDeDerrotas() {
        return numeroDeDerrotas;
    }

    @Override
    public int getSaldoDeGols() {
        return saldoDeGols;
    }

    @Override
    public int getGolsPro() {
        return golsPro;
    }

    @Override
    public int getGolsContra() {
        return golsContra;
    }

    @Override
    public double getPercentualDeAproveitamento() {
        return percentualAproveitamento;
    }

    @Override
    public Time getTime() {
        return time;
    }
}
