package tests;

import campeonato.TimeNaTabela;
import org.junit.Before;
import org.junit.Test;
import partida.Partida;
import time.Time;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class TimeNaTabelaTest {
    private TimeNaTabela timeNaTabela;

    @Before
    public void criaTimeNaTabela() {
        Time timePrincipal = new Time("Real Madrid");
        Time timeAdicional1 = new Time("Barcelona");
        Time timeAdicional2 = new Time("Paysandu");

        ArrayList<Partida> partidas = new ArrayList<>();

        Partida partida1 = new Partida(timePrincipal, timeAdicional1);
        partida1.fezGols(timePrincipal, 10);
        partida1.fezGols(timeAdicional1, 3);

        Partida partida2 = new Partida(timePrincipal, timeAdicional2);
        partida2.fezGols(timePrincipal, 3);
        partida2.fezGols(timeAdicional2, 2);

        Partida partida3 = new Partida(timeAdicional1, timeAdicional2);
        partida3.fezGols(timeAdicional1, 29);
        partida3.fezGols(timeAdicional2, 4);

        partidas.add(partida1);
        partidas.add(partida2);
        partidas.add(partida3);

        timeNaTabela = new TimeNaTabela(timePrincipal, partidas);
    }

    @Test
    public void testaPontosTime() {
        assertEquals(6, timeNaTabela.getPontosTime());
    }

    @Test
    public void testaNumeroDeJogos() {
        assertEquals(2, timeNaTabela.getNumeroDeJogos());
    }

    @Test
    public void testaNumeroDeVitorias() {
        assertEquals(2, timeNaTabela.getNumeroDeVitorias());
    }

    @Test
    public void testaNumeroDeEmpates() {
        assertEquals(0, timeNaTabela.getNumeroDeEmpates());
    }

    @Test
    public void testaNumeroDeDerrotas() {
        assertEquals(0, timeNaTabela.getNumeroDeDerrotas());
    }

    @Test
    public void testaSaldoDeGols() {
        assertEquals(8, timeNaTabela.getSaldoDeGols());
    }

    @Test
    public void testaGolsPro() {
        assertEquals(13, timeNaTabela.getGolsPro());
    }

    @Test
    public void testaGolsContra() {
        assertEquals(5, timeNaTabela.getGolsContra());
    }

    @Test
    public void testaPercentualDeAproveitamento() {
        assertEquals(100, timeNaTabela.getPercentualDeAproveitamento(), 0.1);
    }
}
