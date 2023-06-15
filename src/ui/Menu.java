package ui;

import arquivos.ConverterDeCSV;
import arquivos.ConverterParaCSV;
import campeonato.Campeonato;
import operacoes.Operacoes;
import teclado.Teclado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void menuInicial() {
        espacos();
        Logotipo.imprime();
        System.out.println("+===========================================+");
        System.out.printf("|\t(1) Registrar nova tabela            \t|\n");
        System.out.printf("|\t(2) Exibir tabela salva anteriormente\t|\n");
        System.out.printf("|\t                                     \t|\n");
        System.out.printf("|\t(0) Fechar o programa                \t|\n");
        System.out.println("+===========================================+");
        System.out.println();

        Campeonato campeonato = new Campeonato();

        int escolha = Teclado.leInt("Escolha uma das opções do menu: ");

        switch (escolha) {
            case 1:
                espacos();
                menuOperacoes(campeonato);
                break;

            case 2:
                espacos();
                ConverterDeCSV.converterDeCSV(Teclado.leString("Digite o nome do arquivo com o .csv após: "),
                        Teclado.leString("Qual foi o divisor utilizado? (, ou / ou ; etc)"));
                System.out.println();
                System.out.println("Digite qualquer coisa para voltar ao menu inicial: ");
                new Scanner(System.in).nextLine();
                menuInicial();
                break;

            case 0:
                System.out.println();
                System.out.println("Fechando o programa...");
                System.exit(0);

            default:
                throw new InputMismatchException();
        }
    }

    public static void menuOperacoes(Campeonato campeonato) {

        System.out.println("+===========================+");
        System.out.printf("|\t(1) Adicionar time   \t|\n");
        System.out.printf("|\t(2) Registrar partida\t|\n");
        System.out.printf("|\t(3) Mostrar tabela   \t|\n");
        System.out.printf("|\t                     \t|\n");
        System.out.printf("|\t(0) Sair             \t|\n");
        System.out.println("+===========================+");
        System.out.println();
        int escolha = Teclado.leInt("Escolha uma das opções do menu: ");

        switch (escolha) {
            case 1:
                Operacoes.adicionarTime(campeonato);
                voltarAoMenu(campeonato);
                break;

            case 2:
                Operacoes.registrarPartida(campeonato);
                voltarAoMenu(campeonato);
                break;

            case 3:
                TabelaUI.mostrarTabela(campeonato);
                voltarAoMenu(campeonato);
                break;

            case 0:
                salvarOuNao(campeonato);
                break;
            default:
                throw new InputMismatchException();
        }
    }

    public static void voltarAoMenu(Campeonato campeonato) {
        System.out.println();

        char escolha = Teclado.leChar("Deseja voltar ao menu? (S/N)");
        escolha = Character.toUpperCase(escolha);

        switch (escolha) {
            case 'S':
                espacos();
                menuOperacoes(campeonato);
                break;

            case 'N':
                salvarOuNao(campeonato);
                break;

            default:
                throw new InputMismatchException();
        }
    }

    public static void salvarOuNao(Campeonato campeonato) {
        System.out.println();
        char salvar = Teclado.leChar("Deseja salvar a tabela atual antes de sair? (S/N)");
        salvar = Character.toUpperCase(salvar);

        System.out.println();
        switch (salvar) {
            case 'S':
                System.out.println("Ok! Salvando...");
                ConverterParaCSV.converterParaCSV(campeonato.getTabelaCampeonato());
                menuInicial();
                break;

            case 'N':
                System.out.println("Ok! Saindo...");
                menuInicial();
                break;

            default:
                throw new InputMismatchException();
        }
    }

    public static void espacos() {
        for (int i = 0; i < 50; i++)
            System.out.println();
    }
}
