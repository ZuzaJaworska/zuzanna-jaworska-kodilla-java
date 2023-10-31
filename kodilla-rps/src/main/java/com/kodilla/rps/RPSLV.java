package com.kodilla.rps;

public class RPSLV {

    int roundCounter;
    int winCounter;
    int loseCounter;
    int tieCounter;
    String playersName;

    public RPSLV(int roundCounter, int winCounter, int loseCounter, int tieCounter) {
        this.roundCounter = roundCounter;
        this.winCounter = winCounter;
        this.loseCounter = loseCounter;
        this.tieCounter = tieCounter;
    }

    public void welcome() {
        System.out.println("""
                
                Welcome to the game "Rock, Paper, Scissors, Lizard, Spock"!"
                
                "What's your name?
                """);
    }
    public void printRules() {
        System.out.println("\nHi, " + playersName + "!\n");
        System.out.println("""
                The rules are simple:
                Scissors cuts Paper,
                Paper covers Rock,
                Rock crushes Lizard,
                Lizard poisons Spock,
                Spock smashes Scissors,
                Scissors decapitates Lizard,
                Lizard eats Paper,
                Paper disproves Spock,
                Spock vaporizes Rock,
                (and as it always has) Rock crushes Scissors.
                
                Choose your weapon by pressing a letter button:
                Rock = r, Paper = p, Scissors = s, Lizard = l or Spock = v.
                Computer will choose its weapon at the same time.
                
                Press "x" if you want to exit game.
                Press "n" if you want to reset the game and start over.
                """);
    }

    public void printScore() {
        roundCounter++;
        System.out.println("Round #" + roundCounter + " - score: Won: " + winCounter + " | " +
                "Lost: " + loseCounter + " | " +
                "Tie: " + tieCounter + "\n" +
                "----------\n");
    }

    public void wonRound() {
        System.out.println("You win this round!");
        winCounter++;
        printScore();
    }

    public void lostRound() {
        System.out.println("You lose this round");
        loseCounter++;
        printScore();
    }

    public void tieRound() {
        System.out.println("It's a tie!");
        tieCounter++;
        printScore();
    }

    public void restartGame() {
        roundCounter = 0;
        winCounter = 0;
        loseCounter = 0;
        tieCounter = 0;
        System.out.println("""
                Choose your weapon by pressing a letter button:
                Rock = r, Paper = p, Scissors = s, Lizard = l or Spock = v.
                Computer will choose its weapon at the same time.

                Press "x" if you want to exit game at any time.
                Press "n" if you want to reset the game and start over.
                """);
        System.out.println("How many won rounds will mean a victory?");
    }
    public String letterToName(String moveLetter) {
        switch (moveLetter) {
            case "r" -> {
                return "Rock";
            }
            case "p" -> {
                return "Paper";
            }
            case "s" -> {
                return "Scissors";
            }
            case "l" -> {
                return "Lizard";
            }
            case "v" -> {
                return "Spock";
            }
        }
        return moveLetter;
    }
}
