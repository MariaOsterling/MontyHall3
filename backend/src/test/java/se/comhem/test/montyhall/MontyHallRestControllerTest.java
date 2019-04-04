package se.comhem.test.montyhall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MontyHallRestControllerTest {

    private final static boolean CHANGE_DOOR = true;
    private final static boolean KEEP_DOOR = false;

    @InjectMocks
    MontyHallRestController controller;

    @Mock
    MontyHallService service;

    @Mock
    Generator generator;

    @Test
    public void shouldReturn2WinsWhenChangeAnd20Tries() {
        int noOfGames = 20;
        int noOfCarsWon = 2;

        when(service.getNoOfCarsWon(noOfGames, CHANGE_DOOR, generator)).thenReturn(noOfCarsWon);
        assertEquals(noOfCarsWon, controller.checkResult(noOfGames,CHANGE_DOOR));
    }

    @Test
    public void shouldReturn0WinsWhenNoChange15Tries() {
        int noOfGames = 15;
        int noOfCarsWon = 0;
        when(service.getNoOfCarsWon(noOfGames, KEEP_DOOR, generator)).thenReturn(noOfCarsWon);
        assertEquals(noOfCarsWon, controller.checkResult(noOfGames,KEEP_DOOR));
    }

}