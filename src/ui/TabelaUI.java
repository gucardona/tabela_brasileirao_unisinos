package ui;

import campeonato.Campeonato;
import campeonato.InterfaceTimeNaTabela;
import campeonato.TabelaCampeonato;

public class TabelaUI {

    public static void mostrarTabela(Campeonato campeonato) {
        mostrarTabela(campeonato.getTabelaCampeonato());
    }

    public static void mostrarTabela(TabelaCampeonato tabelaCampeonato) {

        System.out.println("+============================================================================================+");

        System.out.printf("|%29s %5s %5s %5s %5s %5s %5s %5s %5s %8s %6s", "|", "P", "J", "V", "E", "D", "GP", "GC", "SG", "AP%", "|");
        System.out.print("\n+============================================================================================+");
        System.out.printf("\n|%92s|", " ");
        System.out.print("\n|--------------------------------------------------------------------------------------------|");

        double num = 0;

        for (InterfaceTimeNaTabela timeNaTabela : tabelaCampeonato.getTimesNaTabela()) {

            if (timeNaTabela.getPercentualDeAproveitamento() == 0)
                num = 5;
            if (timeNaTabela.getPercentualDeAproveitamento() > 9 && timeNaTabela.getPercentualDeAproveitamento() < 99)
                num = 4;
            if (timeNaTabela.getPercentualDeAproveitamento() == 100)
                num = 3;

            System.out.printf("\n|\t%-25s| %5s %5s %5s %5s %5s %5s %5s %5s %"+num+"s %.1f %5s\n",
                    timeNaTabela.getNome(),
                    timeNaTabela.getPontosTime(),
                    timeNaTabela.getNumeroDeJogos(),
                    timeNaTabela.getNumeroDeVitorias(),
                    timeNaTabela.getNumeroDeEmpates(),
                    timeNaTabela.getNumeroDeDerrotas(),
                    timeNaTabela.getGolsPro(),
                    timeNaTabela.getGolsContra(),
                    timeNaTabela.getSaldoDeGols(),
                    " ",
                    timeNaTabela.getPercentualDeAproveitamento(),
                    "|");
            System.out.print("|--------------------------------------------------------------------------------------------|");
        }

        System.out.printf("\n|%92s|", " ");
        System.out.println("\n+============================================================================================+");
    }
}
