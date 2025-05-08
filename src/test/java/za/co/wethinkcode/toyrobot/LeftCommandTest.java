package za.co.wethinkcode.toyrobot;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LeftCommandTest {
    @Test
    void leftTest(){
        Robot robot = new Robot("alex");
        LeftCommand leftCommand = new LeftCommand();
        robot.handleCommand(leftCommand);
        assertEquals(Direction.WEST, robot.getCurrentDirection());
    }
}
