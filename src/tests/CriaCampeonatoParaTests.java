package tests;

import campeonato.Campeonato;
import partida.Partida;
import time.Time;

import java.util.ArrayList;

public class CriaCampeonatoParaTests {
    public static Campeonato criaCampeonato() {
        Campeonato campeonato = new Campeonato();

        Time fluminense = new Time("Fluminense");
        Time brasilDePelotas = new Time("Brasil de Pelotas");
        Time atleticoMineiro = new Time("Atlético Mineiro");
        Time chapecoense = new Time("Chapecoense");

        ArrayList<Time> times = new ArrayList<Time>();
        times.add(fluminense);
        times.add(brasilDePelotas);
        times.add(atleticoMineiro);
        times.add(chapecoense);

        Partida partida1 = new Partida(fluminense, brasilDePelotas);
        Partida partida2 = new Partida(fluminense, atleticoMineiro);
        Partida partida3 = new Partida(fluminense, chapecoense);
        Partida partida4 = new Partida(brasilDePelotas, atleticoMineiro);
        Partida partida5 = new Partida(brasilDePelotas, chapecoense);
        Partida partida6 = new Partida(atleticoMineiro, chapecoense);

        partida1.fezGols(fluminense, 3);
        partida1.fezGols(brasilDePelotas, 2);
        partida2.fezGol(fluminense);
        partida2.fezGol(atleticoMineiro);

        ArrayList<Partida> partidas = new ArrayList<Partida>();
        partidas.add(partida1);
        partidas.add(partida2);
        partidas.add(partida3);
        partidas.add(partida4);
        partidas.add(partida5);
        partidas.add(partida6);

        campeonato.adicionaTimes(times);
        campeonato.adicionaPartidas(partidas);

        return campeonato;
    }
}
