package entities.creatures;

import control.Teclado;

public class Player extends Creature{
    private Teclado teclado;

    public Player(Teclado teclado){
        this.teclado = teclado;
    }

    //Para crear el player en un lugar determinado
    public Player(Teclado teclado, int posX, int posY){
        this.teclado = teclado;
        setX(posX);
        setY(posY);
    }

    public void update(){
        int despX = 0;
        int despY = 0;

        if(teclado.arriba){
            despY--;
        }
        if(teclado.abajo){
            despY++;
        }
        if(teclado.derecha){
            despX++;
        }
        if(teclado.izquierda){
            despX--;
        }

        if(despX != 0 || despY != 0){
            move(despX, despY);
        }
    }

    public void show(){

    }


}
