package za.co.wethinkcode.toyrobot;

import java.util.Arrays;

public class LeftCommand extends Command{
    @Override
    public boolean execute(Robot target) {
        Direction currentDirection = target.getCurrentDirection();
        Direction[] direction = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
        int directionIndex =  Arrays.asList(direction).indexOf(currentDirection);

        if (directionIndex - 1 < 0){
            directionIndex = 3;
        } else {
            directionIndex--;
        }

        target.setCurrentDirection(direction[directionIndex]);
        target.setStatus("Turned left.");
        return true;
    }

    public LeftCommand(){
        super("left");
    }
}
