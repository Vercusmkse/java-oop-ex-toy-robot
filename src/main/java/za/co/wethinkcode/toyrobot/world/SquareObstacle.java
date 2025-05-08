package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Position;

public class SquareObstacle implements Obstacle{
    private int x;
    private int y;

    public SquareObstacle(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int getBottomLeftX() {
        return this.x;
    }

    @Override
    public int getBottomLeftY() {
        return this.y;
    }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public boolean blocksPosition(Position position) {
        return position.getX() >= x && position.getX() <= x + getSize() - 1
                && position.getY() >= y && position.getY() <= y + getSize() - 1;
    }

    @Override
    public boolean blocksPath(Position a, Position b) {
        if (a.getX() == b.getX()){
            if(a.getX() >= x && a.getX() <= x + getSize() - 1){
                // Just wanna make sure the intial position has the smallest value
                int initialYPos = Math.min(a.getY(), b.getY());
                int finalYPos = Math.max(a.getY(), b.getY());
                return initialYPos <= y + getSize() - 1 && finalYPos >= y;
            }
        }


        if (a.getY() == b.getY()){
            if(a.getY() >= y && a.getX() <= y + getSize() - 1){
                // Just wanna make sure the intial position has the smallest value
                int initialXPos = Math.min(a.getX(), b.getX());
                int finalXPos = Math.max(a.getX(), b.getX());
                return initialXPos <= y + getSize() - 1 && finalXPos >= y;
            }
        }
        return false;
    }
}
