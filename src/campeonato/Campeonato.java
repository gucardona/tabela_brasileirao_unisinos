package campeonato;

import partida.Partida;
import time.Time;

import java.util.ArrayList;

public class Campeonato {
    private ArrayList<Time> times;
    private ArrayList<Partida> partidas;
    private TabelaCampeonato tabelaCampeonato;

    public Campeonato() {
        times = new ArrayList<Time>();
        partidas = new ArrayList<Partida>();
        tabelaCampeonato = new TabelaCampeonato(times, partidas);
    }

    public Campeonato(TabelaCampeonato tabelaCampeonato) {
        times = new ArrayList<Time>();
        partidas = new ArrayList<Partida>();
        this.tabelaCampeonato = tabelaCampeonato;
    }

    public boolean timeEstaNoCampeonato(Time time) {
        for (Time timeNoCampeonato : times)
            if (timeNoCampeonato.equals(time))
                return true;
        return false;
    }

    public boolean timeEstaNoCampeonato(String nomeTime) {
        for (int i = 0; i < times.size(); i++) {
            if (nomeTime.equalsIgnoreCase(times.get(i).getNome()))
                return true;
        }
        return false;
    }

    public void adicionaPartida(Partida partida) {
        partidas.add(partida);
    }

    public void adicionaPartidas(ArrayList<Partida> partidasNovas) {
        for (Partida partida : partidasNovas) {
            adicionaPartida(partida);
        }
    }

    public void adicionaTime(String nomeTime) {
        adicionaTime(new Time(nomeTime));
    }

    public void adicionaTime(Time time) {
        times.add(time);
    }

    public void adicionaTimes(ArrayList<Time> timesNovos) {
        for (Time time : timesNovos)
            adicionaTime(time);
    }
  
    public ArrayList<Time> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<Time> times) {
        this.times = times;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    public TabelaCampeonato getTabelaCampeonato() {
        tabelaCampeonato = new TabelaCampeonato(times, partidas);
        tabelaCampeonato.ordena();
        return tabelaCampeonato;
    }

    public Time getVencedor() {
        if (times == null || times.isEmpty())
            return null;

        TabelaCampeonato tabela = getTabelaCampeonato();
        TimeNaTabela vencedor = (TimeNaTabela) tabela.getTimesNaTabela().get(0);

        for (InterfaceTimeNaTabela timeNaTabela : tabela.getTimesNaTabela()) {
            if (vencedor.getPontosTime() < timeNaTabela.getPontosTime())
                vencedor = (TimeNaTabela) timeNaTabela;
        }

        return vencedor.getTime();
    }

    public void setTabelaCampeonato(TabelaCampeonato tabelaCampeonato) {
        this.tabelaCampeonato = tabelaCampeonato;
    }
}
