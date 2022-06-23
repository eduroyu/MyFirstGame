package entities;

import map.Map;

public abstract class Entity {
    private int x;
    private int y;

    private boolean eliminated = false;

    protected Map map;

    public void update(){

    }

    public void show(){

    }

    public void eliminate() {
        this.eliminated = true;
    }

    public int getX() {
        return x;
    }

    public void changeX(int despX) {
        x += despX;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void changeY(int despY) {
        y += despY;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isEliminated() {
        return eliminated;
    }


}
