package map.tile;

import graphics.Pantalla;
import graphics.Sprite;

public class Tile {
    public int x;
    public int y;

    public Sprite sprite;

    public static final int lado = 32;

    //Coleccion de tiles
    public static final Tile ASFALTO = new Tile(Sprite.ASFALTO);
    public static final Tile VACIO = new Tile(Sprite.VACIO);
    public static final Tile ARENA = new Tile(Sprite.ARENA);
    public static final Tile BORDE_CARRETERA_IZQUIERDA = new Tile(Sprite.BORDE_CARRETERA_IZQUIERDA);
    public static final Tile BORDE_CARRETERA_DERECHA = new Tile(Sprite.BORDE_CARRETERA_DERECHA);
    public static final Tile BORDE_CARRETERA_ARRIBA = new Tile(Sprite.BORDE_CARRETERA_ARRIBA);
    public static final Tile BORDE_CARRETERA_ABAJO = new Tile(Sprite.BORDE_CARRETERA_ABAJO);
    public static final Tile CENTRO_CARRETERA_VERTICAL = new Tile(Sprite.CENTRO_CARRETERA_VERTICAL);
    public static final Tile CENTRO_CARRETERA_HORIZONTAL = new Tile(Sprite.CENTRO_CARRETERA_HORIZONTAL);
    public static final Tile ESQUINA_CARRETERA = new Tile(Sprite.ESQUINA_CARRETERA);
    public static final Tile ESQUINA_CARRETERA_B = new Tile(Sprite.ESQUINA_CARRETERA_B);
    public static final Tile ESQUINA_CARRETERA_C = new Tile(Sprite.ESQUINA_CARRETERA_C);
    public static final Tile ESQUINA_CARRETERA_D = new Tile(Sprite.ESQUINA_CARRETERA_D);
    public static final Tile PARED_PIEDRA = new Tile(Sprite.PARED_PIEDRA);
    public static final Tile PARED_PIEDRA_INFERIOR = new Tile(Sprite.PARED_PIEDRA_INFERIOR);
    public static final Tile PARED_PIEDRA_CARRETERA = new Tile(Sprite.PARED_PIEDRA_CARRETERA);
    public static final Tile PARED_PIEDRA_CARRETERA_B = new Tile(Sprite.PARED_PIEDRA_CARRETERA_B);
    public static final Tile PUERTA_SUPERIOR_IZQUIERDA = new Tile(Sprite.PUERTA_SUPERIOR_IZQUIERDA);
    public static final Tile PUERTA_SUPERIOR_DERECHA = new Tile(Sprite.PUERTA_SUPERIOR_DERECHA);
    public static final Tile PUERTA_INTERMEDIA_IZQUIERDA = new Tile(Sprite.PUERTA_INTERMEDIA_IZQUIERDA);
    public static final Tile PUERTA_INTERMEDIA_DERECHA = new Tile(Sprite.PUERTA_INTERMEDIA_DERECHA);
    public static final Tile PUERTA_INFERIOR = new Tile(Sprite.PUERTA_INFERIOR);
    public static final Tile OXIDO = new Tile(Sprite.OXIDO);
    public static final Tile PUERTA_SUPERIOR_CENTRAL = new Tile(Sprite.PUERTA_SUPERIOR_CENTRAL);

    //Fin de la coleccion

    public Tile(Sprite sprite){
        this.sprite = sprite;
    }

    public void showGame(int x, int y, Pantalla pantalla){
        pantalla.showTile(x << 5,y << 5, this);
    }

    //Dice si el tile es atravesable o no
    public boolean solid(){
        return false;
    }
}
