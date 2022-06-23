package game;

import control.Teclado;
import entities.creatures.Player;
import graphics.Pantalla;
import map.LoadedMap;
import map.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Juego extends Canvas implements Runnable {

    //Version por si se modifica la clase en el futuro
    private static final long serialVersionUID = 1L;

    private static final int ANCHO = 800;
    private static final int ALTO = 600;

    //"Volatile" impide a los threads utilizar la variable a la vez
    private static volatile boolean running = false;

    private static final String NOMBRE = "Jueguito";

    private static String CONTADOR_FPS = "";
    private static String CONTADOR_APS = "";

    private static int fps = 0;
    private static int aps = 0;

    private static JFrame ventana;
    private static Thread thread;
    private static Teclado teclado;
    private static Pantalla pantalla;

    private static Map map;
    private static Player player;

    private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO,
            BufferedImage.TYPE_INT_RGB);

    //Devuelve un array de ints que devuelve los pixeles de "imagen"
    private static int[] pixels = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();

    private static final ImageIcon icono = new ImageIcon(Juego.class.getResource("/icon/Logo.png"));

    private Juego(){
        setPreferredSize(new Dimension(ANCHO, ALTO));

        pantalla = new Pantalla(ANCHO, ALTO);

        teclado = new Teclado();
        addKeyListener(teclado);

        map = new LoadedMap("/maps/desertMap.png");
        player = new Player(teclado);

        ventana = new JFrame(NOMBRE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.setUndecorated(true);
        ventana.pack();                                                     //Ajusta el contenido al tamaño de la ventana
        ventana.setLocationRelativeTo(null);                                //Pone la ventana en el centro del escritorio
        ventana.setVisible(true);
        ventana.setIconImage(icono.getImage());

    }

    public static void main(String[] args){
        Juego juego = new Juego();
        juego.start();
    }

    //Los metodos start y stop son synchronized para que la variable running no se corrompa

    private synchronized void start(){
        running = true;

        thread = new Thread(this, "graphics");                  //Para ejecutar el metodo run
        thread.start();
    }

    private synchronized  void stop() {
        running = false;

        try {
            thread.join();                                                  //No usar thread.stop ya que corta el hilo muy bruscamente

        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void update(){
        teclado.update();

        player.update();

        if(teclado.salir){
            System.exit(0);
        }

        aps++;
    }

    private void showGame(){
        //Buffer que guarde en memoria las imagenes para dibujar y que se vea bien
        BufferStrategy strategy = getBufferStrategy();

        if(strategy == null){
            //Triple buffer para que esten preparadas las imagenes con mayor anterioridad
            //Cola de imagenes
            createBufferStrategy(3);
            return;
        }

        pantalla.clean();
        map.showGame(player.getX(), player.getY(), pantalla);

        //Como bucle for pero mas elegante y menos costoso
        System.arraycopy(pantalla.pixels, 0, pixels, 0, pixels.length);

        Graphics g = strategy.getDrawGraphics();

        g.drawImage(imagen, 0,0, getWidth(), getHeight(), null);
        g.setColor(Color.CYAN);
        g.fillRect(ANCHO/2,ALTO/2,32,32);

        g.drawString(CONTADOR_APS, 10, 15);
        g.drawString(CONTADOR_FPS, 10, 30);
        g.drawString("X: " + player.getX(),10,45);
        g.drawString("Y: " +player.getY(),10,60);
        //Libera la memoria de g
        g.dispose();

        strategy.show();


        fps++;
    }

    @Override
    public void run() {
        final int NS_POR_SEG = 1000000000;                      //Equivalencia
        final byte APS_OBJ = 60;                                //Aps
        final double NS_POR_ACT = NS_POR_SEG / APS_OBJ;         //Ns en una actualizacion

        long referenciaAct = System.nanoTime();
        long referenciaCont = System.nanoTime();

        double tiempoTranscurrido;
        double delta = 0;                                       //Tiempo que transcurre hasta que ocurre una actualizacion

        requestFocus();

        //Bucle de ejecución del juego
        while (running){
            final long inicioBucle = System.nanoTime();

            tiempoTranscurrido = inicioBucle - referenciaAct;
            referenciaAct = inicioBucle;

            delta += tiempoTranscurrido/NS_POR_ACT;

            while(delta >= 1){
                update();
                delta--;
            }

            showGame();

            if(System.nanoTime() - referenciaCont > NS_POR_SEG){
                CONTADOR_APS = "APS: " + aps;
                CONTADOR_FPS = "FPS: " + fps;
                aps = 0;
                fps = 0;
                referenciaCont = System.nanoTime();
            }
        }
    }
}
