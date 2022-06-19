package map;

import java.util.Random;

public class GeneratedMap extends Map{

    private static final Random random = new Random();

    public GeneratedMap(int ancho, int alto) {
        super(ancho, alto);
    }


    @Override
    protected void generateMap(){
        for(int y = 0; y < alto; y++){
            for(int x = 0; x < ancho; x++){
                //El numero del parentesis depende del numero random de sprites que quiero generar
                tiles[x + y * ancho] = random.nextInt(13);
            }
        }
    }

}
