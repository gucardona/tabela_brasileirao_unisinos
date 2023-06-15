package campeonato;

import time.Time;

public interface InterfaceTimeNaTabela {
    String getNome();

    int getPontosTime();

    int getNumeroDeJogos();

    int getNumeroDeVitorias();

    int getNumeroDeEmpates();

    int getNumeroDeDerrotas();

    int getSaldoDeGols();

    int getGolsPro();

    int getGolsContra();

    double getPercentualDeAproveitamento();

    Time getTime();
}
