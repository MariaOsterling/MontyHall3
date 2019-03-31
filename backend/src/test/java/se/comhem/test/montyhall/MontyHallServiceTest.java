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

    @InjectMocks
    private MontyHallService service;

    int noOfIterations;


    @Mock
    Generator generator;

    @Before
    public void setUp() {
        noOfIterations = 3;

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
        assertEquals(1, service.getNoOfCarsWon(1, true));
    }

    @Test
    public void shouldReturnNoCarsWonWhenNotChange() {
        assertEquals(0, service.getNoOfCarsWon(1, false));
    }

    @Test
    public void shouldReturn10CarWonWhenChange10Tries() {
        assertEquals(10, service.getNoOfCarsWon(10, true));
    }

    @Test
    public void shouldReturnNoCarsWonWhenNotChange20Tries() {
        assertEquals(0, service.getNoOfCarsWon(20, false));
    }
}
