package se.comhem.test.montyhall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MontyHallRestControllerTest {

    @InjectMocks
    MontyHallRestController controller;

    @Mock
    MontyHallService service;


    @Test
    public void shouldReturn2WinsWhenChangeAnd20Tries() {
        when(service.getNoOfCarsWon(20, true)).thenReturn(2);
        assertEquals(2, controller.checkResult(20,true));
    }

    @Test
    public void shouldReturn0WinsWhenNoChange15Tries() {
        when(service.getNoOfCarsWon(15, true)).thenReturn(0);
        assertEquals(0, controller.checkResult(15,false));
    }

}