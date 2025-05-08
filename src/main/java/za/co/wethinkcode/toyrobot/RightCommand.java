package za.co.wethinkcode.toyrobot;

import java.util.Arrays;

public class RightCommand extends Command{
    @Override
    public boolean execute(Robot target) {
        Direction currentDirection = target.getCurrentDirection();
        Direction[] direction = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
        int directionIndex =  Arrays.asList(direction).indexOf(currentDirection);

        if (directionIndex + 1 >= 4){
            directionIndex = 0;
        } else {
            directionIndex++;
        }

        target.setCurrentDirection(direction[directionIndex]);
        target.setStatus("Turned right.");
        return true;
    }

    public RightCommand(){
        super("right");
    }
}
