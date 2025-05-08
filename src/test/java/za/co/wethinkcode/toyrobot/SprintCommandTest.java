package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class SprintCommandTest {
    @Test
    void sprint(){
        Robot robot = new Robot("Alex");
        SprintCommand sprintCommand = new SprintCommand("5");
        robot.handleCommand(sprintCommand);
        assertEquals(15, robot.getPosition().getY());
    }
}
