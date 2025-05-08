package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;

import java.util.List;

public class EmptyMaze implements Maze{
    @Override
    public List<Obstacle> getObstacles() {
        return List.of();
    }

    @Override
    public boolean blocksPath(Position a, Position b) {
        return false;
    }
}
