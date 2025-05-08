package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RightCommandTest {
    @Test
    void rightTest(){
        Robot robot = new Robot("alex");
        RightCommand rightCommand = new RightCommand();
        robot.handleCommand(rightCommand);
        robot.handleCommand(rightCommand);
        robot.handleCommand(rightCommand);
        robot.handleCommand(rightCommand);
        assertEquals(Direction.NORTH, robot.getCurrentDirection());
    }
}
