package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {

        RPSLV theGame = new RPSLV(0, 0, 0, 0);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"r", "p", "s", "l", "v"};

        String computerMove;
        String playerMove = "";
        boolean exitGame = false;
        boolean exitNow = false;
        int ceilingScore;

        //welcome + player's name scanner
        theGame.welcome();
        theGame.playersName = scanner.nextLine();

        //rules
        theGame.printRules();

        //how many won rounds will mean a victory
        System.out.println("How many won rounds will mean a victory? (enter number)");
        ceilingScore = scanner.nextInt();

        while (!exitGame) {
            while (ceilingScore > theGame.winCounter && ceilingScore > theGame.loseCounter && !exitNow) {

                //making a move
                while (true) {
                    System.out.println("----------" +
                            "\nPlay: Rock = r, Paper = p, Scissors = s, Lizard = l, Spock = v");
                    playerMove = scanner.next();
                    computerMove = moves[random.nextInt(moves.length)];

                    if (playerMove.equals("r") || playerMove.equals("p") || playerMove.equals("s")
                            || playerMove.equals("l") || playerMove.equals("v")) {
                        System.out.println("You: " + theGame.letterToName(playerMove)
                                + " - Computer: " + theGame.letterToName(computerMove));
                        break;

                    } else if (playerMove.equals("x") || playerMove.equals("n")) {
                        break;

                    } else {
                        System.out.println(playerMove + " is not a valid move.\n" +
                                "Please choose the correct button.");
                    }
                }

                //action for player's move
                if (playerMove.equals(computerMove)) {
                    theGame.tieRound();

                } else if (playerMove.equals("r")) {
                    switch (computerMove) {
                        case "p" -> {
                            System.out.println("Paper covers Rock");
                            theGame.lostRound();
                        }
                        case "s" -> {
                            System.out.println("Rock crushes Scissors");
                            theGame.wonRound();
                        }
                        case "l" -> {
                            System.out.println("Rock crushes Lizard");
                            theGame.wonRound();
                        }
                        case "v" -> {
                            System.out.println("Spock vaporizes Rock");
                            theGame.lostRound();
                        }
                    }

                } else if (playerMove.equals("p")) {
                    switch (computerMove) {
                        case "r" -> {
                            System.out.println("Paper covers Rock");
                            theGame.wonRound();
                        }
                        case "s" -> {
                            System.out.println("Scissors cuts Paper");
                            theGame.lostRound();
                        }
                        case "l" -> {
                            System.out.println("Lizard eats Paper");
                            theGame.lostRound();
                        }
                        case "v" -> {
                            System.out.println("Paper disproves Spock");
                            theGame.wonRound();
                        }
                    }

                } else if (playerMove.equals("s")) {
                    switch (computerMove) {
                        case "r" -> {
                            System.out.println("Rock crushes Scissors");
                            theGame.lostRound();
                        }
                        case "p" -> {
                            System.out.println("Scissors cuts Paper");
                            theGame.wonRound();
                        }
                        case "l" -> {
                            System.out.println("Scissors decapitates Lizard");
                            theGame.wonRound();
                        }
                        case "v" -> {
                            System.out.println("Spock smashes Scissors");
                            theGame.lostRound();
                        }
                    }

                } else if (playerMove.equals("l")) {
                    switch (computerMove) {
                        case "r" -> {
                            System.out.println("Rock crushes Lizard");
                            theGame.lostRound();
                        }
                        case "p" -> {
                            System.out.println("Lizard eats Paper");
                            theGame.wonRound();
                        }
                        case "s" -> {
                            System.out.println("Scissors decapitates Lizard");
                            theGame.lostRound();
                        }
                        case "v" -> {
                            System.out.println("Lizard poisons Spock");
                            theGame.wonRound();
                        }
                    }

                } else if (playerMove.equals("v")) {
                    switch (computerMove) {
                        case "r" -> {
                            System.out.println("Spock vaporizes Rock");
                            theGame.wonRound();
                        }
                        case "p" -> {
                            System.out.println("Paper disproves Spock");
                            theGame.lostRound();
                        }
                        case "s" -> {
                            System.out.println("Spock smashes Scissors");
                            theGame.wonRound();
                        }
                        case "l" -> {
                            System.out.println("Lizard poisons Spock");
                            theGame.lostRound();
                        }
                    }

                } else if (playerMove.equals("x")) {
                    System.out.println("""
                            If you are sure to exit the game press "y".
                            To continue the game press any other button.
                            """);
                    String exitSure = scanner.next();
                    if (exitSure.equals("y")) {
                        exitNow = true;
                        exitGame = true;
                    }

                } else if (playerMove.equals("n")) {
                    System.out.println("""
                            If you are sure to reset the game press "y".
                            To continue the game press any other button.
                            """);
                    String resetSure = scanner.next();
                    if (resetSure.equals("y")) {
                        System.out.println("--------------------" +
                                "\nThe game has been restarted.\n");
                        theGame.restartGame();
                        ceilingScore = scanner.nextInt();
                    }
                }
            }

            if (theGame.winCounter == ceilingScore) {
                System.out.println("Congratulations, " + theGame.playersName + "! You won the game!");

            } else if (theGame.loseCounter == ceilingScore) {
                System.out.println("Sorry, " + theGame.playersName + ". You lost the game.\n\n");
            }


            System.out.println("""
                    To play again press "n".
                    Press any other button to exit application.
                    """);
            String anotherGame = scanner.next();
            if (anotherGame.equals("n")) {
                System.out.println("""
                        --------------------
                        "Welcome to the new game!
                        """);
                theGame.restartGame();
                ceilingScore = scanner.nextInt();
            } else {
                exitGame = true;
            }
        }

        System.out.println("Thank you for playing! Goodbye!");
    }
}
