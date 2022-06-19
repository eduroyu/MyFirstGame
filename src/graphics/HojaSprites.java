package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HojaSprites {
    private final int ancho;
    private final int alto;

    public final int [] pixels;

    //Coleccion de hojas de sprites

    public static HojaSprites desert = new HojaSprites("/texturas/DesertSprite.png", 320, 320);


    //Fin de la coleccion

    public HojaSprites(final String ruta, final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;

        pixels = new int[ancho * alto];

        try{
            BufferedImage imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
            imagen.getRGB(0, 0, ancho, alto, pixels, 0, ancho);

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public int getAncho() {
        return ancho;
    }


}
