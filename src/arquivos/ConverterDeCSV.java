package arquivos;

import campeonato.InterfaceTimeNaTabela;
import campeonato.TabelaCampeonato;
import campeonato.TimeNaTabelaCSV;
import time.Time;
import ui.TabelaUI;

import java.io.*;
import java.util.ArrayList;

public class ConverterDeCSV {
    public static TabelaCampeonato converterDeCSV(String path, String divisor) {
        File file = new File(path);
        String linha;

        ArrayList<InterfaceTimeNaTabela> timesNaTabela;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            timesNaTabela = new ArrayList<InterfaceTimeNaTabela>();
            bufferedReader.readLine();
            while (bufferedReader != null && (linha = bufferedReader.readLine()) != null) {
                String[] campos = linha.split(divisor);
                Time time = new Time(campos[0]);
                TimeNaTabelaCSV timeNaTabelaCSV = new TimeNaTabelaCSV(
                    time,
                    Integer.parseInt(campos[1]),
                    Integer.parseInt(campos[2]),
                    Integer.parseInt(campos[3]),
                    Integer.parseInt(campos[4]),
                    Integer.parseInt(campos[5]),
                    Integer.parseInt(campos[6]),
                    Integer.parseInt(campos[7]),
                    Integer.parseInt(campos[8]),
                    Double.parseDouble(campos[9])
                );
                timesNaTabela.add(timeNaTabelaCSV);
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }

        TabelaUI.mostrarTabela(new TabelaCampeonato(timesNaTabela));
        return new TabelaCampeonato(timesNaTabela);
    }
}
