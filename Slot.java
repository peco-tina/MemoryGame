package MemoryGame;

public class Slot {
    String position;
    String letter;
    boolean shouldBeUp = false;
    String questionMark = "?";

    public String getValueForSlot(){
        if(shouldBeUp){
            return letter;
        } else {
            return questionMark;
        }
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public boolean isShouldBeUp() {
        return shouldBeUp;
    }

    public void setShouldBeUp(boolean shouldBeUp) {
        this.shouldBeUp = shouldBeUp;
    }
}
