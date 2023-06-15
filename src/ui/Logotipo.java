package ui;

public class Logotipo {
    public static final String AMARELO = "\u001B[33m";
    public static final String VERDE = "\u001B[32m";

    public static void imprime() {
        System.out.println(VERDE + "    ____  ____  ___   _____ ______    ______________  ___   ____     " + AMARELO + "___   ____ ___  _____");
        System.out.println(VERDE + "   / __ )/ __ \\/   | / ___//  _/ /   / ____/  _/ __ \\/   | / __ \\   "+ AMARELO +"|__ \\ / __ \\__ \\|__  /");
        System.out.println(VERDE + "  / __  / /_/ / /| | \\__ \\ / // /   / __/  / // /_/ / /| |/ / / /  "+ AMARELO +" __/ // / / /_/ / /_ <");
        System.out.println(VERDE + " / /_/ / _, _/ ___ |___/ // // /___/ /____/ // _, _/ ___ / /_/ /  "+ AMARELO +" / __// /_/ / __/___/ /");
        System.out.println(VERDE + "/_____/_/ |_/_/  |_/____/___/_____/_____/___/_/ |_/_/  |_\\____/   "+ AMARELO +"/____/\\____/____/____/");
    }
}
