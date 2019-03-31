package se.comhem.test.montyhall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MontyHallRestController {

    @Autowired
    private MontyHallService service;

    @RequestMapping(value="/checkresult/", method = RequestMethod.GET)
    public int checkResult(@RequestParam("number") int number, @RequestParam("changeDoor") boolean changeDoor) {
        return service.getNoOfCarsWon(number, changeDoor);
    }

}
