import java.util.InputMismatchException;
import java.util.Scanner;

public class Mastermind {
    int nbtour = 10;
    int choix1 = 0;
    int choix2 = 0;
    Jeux jeux = new Jeux();
    Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        Mastermind mastermind = new Mastermind();
        mastermind.menu1();
    }

    int menu1() {

        Mastermind mastermind = new Mastermind();
        System.out.println("Avec quel style de jeux voulez-vous jouer?");
        System.out.println(" - 1 - Recherche +/- ");
        System.out.println(" - 2 - Mastermind ");
        try {
            choix1 = clavier.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Votre saisie erronée");
            return mastermind.menu1();
        }
        if (choix1 > 0 && choix1 <= 2) {
            System.out.println("Avec quel mode de jeu voulez-vous jouer?");
            System.out.println(" - 1 - Challenger ");
            System.out.println(" - 2 - Défenseur ");
            System.out.println(" - 3 - Duel");
            try {
                choix2 = clavier.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Votre saisie est erronée");
                return mastermind.menu1();
            }
        } else {
            System.out.println("Vous n'avez pas choisi parmis les modes de jeux proposés");
            return menu1();
        }

        if (choix2 > 0 && choix2 <= 3) {
            if (choix1 == 1 && choix2 == 1) {
                mastermind.chalengerRecherche();
            }
            if (choix1 == 1 && choix2 == 2) {
                mastermind.defenseurRecherche();
            }
            if (choix1 == 1 && choix2 == 3) {
                mastermind.duelRecherche();
            }
            if (choix1 == 2 && choix2 == 1) {
                mastermind.challengerMastermind();
            }
            if (choix1 == 2 && choix2 == 2) {
                mastermind.defenseurMastermind();
            }
            if (choix1 == 2 && choix2 == 3) {
                mastermind.duelMastermind();
            }
        } else {
            System.out.println("Vous n'avez pas choisi parmis les modes de jeux proposés");
            return mastermind.menu1();
        }
        return menu1();
    }


    void chalengerRecherche() {
        Mastermind mastermind = new Mastermind();
        jeux.combinaisonAleatoire();
        for (int i = 1; i <= nbtour; i++) {
            jeux.combinaisonManuel();
            jeux.comparaison(true, false);
        }
        System.out.print("Vous avez perdu le code secret était : "+jeux.kstring);
        System.out.println(" ");
        mastermind.finDeCycle(1);
    }

    void defenseurRecherche() {
        Mastermind mastermind = new Mastermind();
        jeux.ordinateur(true, true,false);
        for (int i = 1; i <= nbtour; i++) {
        jeux.ordinateur(false, true,false);
        }
        System.out.println("Vous avez gagné!");
        System.out.println(" ");
        mastermind.finDeCycle(2);
    }

    void duelRecherche() {
        Mastermind mastermind = new Mastermind();
        jeux.ordinateur(true, true,true);
        jeux.combinaisonAleatoire();
        for (int j = 1; j <= nbtour; j++) {
            jeux.ordinateur(false, true,true);
            jeux.combinaisonManuel();
            jeux.comparaison(true, true);
        }
        System.out.print("Vous n'avez pas pu vous départager et le code secret de l'ordinateur était: "+jeux.kstring);
        System.out.println(" ");
        mastermind.finDeCycle(3);
    }

    void challengerMastermind() {
        Mastermind mastermind = new Mastermind();
        jeux.combinaisonAleatoire();
        for (int i = 1; i <= nbtour; i++) {
            jeux.combinaisonManuel();
            jeux.comparaison(false, false);
        }
        System.out.print("Vous avez perdu le code secret était : "+jeux.kstring);
        System.out.println(" ");
        mastermind.finDeCycle(4);
    }

    void defenseurMastermind() {

        Mastermind mastermind = new Mastermind();
        jeux.ordinateur(true, false,false);
        for (int i = 1; i <= nbtour; i++) {
            jeux.ordinateur(false, false,false);
        }
        System.out.println("Vous avez gagné!");
        System.out.println(" ");
        mastermind.finDeCycle(5);
    }

    void duelMastermind() {
        Mastermind mastermind = new Mastermind();
        jeux.ordinateur(true, false,true);
        jeux.combinaisonAleatoire();
        for (int j = 1; j <= nbtour; j++) {
            jeux.ordinateur(false, false,true);
            jeux.combinaisonManuel();
            jeux.comparaison(false, true);
        }
        System.out.print("Vous n'avez pas pu vous départager et le code secret de l'ordinateur était: "+jeux.kstring);
        System.out.println(" ");
        mastermind.finDeCycle(6);
    }


    void finDeCycle(int choixDuJeu) {
        Mastermind mastermind = new Mastermind();
        int choixmenu = 0;

        System.out.println("Que voulez vous faire? :");
        System.out.println(" ");
        System.out.println("- 1 - Rejouer au même jeu");
        System.out.println("- 2 - Jouer à un autre jeu");
        System.out.println("- 3 - Quitter le jeu");
        try {
            choixmenu = clavier.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Votre saisie erronée");
            mastermind.finDeCycle(choixDuJeu = choixDuJeu);
        }
        if (choixmenu == 1) {
            if (choixDuJeu == 1) {
                chalengerRecherche();
            }
            if (choixDuJeu == 2) {
                defenseurRecherche();
            }
            if (choixDuJeu == 3) {
                duelRecherche();
            }
            if (choixDuJeu == 4) {
                challengerMastermind();
            }
            if (choixDuJeu == 5) {
                defenseurMastermind();
            }
            if (choixDuJeu == 6) {
                duelMastermind();
            }
        }
        if (choixmenu == 2) {
            mastermind.menu1();
        }

        if (choixmenu == 3) {
            System.out.println("Fin du jeu ");
            System.exit(0);
        } else {
            System.out.println("Vous n'avez pas choisi parmis les choix proposés");
            mastermind.finDeCycle(choixDuJeu = choixDuJeu);
        }
    }
}



