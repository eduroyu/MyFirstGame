package map;

import map.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LoadedMap extends Map{

    private int[] pixels;

    public LoadedMap(String ruta) {
        super(ruta);
    }

    @Override
    protected void loadMap(String ruta){
        try {
            BufferedImage image = ImageIO.read(LoadedMap.class.getResource(ruta));

            ancho = image.getWidth();
            alto = image.getHeight();

            tilesColection = new Tile[ancho*alto];
            pixels = new int[ancho*alto];

            image.getRGB(0,0,ancho,alto, pixels, 0,ancho);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void generateMap(){
        for (int i = 0; i < pixels.length; i++){
            switch (pixels[i]){
                case 0xff323232:
                    tilesColection[i] = Tile.ASFALTO;
                    continue;

                case 0xfffae59a:
                    tilesColection[i] = Tile.ARENA;
                    continue;

                case 0xffc19c19:
                    tilesColection[i] = Tile.BORDE_CARRETERA;
                    continue;

                case 0xffb4b3b0:
                    tilesColection[i] = Tile.CENTRO_CARRETERA;
                    continue;

                case 0xff6f6e6d:
                    tilesColection[i] = Tile.ESQUINA_CARRETERA;
                    continue;

                case 0xff3b3b3b:
                    tilesColection[i] = Tile.PARED_PIEDRA;
                    continue;

                case 0xff462200:
                    tilesColection[i] = Tile.PARED_PIEDRA_INFERIOR;
                    continue;

                case 0xff5f452d:
                    tilesColection[i] = Tile.PARED_PIEDRA_CARRETERA;
                    continue;

                case 0xff886748:
                    tilesColection[i] = Tile.PUERTA_INFERIOR;
                    continue;

                case 0xffbf8e61:
                    tilesColection[i] = Tile.PUERTA_INTERMEDIA_IZQUIERDA;
                    continue;

                case 0xffbf7531:
                    tilesColection[i] = Tile.PUERTA_SUPERIOR_IZQUIERDA;
                    continue;

                case 0xffc46811:
                    tilesColection[i] = Tile.PUERTA_SUPERIOR_CENTRAL;
                    continue;

                case 0xfff37601:
                    tilesColection[i] = Tile.OXIDO;
                    continue;

                default:
                    tilesColection[i] = Tile.VACIO;

            }
        }
    }
}
