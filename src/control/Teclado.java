package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Teclado implements KeyListener {

    private final static int numTeclas = 120;
    private final boolean [] teclas = new boolean[numTeclas];

    public boolean arriba;
    public boolean abajo;
    public boolean derecha;
    public boolean izquierda;
    public boolean salir;

    public void update(){
        //WASD
        arriba = teclas[KeyEvent.VK_W];
        abajo = teclas[KeyEvent.VK_S];
        derecha = teclas[KeyEvent.VK_D];
        izquierda = teclas[KeyEvent.VK_A];

        salir = teclas[KeyEvent.VK_ESCAPE];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        teclas[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {

        teclas[e.getKeyCode()] = false;
    }
}
