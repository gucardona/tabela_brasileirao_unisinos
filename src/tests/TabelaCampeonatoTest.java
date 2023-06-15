package tests;

import campeonato.Campeonato;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TabelaCampeonatoTest {
    private Campeonato campeonato; // a tabela está dentro do campeonato

    @Before
    public void iniciaCampeonato() {
        campeonato = CriaCampeonatoParaTests.criaCampeonato();
    }

    @Test
    public void verificaVencedor() {
        assertEquals("Fluminense", campeonato.getVencedor().getNome());
    }
}
