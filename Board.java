package MemoryGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    List<Slot> slots = new ArrayList<>();
    String[] positions = {"A1", "A2", "A3", "A4", "B1", "B2", "B3", "B4", "C1", "C2", "C3", "C4", "D1", "D2", "D3", "D4"};
    String[] letters = {"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F", "G", "G", "H", "H"};

    public void printBoard(){
        System.out.println("    | 1 | 2 | 3 | 4 |   ");
        System.out.println("-----------------------");
        System.out.println(" A  | " + slots.get(0).getValueForSlot() +  " | "+ slots.get(1).getValueForSlot() +" | "+ slots.get(2).getValueForSlot()+ " | "+ slots.get(3).getValueForSlot() +" |");
        System.out.println("-----------------------");
        System.out.println(" B  | " + slots.get(4).getValueForSlot() +  " | "+ slots.get(5).getValueForSlot() +" | "+ slots.get(6).getValueForSlot()+ " | "+ slots.get(7).getValueForSlot() +" |");
        System.out.println("-----------------------");
        System.out.println(" C  | " + slots.get(8).getValueForSlot() +  " | "+ slots.get(9).getValueForSlot() +" | "+ slots.get(10).getValueForSlot()+ " | "+ slots.get(11).getValueForSlot() +" |");
        System.out.println("-----------------------");
        System.out.println(" D  | " + slots.get(12).getValueForSlot() +  " | "+ slots.get(13).getValueForSlot() +" | "+ slots.get(14).getValueForSlot()+ " | "+ slots.get(15).getValueForSlot() +" |");
        System.out.println("-----------------------");
    }

    public Slot getSlot(String position){
        for(Slot slot : slots){
            if(slot.getPosition().equals(position)){
                return slot;
            }
        }
        return null;
    }

    public void createSlots(){
        for(int i = 0; i < 16; i++){
            Slot slot = new Slot();
            slot.setLetter(letters[i]);
            slots.add(slot);
        }

        Collections.shuffle(slots);

        for(int i = 0; i < positions.length; i++){
            slots.get(i).setPosition(positions[i]);
        }
    }

    public String[] getPositions() {
        return positions;
    }
}
