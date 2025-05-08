package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.maze.EmptyMaze;

import java.util.List;

public class TextWorld implements IWorld{
    private Position position = new Position(0, 0);
    private Direction currentDirection = Direction.UP;

    public TextWorld (EmptyMaze emptyMaze){

    }


    @Override
    public UpdateResponse updatePosition(int nrSteps) {
       if (Direction.UP.equals(getCurrentDirection())){
           if (isNewPositionAllowed(new Position(this.position.getX(), this.position.getY() + nrSteps)) ) {
               this.position = new Position(this.position.getX(), this.position.getY() + nrSteps);
           }

       } else if (Direction.DOWN.equals(getCurrentDirection())){
           if (isNewPositionAllowed(new Position(this.position.getX(), this.position.getY() - nrSteps))) {
               this.position = new Position(this.position.getX(), this.position.getY() - nrSteps);
           }

       } if (Direction.RIGHT.equals(getCurrentDirection())){
           if (isNewPositionAllowed(new Position(this.position.getX() + nrSteps, this.position.getY()))) {
               this.position = new Position(this.position.getX() + nrSteps, this.position.getY());
           }

       } else if (Direction.LEFT.equals(getCurrentDirection())){
           if (isNewPositionAllowed(new Position(this.position.getX() - nrSteps, this.position.getY()))) {
               this.position = new Position(this.position.getX() - nrSteps, this.position.getY());
           }
       }



       return UpdateResponse.SUCCESS;
    }

    @Override
    public void updateDirection(boolean turnRight) {
        int referenceDirection = 0;

        if (turnRight){
            referenceDirection += 1;
        } else {
            referenceDirection -= 1;
        }

        if (referenceDirection >= 4){
            referenceDirection = 0;
        } else if (referenceDirection <= -1){
            referenceDirection = 3;
        }

        switch (referenceDirection){
            case 0:
                this.currentDirection = Direction.UP;
                break;
            case 1:
                this.currentDirection = Direction.RIGHT;
                break;
            case 2:
                this.currentDirection = Direction.DOWN;
                break;
            case 3:
                this.currentDirection = Direction.LEFT;
                break;
        }
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    @Override
    public boolean isNewPositionAllowed(Position position) {
        if (
                position.getX() > 200 || position.getX() < -200
                || position.getY() > 200 || position.getY() < -200
        ) return false;
        return true;
    }

    @Override
    public boolean isAtEdge() {
        if (
                this.position.getX() == 200 || this.position.getX() == -200
                || this.position.getY() == 200 || this.position.getY() == -200
        ) return true;
        return false;
    }

    @Override
    public void reset() {
        this.position = new Position(0, 0);
        this.currentDirection = Direction.UP;
    }

    @Override
    public List<Obstacle> getObstacles() {
        return List.of();
    }

    @Override
    public void showObstacles() {

    }
}
