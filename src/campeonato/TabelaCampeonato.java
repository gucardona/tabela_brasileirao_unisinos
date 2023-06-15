package campeonato;

import partida.Partida;
import time.Time;

import java.util.ArrayList;
import java.util.Comparator;

public class TabelaCampeonato {
    private ArrayList<InterfaceTimeNaTabela> timesNaTabela;

    public TabelaCampeonato(ArrayList<Time> times, ArrayList<Partida> partidas) {
        timesNaTabela = new ArrayList<InterfaceTimeNaTabela>();
        for (Time time : times)
            timesNaTabela.add(new TimeNaTabela(time, partidas));
    }

    public TabelaCampeonato(ArrayList<InterfaceTimeNaTabela> timesNaTabela) {
        this.timesNaTabela = timesNaTabela;
    }

    public InterfaceTimeNaTabela getTimeNaTabela(Time time) {
        for (InterfaceTimeNaTabela timeNaTabela : timesNaTabela)
            if (timeNaTabela.getTime().equals(time))
                return timeNaTabela;
        return null;
    }

    public ArrayList<InterfaceTimeNaTabela> getTimesNaTabela() {
        return timesNaTabela;
    }

    public void ordena() {
        timesNaTabela.sort(Comparator.comparing(InterfaceTimeNaTabela::getPontosTime).reversed());
    }

    @Override
    public String toString() {
        return null;
    }
}
