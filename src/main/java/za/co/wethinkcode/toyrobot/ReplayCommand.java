package za.co.wethinkcode.toyrobot;

import java.util.ArrayList;

public class ReplayCommand extends Command{
    public ReplayCommand(){
        super("replay");
    }
    public ReplayCommand(String argument){
        super("replay", argument);
    }

    @Override
    public boolean execute(Robot target){
        ArrayList<String> hisitory = target.getCommandHistory();

        if (getArgument().isBlank() || getArgument().isBlank() || getArgument() == null){
            replay(hisitory, target);
            target.setStatus("replayed " + hisitory.size() + " commands.");
        }
        else{
            String[] args = getArgument().toLowerCase().trim().split(" ");
            if (args.length == 1) {
                try {
                    int nrSteps = Integer.parseInt(getArgument());
                    replayNth(hisitory, target, nrSteps);
                    target.setStatus("replayed " + nrSteps + " commands.");
                }
                catch(IllegalArgumentException e) {
                    if (getArgument().equals("reversed")){
                        replayReversed(hisitory, target);
                        target.setStatus("replayed " + hisitory.size() + " commands.");
                    } else {
                        String[] arg = getArgument().toLowerCase().trim().split("-");
                        int steps = Integer.parseInt(arg[0]) - Integer.parseInt(arg[1]);
                        replayRange(hisitory, target, getArgument());
                        target.setStatus("replayed " + steps + " commands.");
                    }
                }
            }
            else if (args.length == 2){
                String[] arg = args[1].toLowerCase().trim().split("-");

                if(arg.length != 2) {
                    int nrSteps = Integer.parseInt(args[1]);
                    replayReversedNth(hisitory, target, nrSteps);
                    target.setStatus("replayed " + nrSteps + " commands.");

                } else {
                    String[] argz = getArgument().toLowerCase().trim().split(" ")[1].split("-");
                    int steps = Integer.parseInt(argz[0]) - Integer.parseInt(argz[1]);
                    replayReversedRange(hisitory, target, getArgument());
                    target.setStatus("replayed " + steps + " commands.");
                }
            }
        }

        return true;
    }

    public void replay(ArrayList<String> history, Robot target){
        for (int x = 0; x <= history.size() - 1; x++){
            Command command = Command.create(history.get(x));
            command.execute(target);
            System.out.println(target);
        }
    }

    public void replayReversed(ArrayList<String> history, Robot target){
        for (int x = history.size() - 1; x >= 0 ; x--){
            Command command = Command.create(history.get(x));
            command.execute(target);
            System.out.println(target);
        }
    }

    public void replayNth(ArrayList<String> history, Robot target, int steps){
        int count = history.size() - steps;

        for (int x = 0; x < steps; x++){
            Command command = Command.create(history.get(count));
            command.execute(target);
            System.out.println(target);
            count++;
        }
    }

    public void replayReversedNth(ArrayList<String> history, Robot target, int steps){
        int count = history.size() - 1;

        for (int x = 0; x < steps; x++){
            Command command = Command.create(history.get(count));
            command.execute(target);
            System.out.println(target);
            count--;
        }
    }

    public void replayRange(ArrayList<String> history, Robot robot, String range){
        String[] args = range.toLowerCase().trim().split("-");
        ArrayList<String> lastHistory = new ArrayList<String>();

        int range1 = Integer.parseInt(args[0]);
        int range2 = Integer.parseInt(args[1]);
        int steps = range1 - range2;

        for (int i = 0; i < steps; i++){
            lastHistory.add(history.get(i));
        }

        for (String item: lastHistory){
            Command command = Command.create(item);
            command.execute(robot);
            System.out.println(robot);
        }
    }

    public void replayReversedRange(ArrayList<String> history, Robot robot, String range){
        String[] args = range.toLowerCase().trim().split(" ")[1].split("-");
        ArrayList<String> lastHistory = new ArrayList<String>();

        int range1 = Integer.parseInt(args[0]);
        int range2 = Integer.parseInt(args[1]);
        int steps = range1 - range2;

        for (int i = 0; i < steps; i++){
            lastHistory.add(history.get(i));
        }

        for (String item: lastHistory.reversed()){
            Command command = Command.create(item);
            command.execute(robot);
            System.out.println(robot);
        }
    }
}
