package campeonato;

import partida.Partida;
import time.Time;
import java.util.ArrayList;

public class TimeNaTabela implements InterfaceTimeNaTabela {
    private Time time;
    private final ArrayList<Partida> partidasQueTimeJogou;

    public TimeNaTabela(Time time, ArrayList<Partida> partidas) {
        this.time = time;
        this.partidasQueTimeJogou = getPartidasQueTimeJogou(time, partidas);
    }

    private ArrayList<Partida> getPartidasQueTimeJogou(Time time, ArrayList<Partida> partidas) {
        ArrayList<Partida> resultado = new ArrayList<>();
        for (Partida partida : partidas)
            if (partida.timeEstaNaPartida(time))
                resultado.add(partida);
        return resultado;
    }

    public String getNome() {
        return time.getNome();
    }

    public int getPontosTime() {
        int pontuacao = 0;
        for (Partida partida : partidasQueTimeJogou) {
            if (partida.getPontuacaoTime(time) < 0)
                throw new RuntimeException();
            pontuacao += partida.getPontuacaoTime(time);
        }
        return pontuacao;
    }

    public int getNumeroDeJogos() {
        return partidasQueTimeJogou.size();
    }

    public int getNumeroDeVitorias() {
        int numeroDeVitorias = 0;
        for (Partida partida : partidasQueTimeJogou)
            if (time.equals(partida.getVencedor()))
                numeroDeVitorias++;
        return numeroDeVitorias;
    }

    public int getNumeroDeEmpates() {
        int numeroDeEmpates = 0;
        for (Partida partida : partidasQueTimeJogou)
            if (partida.getVencedor() == null)
                numeroDeEmpates++;
        return numeroDeEmpates;
    }

    public int getNumeroDeDerrotas() {
        int numeroDeDerrotas = 0;
        for (Partida partida : partidasQueTimeJogou) {
            Time vencedor = partida.getVencedor();
            if (!time.equals(vencedor) && vencedor != null)
                numeroDeDerrotas++;
        }
        return numeroDeDerrotas;
    }

    public int getSaldoDeGols() {
        int saldoDeGols = 0;
        for (Partida partida : partidasQueTimeJogou)
            saldoDeGols += partida.getSaldoDeGolsTime(time);
        return saldoDeGols;
    }

    public int getGolsPro() {
        int golsPro = 0;
        for (Partida partida : partidasQueTimeJogou)
            golsPro += partida.getGolsPro(time);
        return golsPro;
    }

    public int getGolsContra() {
        int golsContra = 0;
        for (Partida partida : partidasQueTimeJogou) {
            golsContra += partida.getGolsContraTime(time);
        }
        return golsContra;
    }
    
    public double getPercentualDeAproveitamento() {
        double pontuacaoPossivel = partidasQueTimeJogou.size() * 3.0;
        double pontuacaoRealizada = getPontosTime();
        return (pontuacaoRealizada / pontuacaoPossivel * 100.0);
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
