package entities.creatures;

import entities.Entity;
import graphics.Sprite;

public abstract class Creature extends Entity {
    protected Sprite sprite;
    protected char direction = 'n';
    protected boolean isMoving = false;

    public void update(){

    }

    public void show(){

    }

    public void move(int despX, int despY){
        //Estructura para decidir que sprite pintar
        if(despX > 0){
            direction = 'e';
        }
        if(despX < 0){
            direction = 'w';
        }
        if(despY > 0){
            direction = 's';
        }
        if(despY < 0){
            direction = 'n';
        }

        //Modificar posicion
        if(!isEliminated()){
            changeX(despX);
            changeY(despY);
        }
    }

    private boolean onCollision(){
        return false;
    }
}
