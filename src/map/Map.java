package map;

import graphics.Pantalla;
import map.tile.Tile;

public abstract class Map {
    protected int ancho;
    protected int alto;

    //Un tile es cada uno de los cuadrados del juego, contiene un sprite
    protected int[] tiles;
    protected Tile[] tilesColection;

    //Constructor de mapa aleatorio
    public Map(int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;

        tiles = new int[ancho*alto];
        generateMap();
    }

    //Constructor de mapa cargado desde una ruta
    public Map(String ruta){
        loadMap(ruta);
        generateMap();
    }

    protected void generateMap() {
    }

    protected void loadMap(String ruta) {
    }

    public void update(){

    }

    public void showGame(int compensacionX, int compensacionY, Pantalla pantalla){
        pantalla.setDiferencia(compensacionX, compensacionY);
        //Variables para los límites del mapa
        //>> 5 == /32
         int north = compensacionY >> 5;
         int south = (compensacionY + pantalla.getAlto() + Tile.lado) >> 5;
         int east = (compensacionX + pantalla.getAncho() + Tile.lado) >> 5;
         int west = compensacionX >> 5;

         for(int y = north; y < south; y++){
             for(int x = west; x < east; x++){
                 //getTile(x,y).showGame(x,y,pantalla);
                 if(x < 0 || y < 0 || x >= ancho || y >= alto){
                     //Fuera del mapa
                     Tile.VACIO.showGame(x,y,pantalla);
                 }else{
                     tilesColection[x+y*ancho].showGame(x,y,pantalla);
                 }
             }
         }



    }

    public Tile getTile(final int x, final int y){
        if(x < 0 || y < 0 || x >= ancho || y > alto){
            return Tile.VACIO;
        }
        //Switch con los diferentes tiles
        switch (tiles[x + y * ancho]){
            case 0:
                return Tile.ASFALTO;

            case 1:
                return Tile.ARENA;

            case 2:
                return Tile.BORDE_CARRETERA_IZQUIERDA;

            case 3:
                return Tile.CENTRO_CARRETERA_VERTICAL;

            case 4:
                return Tile.ESQUINA_CARRETERA;

            case 5:
                return Tile.PARED_PIEDRA;

            case 6:
                return Tile.PARED_PIEDRA_INFERIOR;

            case 7:
                return Tile.PARED_PIEDRA_CARRETERA;

            case 8:
                return Tile.PUERTA_SUPERIOR_IZQUIERDA;

            case 9:
                return Tile.PUERTA_INTERMEDIA_IZQUIERDA;

            case 10:
                return Tile.PUERTA_INFERIOR;

            case 11:
                return Tile.OXIDO;

            case 12:
                return Tile.PUERTA_SUPERIOR_CENTRAL;

            default:
                return Tile.VACIO;
        }
    }

}
