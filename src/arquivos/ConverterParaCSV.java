package arquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import campeonato.InterfaceTimeNaTabela;
import campeonato.TabelaCampeonato;

public class ConverterParaCSV {
    public static String converterParaCSV(TabelaCampeonato tabela) {
        ArrayList<InterfaceTimeNaTabela> times = tabela.getTimesNaTabela();
        StringBuilder csvBuilder = new StringBuilder();

        csvBuilder.append("Nome,P,J,V,E,D,GP,GC,SG,AP%\n");

        for (InterfaceTimeNaTabela time : times) {
            csvBuilder.append(time.getNome()).append(",");
            csvBuilder.append(time.getPontosTime()).append(",");
            csvBuilder.append(time.getNumeroDeJogos()).append(",");
            csvBuilder.append(time.getNumeroDeVitorias()).append(",");
            csvBuilder.append(time.getNumeroDeEmpates()).append(",");
            csvBuilder.append(time.getNumeroDeDerrotas()).append(",");
            csvBuilder.append(time.getGolsPro()).append(",");
            csvBuilder.append(time.getGolsContra()).append(",");
            csvBuilder.append(time.getSaldoDeGols()).append(",");
            csvBuilder.append(time.getPercentualDeAproveitamento()).append("\n");
        }

        String tabelaCsv = csvBuilder.toString();

        FileWriter fw;
        try {
            fw = new FileWriter(".\\tabela.csv");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.print(tabelaCsv);
        pw.close();

        return csvBuilder.toString();
    }
}
