package tests;

import arquivos.ConverterDeCSV;
import campeonato.Campeonato;
import campeonato.TabelaCampeonato;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class ConverterDeCSVTest {
    private String caminho;
    private String divisor;
    private TabelaCampeonato tabelaCampeonato, tabelaCampeonatoConvertida;

    @Before
    public void definePropriedades() {
        caminho = ".\\teste.csv";
        divisor = ",";

        Campeonato campeonato = CriaCampeonatoParaTests.criaCampeonato();
        tabelaCampeonato = campeonato.getTabelaCampeonato();

        Campeonato campeonatoConvertido = new Campeonato(ConverterDeCSV.converterDeCSV(caminho, divisor));
        tabelaCampeonatoConvertida = campeonatoConvertido.getTabelaCampeonato();
    }

    @Test
    public void testaConverterDeCSV() {
        for (int i = 0; i < tabelaCampeonatoConvertida.getTimesNaTabela().size(); i++)
            assertEquals(tabelaCampeonatoConvertida.getTimesNaTabela().get(i).getTime(),
                    tabelaCampeonato.getTimesNaTabela().get(i).getTime());

        for (int i = 0; i < tabelaCampeonatoConvertida.getTimesNaTabela().size(); i++)
            assertEquals(tabelaCampeonatoConvertida.getTimesNaTabela().get(i).getPercentualDeAproveitamento(),
                    tabelaCampeonato.getTimesNaTabela().get(i).getPercentualDeAproveitamento());

        for (int i = 0; i < tabelaCampeonatoConvertida.getTimesNaTabela().size(); i++)
            assertEquals(tabelaCampeonatoConvertida.getTimesNaTabela().get(i).getPontosTime(),
                    tabelaCampeonato.getTimesNaTabela().get(i).getPontosTime());
    }
}
