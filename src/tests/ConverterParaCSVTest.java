package tests;

import arquivos.ConverterParaCSV;
import campeonato.Campeonato;
import campeonato.TabelaCampeonato;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterParaCSVTest {
    private TabelaCampeonato tabelaCampeonato; // O conversor precisa de uma tabela para converter

    @Before
    public void criaTabelaCampeonato() {
        Campeonato campeonato = CriaCampeonatoParaTests.criaCampeonato();
        tabelaCampeonato = campeonato.getTabelaCampeonato();
    }

    @Test
    public void testaConverterParaCSV() {
        String tabelaPrevista =
                ("Nome,P,J,V,E,D,GP,GC,SG,AP%\n" +
                "Fluminense,5,3,1,2,0,4,3,1,55.55555555555556\n" +
                "Atlético Mineiro,3,3,0,3,0,1,1,0,33.33333333333333\n" +
                "Chapecoense,3,3,0,3,0,0,0,0,33.33333333333333\n" +
                "Brasil de Pelotas,2,3,0,2,1,2,3,-1,22.22222222222222\n");
        assertEquals(tabelaPrevista, ConverterParaCSV.converterParaCSV(tabelaCampeonato));
    }
}
