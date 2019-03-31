package se.comhem.test.montyhall;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Generator {

    private List<Boolean> board = new ArrayList<>();
    private  List<Integer> goatIndexes = new ArrayList();
    private int carIndex;

    public List<Boolean> setUpBoard() {
        board.clear();
        board.add(false);
        board.add(false);
        board.add(false);

        carIndex = generateRandomInteger(0,3);
        System.out.println("Car index: " + carIndex);
        System.out.println("board size " + board.size());

        board.set(carIndex, true);

        return board;
    }

    public int chooseDoor() {
        int doorIndex = generateRandomInteger(0,3);
        System.out.println("Chosen door: " + doorIndex);
        return doorIndex;
    }

    public int selectOneWithGoat() {
        goatIndexes.clear();
        goatIndexes.add(0);
        goatIndexes.add(1);
        goatIndexes.add(2);

        goatIndexes.remove(carIndex);

        System.out.println("Number of goats " + goatIndexes.size());
        for(int i : goatIndexes) {
            System.out.println("Goat index: " + i);
        }

        int goatIndex = goatIndexes.get(generateRandomInteger(0,2));
        System.out.println("Definitely goat: " + goatIndex);
        return goatIndex;
    }


    public int generateRandomInteger(int min, int max) {
        Random r = new Random();
        return r.ints(min,max).findFirst().getAsInt();
    }
}
