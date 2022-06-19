package graphics;

public final class Sprite {
    private final int lado;

    private int x;
    private int y;

    public int[] pixels;

    private HojaSprites hoja;

    //Coleccion de Sprites

    public final static Sprite ASFALTO = new Sprite(32, 0,0,0, HojaSprites.desert);
    public final static Sprite ARENA = new Sprite(32,1,0,0,HojaSprites.desert);
    public final static Sprite VACIO = new Sprite(32,0);
    public final static Sprite BORDE_CARRETERA = new Sprite(32,2,0, 0,HojaSprites.desert);
    public final static Sprite CENTRO_CARRETERA = new Sprite(32,3,0,0, HojaSprites.desert);
    public final static Sprite ESQUINA_CARRETERA = new Sprite(32,4,0,0, HojaSprites.desert);
    public final static Sprite PARED_PIEDRA = new Sprite(32,5,0,0,HojaSprites.desert);
    public final static Sprite PARED_PIEDRA_INFERIOR = new Sprite(32,6,0,0, HojaSprites.desert);
    public final static Sprite PARED_PIEDRA_CARRETERA = new Sprite(32,0,3,0,HojaSprites.desert);
    public final static Sprite PUERTA_SUPERIOR_IZQUIERDA = new Sprite(32,7,0,0,HojaSprites.desert);
    public final static Sprite PUERTA_INTERMEDIA_IZQUIERDA = new Sprite(32,7,1,0,HojaSprites.desert);
    public final static Sprite PUERTA_INFERIOR = new Sprite(32,8,1,0,HojaSprites.desert);
    public final static Sprite OXIDO = new Sprite(32, 9, 0,0, HojaSprites.desert);
    public final static Sprite PUERTA_SUPERIOR_CENTRAL = new Sprite(32,8,0,0,HojaSprites.desert);


    //Fin de la coleccion

    public Sprite(final int lado, final int columna, final int fila, final int version, final HojaSprites hoja){
        this.lado = lado;

        pixels = new int[lado * lado];

        this.x = columna * lado;
        this.y = fila * lado;

        this.hoja = hoja;

        loadSprite(version);
    }

    public Sprite(final int lado, final int color){
        this.lado = lado;

        pixels = new int[lado * lado];

        for (int i = 0; i < pixels.length; i++){
            pixels[i] = color;
        }
    }

    public int getLado(){
        return lado;
    }

    private void loadSprite(int version){
        if (version == 0){
            normalLoad();
        } else{
            handledLoad(version);
        }
    }

    private void normalLoad(){
        for (int y = 0; y < lado; y++){
            for (int x = 0; x < lado; x++){
                pixels[x + y * lado] = hoja.pixels[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }
    }

    private void handledLoad(int version){
        int[] tempPixels;   //Almacena el sprite original antes de rotarlo/invertirlo
        tempPixels = initTempPixels();

        switch (version){
            case 1:
                invertX(tempPixels);
                break;
            case 2:
                invertY(tempPixels);
                break;
            case 3:
                invertXY(tempPixels);
                break;
            case 4:
                rotate90L(tempPixels);
                break;
            case 5:
                rotate90R(tempPixels);
                break;
            case 6:
                rotate90LYinverted(tempPixels);
                break;
            case 7:
                rotate90RYinverted(tempPixels);
                break;
            default:
                normalLoad();
        }
    }

    private int[] initTempPixels(){
        int[] tempPixels = new int[lado*lado];

        for (int y = 0; y < lado; y++){
            for (int x = 0; x < lado; x++){
                tempPixels[x + y * lado] = hoja.pixels[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }
    return tempPixels;
    }

    //1
    private void invertX(int[] tempPixels){
        int i = 0;

        for(int y = 0; y < lado; y++){
            for(int x = lado - 1; x > -1; x-- ){
                pixels[i] = tempPixels[x+y*lado];
                i++;
            }
        }
    }

    //2
    private void invertY(int[] tempPixels){
        int i = 0;

        for(int y = lado -1; y > -1; y--){
            for(int x = 0; x < lado; x++ ){
                pixels[i] = tempPixels[x+y*lado];
                i++;
            }
        }
    }

    //3
    private void invertXY(int[] tempPixels){
        for(int i = 0; i < pixels.length; i++){
            pixels[i] = tempPixels[pixels.length-1];
         }
    }

    //4
    private void rotate90L(int[] tempPixels){
        int i = 0;
    }

    //5
    private void rotate90R(int[] tempPixels){

    }

    //6
    private void rotate90LYinverted(int[] tempPixels){

    }

    //7
    private void rotate90RYinverted(int[] tempPixels){

    }
}
