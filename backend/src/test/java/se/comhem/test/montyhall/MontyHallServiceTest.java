package se.comhem.test.montyhall;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MontyHallServiceTest {

    private final static boolean CHANGE_DOOR = true;
    private final static boolean KEEP_DOOR = false;

    @InjectMocks
    private MontyHallService service;

    @Mock
    Generator generator;

    @Before
    public void setUp() {

        List<Boolean> board = new ArrayList<>();
            board.add(true);
            board.add(false);
            board.add(false);
        when(generator.setUpBoard()).thenReturn(board);

        when(generator.chooseDoor()).thenReturn(1);
        when(generator.selectOneWithGoat()).thenReturn(2);
    }

    @Test
    public void shouldReturnOneCarWonWhenChange() {
        int noOfGames = 1;
        assertEquals(noOfGames, service.getNoOfCarsWon(noOfGames, CHANGE_DOOR, generator));
    }

    @Test
    public void shouldReturnNoCarsWonWhenNotChange() {
        int noOfGames = 1;
        int expectedResult = 0;
        assertEquals(expectedResult, service.getNoOfCarsWon(noOfGames, KEEP_DOOR, generator));
    }

    @Test
    public void shouldReturn10CarWonWhenChange10Tries() {
        int noOfGames = 10;
        assertEquals(noOfGames, service.getNoOfCarsWon(noOfGames, CHANGE_DOOR, generator));
    }

    @Test
    public void shouldReturnNoCarsWonWhenNotChange20Tries() {
        int noOfGames = 20;
        int expectedResult = 0;
        assertEquals(expectedResult, service.getNoOfCarsWon(noOfGames, KEEP_DOOR, generator));
    }
}
