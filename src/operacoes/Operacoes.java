package operacoes;

import campeonato.Campeonato;
import partida.Partida;
import partida.TimeNaPartida;
import teclado.Teclado;
import time.Time;
import ui.Menu;

import java.util.ArrayList;

public class Operacoes {

    public static void adicionarTime(Campeonato campeonato) {
        Menu.espacos();

        int quantidade = Teclado.leInt("Quantos times deseja adicionar? ");
        System.out.println();

        ArrayList<Time> times = new ArrayList<>();
        ArrayList<Partida> partidas = new ArrayList<>();

        int i = 0;
        do {
            System.out.println();
            String nome = Teclado.leString("Qual o nome do time que deseja adicionar? ");

            for (Time time : times) {
                while (time.getNome().equalsIgnoreCase(nome)) {
                    System.out.println();
                    System.out.println("Time já adicionado... Tente novamente!");
                    nome = Teclado.leString("Qual o nome do novo time que deseja adicionar? ");
                }
            }
            System.out.println("Time adicionado!");

            Time time = new Time(nome);
            times.add(time);
            i++;
        } while (i < quantidade);

        campeonato.adicionaTimes(times);
        campeonato.adicionaPartidas(partidas);


    }

    public static void registrarPartida(Campeonato campeonato) {
        Menu.espacos();

        if (campeonato.getTimes().size() < 2) {
            System.out.println("Impossível registrar partida com apenas um time cadastrado...");
            Menu.voltarAoMenu(campeonato);
        }

        int quantidade = Teclado.leInt("Quantas partidas deseja registrar? ");
        System.out.println();

        ArrayList<Partida> partidas = new ArrayList<>();

        int i = 0;
        do {
            System.out.println();

            Time time1Partida = null;
            int golsTime1 = 0;

            String time1 = Teclado.leString("Digite o nome do primeiro time: ");
            while (!(campeonato.timeEstaNoCampeonato(time1)))
                time1 = Teclado.leString(time1 + " não está no campeonato, digite um novo time: ");

            for (int j = 0; j < campeonato.getTimes().size(); j++)
                if (campeonato.getTimes().get(j).getNome().equalsIgnoreCase(time1))
                    time1Partida = campeonato.getTimes().get(j);
            golsTime1 = Teclado.leInt("Quantidade de gols do primeiro time: ");

            Time time2Partida = null;
            int golsTime2 = 0;

            String time2 = Teclado.leString("Digite o nome do segundo time: ");
            while (!(campeonato.timeEstaNoCampeonato(time2)))
                time2 = Teclado.leString(time2 + " não está no campeonato, digite um novo time: ");

            for (int k = 0; k < campeonato.getTimes().size(); k++)
                if (campeonato.getTimes().get(k).getNome().equalsIgnoreCase(time2))
                    time2Partida = campeonato.getTimes().get(k);
            golsTime2 = Teclado.leInt("Quantidade de gols do segundo time: ");

            Partida partida = new Partida(new TimeNaPartida(time1Partida, golsTime1),
                    new TimeNaPartida(time2Partida, golsTime2));
            partidas.add(partida);
            System.out.println("Partida adicionada!");
            System.out.println();

            i++;
        } while (i < quantidade);

        campeonato.adicionaPartidas(partidas);
    }
}
