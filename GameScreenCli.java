public class GameScreenCli {
    protected static void printThanksForPlayingScreen() {

        printExplorerString("			Obrigado por ter jogado.");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    static void printExplorerString(String s) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(s);
    }

    static void printRules() {
        System.out.println("E simple, para ir ao sul, escreva: sul ; ");
        System.out.println("Para pegar macas, escreva: pegar maca ; ");
        System.out.println("Para atacar com o que estiver em sua mao direita, escreva: atacar direita ; ");
        System.out.println("Para comer (caso voce tenha comida), escreva: comer ; ");
        System.out.println("Para se livrar de algo (balde, por exemplo) , escreva: jogar balde;");
        System.out.println();
        System.out.println("Esta pronto? Precione enter!");
    }
}
