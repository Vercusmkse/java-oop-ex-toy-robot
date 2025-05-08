package za.co.wethinkcode.toyrobot;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BackCommandTest {
    @Test
    void backTest(){
        Robot robot = new Robot("alex");
        BackCommand backCommand = new BackCommand("5");
        robot.setCurrentDirection(Direction.SOUTH);
        robot.handleCommand(backCommand);
        assertEquals(5, robot.getPosition().getY());
    }
}
