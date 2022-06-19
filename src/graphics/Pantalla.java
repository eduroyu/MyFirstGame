package graphics;

import map.tile.Tile;

public final class Pantalla {

    private final int ancho;
    private final int alto;

    private int diferenciaX;
    private int diferenciaY;

    public final int[] pixels;


    public Pantalla(final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;

        pixels = new int[ancho*alto];
    }

    public void clean(){
        for(int i = 0; i < pixels.length; i++){
            pixels[i] = 0;
        }
    }


    public void showTile(int compensancionX, int compensacionY, Tile tile){
        compensancionX -= diferenciaX;
        compensacionY -= diferenciaY;

        for(int y = 0; y < tile.sprite.getLado(); y++){
            int posicionY = y + compensacionY;
            for(int x = 0; x < tile.sprite.getLado(); x++){
                int posicionX = x + compensancionX;
                if(posicionX < -tile.sprite.getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto){
                    break;
                }
                if(posicionX < 0){
                    posicionX = 0;
                }
                pixels[posicionX + posicionY * ancho] = tile.sprite.pixels[x + y * tile.sprite.getLado()];
            }

        }
    }

    public void setDiferencia(final int diferenciaX, final int diferenciaY){
        this.diferenciaX = diferenciaX;
        this.diferenciaY = diferenciaY;
    }

    public int getAncho(){
        return ancho;
    }

    public int getAlto(){return alto;}
}
