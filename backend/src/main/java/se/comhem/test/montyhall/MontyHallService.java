package se.comhem.test.montyhall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MontyHallService {

    public int getNoOfCarsWon(int noOfGames, boolean changeDoor, Generator generator) {
        List<Boolean> board;
        int chosenDoor=0;
        int definitelyGoat=0;
        int numberOfCarsWon = 0;

        System.out.println("Service called with: " + noOfGames + " " + changeDoor);
        for(int i=0; i<noOfGames; i++) {
            board = generator.setUpBoard();
            chosenDoor = generator.chooseDoor();
            definitelyGoat = generator.selectOneWithGoat();

            boolean res = isCarBehindTheDoor(changeDoor, board, chosenDoor, definitelyGoat);

            System.out.println("Is car behind the door: " + res);
            if (res) {
                numberOfCarsWon++;
            }
        }
        return numberOfCarsWon;
    }

    private boolean isCarBehindTheDoor(boolean changeDoor, List<Boolean> board, int chosenDoor, int definitelyGoat){

        if (changeDoor) {
            return (!board.get(chosenDoor) && !board.get(definitelyGoat));
        } else {
            return (board.get(chosenDoor));
        }
    }
}
