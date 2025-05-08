package za.co.wethinkcode.toyrobot;

public class MazeRunCommand extends Command{
    @Override
    public boolean execute(Robot target) {
        if (getArgument().equals("top")){
            target.setPosition(new Position(0, 200));
            target.setStatus("I am at the top edge. (Cost: 2 steps)");
        } else if (getArgument().equals("bottom")) {
            target.setPosition(new Position(0, 200));
            target.setStatus("I am at the bottom edge. (Cost: 2 steps)");
        } else if (getArgument().equals("right")) {
            target.setPosition(new Position(200, 0));
            target.setStatus("I am at the right edge. (Cost: 2 steps)");
        } else if (getArgument().equals("left")) {
            target.setPosition(new Position(-200, 0));
            target.setStatus("I am at the left edge. (Cost: 2 steps)");
        }
        return true;
    }

    public MazeRunCommand(String argument){
        super("mazerun", argument);
    }
}
