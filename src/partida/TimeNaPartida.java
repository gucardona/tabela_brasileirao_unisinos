package partida;

import time.Time;

public class TimeNaPartida {
    Time time;
    int golsPro;
    
    public TimeNaPartida(Time time, int golsPro) {
        this.time = time;
        this.golsPro = golsPro;
    }

    public TimeNaPartida(Time time) {
        this.time = time;
        this.golsPro = 0;
    }

    public void fezGol() {
        golsPro++;
    }

    public void anulouGol() {
        golsPro--;
    }

    public void fezGols(int quantidade) {
        golsPro += quantidade;
    }

    public void anulouGols(int quantidade) {
        golsPro -= quantidade;
    }

    public Time getTime() {
        return time;
    }
    public void setTime(Time time) {
        this.time = time;
    }
    public int getGolsPro() {
        return golsPro;
    }
    public void setGolsPro(int golsPro) {
        this.golsPro = golsPro;
    }
}
