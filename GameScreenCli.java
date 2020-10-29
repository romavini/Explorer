public class GameScreenCli {

    protected static void printThanksForPlayingScreen() {

        // printExplorerString("			Obrigado por ter jogado.");
        printExplorerString("			"+Language.messages.getString("Obrigado_Ter_Jogado"));
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
        // System.out.println("E simple, para ir ao sul, escreva: sul ; ");
        System.out.println(Language.messages.getString("Para_Sul")+" ");
        System.out.println(Language.messages.getString("Para_Pegar_Maca")+" ");
        System.out.println(Language.messages.getString("Para_Atacar_Mao_Direita")+" ");
        System.out.println(Language.messages.getString("Para_Comer")+" ");
        System.out.println(Language.messages.getString("Para_Livrar_De_Algo"));
        System.out.println();
        System.out.println(Language.messages.getString("Esta_Pronto"));
    }
}
