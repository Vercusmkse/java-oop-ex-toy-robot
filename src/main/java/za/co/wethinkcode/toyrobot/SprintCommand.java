package za.co.wethinkcode.toyrobot;

public class SprintCommand extends Command{
    public SprintCommand(String argument){
        super("sprint", argument);
    }
    @Override
    public boolean execute(Robot target) {
        int nrSteps = Integer.parseInt(getArgument());
        for (int i = nrSteps; i >= 1; i--){
            Command command = Command.create("forward " + i);
            target.handleCommand(command);

            if(i != 1){
                System.out.println(target);
            }
        }
        return true;
    }
}
