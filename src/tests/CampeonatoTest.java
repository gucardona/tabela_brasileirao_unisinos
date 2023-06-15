package tests;

import campeonato.Campeonato;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import partida.Partida;
import time.Time;

import java.util.ArrayList;

public class CampeonatoTest {
    private Campeonato campeonato;

    @Before
    public void iniciaCampeonato() {
        campeonato = new Campeonato();
    }

    @Test
    public void adicionaTime() {
        Time time = new Time("Vasco");
        campeonato.adicionaTime(time);
        assertEquals(1, campeonato.getTimes().size());
    }

    @Test
    public void adicionaTimes() {
        Time gremio = new Time("Grêmio");
        Time internacional = new Time("Internacional");

        ArrayList<Time> times = new ArrayList<Time>();
        times.add(gremio);
        times.add(internacional);

        campeonato.adicionaTimes(times);

        assertEquals(2, campeonato.getTimes().size());
        assertEquals(gremio, campeonato.getTimes().get(0));
        assertEquals(internacional, campeonato.getTimes().get(1));
    }

    @Test
    public void adicionaPartida() {
        Time corinthians = new Time("Corinthians");
        Time saoPaulo = new Time("São Paulo");
        Partida partida = new Partida(corinthians, saoPaulo);

        campeonato.adicionaPartida(partida);

        assertEquals(0, campeonato.getTimes().size());
        assertEquals(1, campeonato.getPartidas().size());
        assertEquals(corinthians, campeonato.getPartidas().get(0).getTimeA().getTime());
        assertEquals(saoPaulo, campeonato.getPartidas().get(0).getTimeB().getTime());
    }

    @Test
    public void adicionaPartidas() {
        Time flamengo = new Time("Flamengo");
        Time paysandu = new Time("Paysandu");
        Time juventude = new Time("Juventude");
        Time barcelona = new Time("Barcelona");

        Partida partida1 = new Partida(flamengo, paysandu);
        Partida partida2 = new Partida(juventude, barcelona);
        Partida partida3 = new Partida(paysandu, juventude);
        Partida partida4 = new Partida(barcelona, flamengo);

        ArrayList<Partida> partidas = new ArrayList<Partida>();
        partidas.add(partida1);
        partidas.add(partida2);
        partidas.add(partida3);
        partidas.add(partida4);

       campeonato.adicionaPartidas(partidas);
       assertEquals(4, campeonato.getPartidas().size());
       assertEquals(paysandu, campeonato.getPartidas().get(0).getTimeB().getTime());
       assertEquals(0, campeonato.getPartidas().get(3).getGolsPro(barcelona));
    }

    @Test
    public void timeExisteNoCampeonato() {
        Time ypirange = new Time("Ypiranga");
        campeonato.adicionaTime(ypirange);
        assertEquals(true, campeonato.timeEstaNoCampeonato(ypirange));
        assertEquals(true, campeonato.timeEstaNoCampeonato("Ypiranga"));
    }
}
