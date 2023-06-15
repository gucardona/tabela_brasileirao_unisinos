package partida;

import time.Time;

public class Partida {
    TimeNaPartida timeA;
    TimeNaPartida timeB;

    public Partida(TimeNaPartida timeA, TimeNaPartida timeB) {
        this.timeA = timeA;
        this.timeB = timeB;
    }

    public Partida(Time timeA, Time timeB) {
        this.timeA = new TimeNaPartida(timeA);
        this.timeB = new TimeNaPartida(timeB);
    }

    public void fezGol(Time time) {
        if (time.equals(timeA.getTime())) {
            timeA.fezGol();
            return;
        }
        timeB.fezGol();
    }

    public void fezGols(Time time, int quantidade) {
        if (time.equals(timeA.getTime())) {
            timeA.fezGols(quantidade);
            return;
        }
        timeB.fezGols(quantidade);
    }

    public int getGolsPro(Time time) {
        if (time.equals(timeA.getTime()))
            return timeA.getGolsPro();
        return timeB.getGolsPro();
    }

    public boolean timeEstaNaPartida(Time time) {
        return timeA.getTime().equals(time) || timeB.getTime().equals(time);
    }

    public int getSaldoDeGolsTime(Time time) {
        if (time.equals(timeA.getTime()))
            return getSaldoDeGolsTimeA();
        return getSaldoDeGolsTimeB();
    }

    public int getSaldoDeGolsTimeA() {
        return (timeA.getGolsPro() - timeB.getGolsPro());
    }

    public int getSaldoDeGolsTimeB() {
        return (timeB.getGolsPro() - timeA.getGolsPro());
    }

    public int getGolsContraTime(Time time) {
        if(timeA.getTime().equals(time))
            return timeB.getGolsPro();
        return timeA.getGolsPro();
    }

    public int getPontuacaoTime(Time time) {
        if (timeA.getTime().equals(time))
            return getPontuacaoTimeA();
        if (timeB.getTime().equals(time))
            return getPontuacaoTimeB();
        return 0;
    }

    public int getPontuacaoTimeA() {
        Time vencedor = getVencedor();
        if (vencedor == timeA.getTime())
            return 3;
        if (vencedor == null)
            return 1;
        return 0;
    }

    public int getPontuacaoTimeB() {
        Time vencedor = getVencedor();
        if (vencedor == timeB.getTime())
            return 3;
        if (vencedor == null)
            return 1;
        return 0;
    }

    public Time getVencedor() {
        if (getSaldoDeGolsTimeA() > getSaldoDeGolsTimeB())
            return timeA.getTime();
        else if (getSaldoDeGolsTimeA() < getSaldoDeGolsTimeB())
            return timeB.getTime();
        return null;
    }

    public TimeNaPartida getTimeA() {
        return timeA;
    }

    public void setTimeA(TimeNaPartida timeA) {
        this.timeA = timeA;
    }

    public TimeNaPartida getTimeB() {
        return timeB;
    }

    public void setTimeB(TimeNaPartida timeB) {
        this.timeB = timeB;
    }
}
