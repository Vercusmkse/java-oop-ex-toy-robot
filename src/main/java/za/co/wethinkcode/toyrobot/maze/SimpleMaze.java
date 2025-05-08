package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;

import java.util.Collections;
import java.util.List;

public class SimpleMaze implements Maze{
    private SquareObstacle squareObstacle = new SquareObstacle(1, 1);
    private final List<Obstacle> obstacles;

    public SimpleMaze(){
        this.obstacles = Collections.singletonList(squareObstacle);
    }


    @Override
    public List<Obstacle> getObstacles() {
        return this.obstacles;
    }

    @Override
    public boolean blocksPath(Position a, Position b) {
        return squareObstacle.blocksPath(a, b);
    }
}
