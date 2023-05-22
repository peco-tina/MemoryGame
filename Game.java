package MemoryGame;

import java.util.Scanner;

public class Game {
    Board board = new Board();
    Scanner sc = new Scanner(System.in);
    boolean isGameFinished = false;
    int numberOfFailures = 0;
    int numberOfSlotsTurnedUp = 0;

    public void startGame(){
        board.createSlots();
        playGame();
    }

    private void playGame() {
        while(!isGameFinished){
            Slot firstSlot = chooseSlot();
            Slot secondSlot = chooseSlot();
            if(!isSlotsEqual(firstSlot, secondSlot)){
                numberOfFailures++;
                System.out.println("Those two are not equal. Try again!");
                setBackSlots(firstSlot, secondSlot);
            } else {
                numberOfSlotsTurnedUp+=2;
                if(checkIfWon()){
                    System.out.println("You won the game!");
                    board.printBoard();
                    System.exit(0);
                }
            }
            if(lostGame()){
                System.out.println("You lost the game");
                System.exit(0);
            }
        }
    }

    private Slot chooseSlot() {
        boolean slotChoosen = false;
        while(!slotChoosen){
            board.printBoard();
            printMessage();
            String choice = sc.next();
            if(validateChoice(choice)){
                if(!isSlotUp(choice)){
                    board.getSlot(choice).setShouldBeUp(true);
                    return board.getSlot(choice);
                } else {
                    System.out.println("That slot is already up! Choose another one!");
                    board.printBoard();
                }
            } else {
                System.out.println("Your choice in not valid! Write like A1, A2 etc...");
            }
        }
        return null;
    }

    private boolean validateChoice(String choice) {
        for(int i = 0; i < board.getPositions().length; i++){
            if(board.getPositions()[i].equals(choice)){
                return true;
            }
        }
        return false;
    }

    private void setBackSlots(Slot firstSlot, Slot secondSlot) {
        firstSlot.setShouldBeUp(false);
        secondSlot.setShouldBeUp(false);
    }

    private boolean isSlotsEqual(Slot firstSlot, Slot secondSlot) {
        return firstSlot.getValueForSlot().equals(secondSlot.getValueForSlot());
    }

    private boolean isSlotUp(String choice) {
        for(Slot slot : board.slots){
            if(slot.getPosition().equals(choice)){
                return slot.isShouldBeUp();
            }
        }
        return false;
    }

    private void printMessage(){
        System.out.println("Your choice should be like A1, A2 etc...");
    }

    private boolean lostGame() {
        return numberOfFailures == 7;
    }

    private boolean checkIfWon() {
        return numberOfSlotsTurnedUp == 16;
    }
}
