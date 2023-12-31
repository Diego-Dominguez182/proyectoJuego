package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.Serial;
import javax.swing.JFrame;

import gameObjects.Constants;
import graphics.Assets;
import input.KeyBoard;
import input.MouseInput;
import states.LoadingState;
import states.State;

public class Window extends JFrame implements Runnable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Canvas canvas;
    private Thread thread;
    private boolean running = false;

    private final int FPS = 60;
    private double delta = 0;
    private int AVERAGEFPS = FPS;

    private final KeyBoard keyBoard;

    public Window() {
        setTitle("Space Ship Game");
        setSize(Constants.WIDTH, Constants.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        canvas = new Canvas();
        keyBoard = new KeyBoard();
        MouseInput mouseInput = new MouseInput();

        canvas.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        canvas.setMaximumSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        canvas.setMinimumSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        canvas.setFocusable(true);

        add(canvas);
        canvas.addKeyListener(keyBoard);
        canvas.addMouseListener(mouseInput);
        canvas.addMouseMotionListener(mouseInput);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Window().start();
    }

    private void update(float dt) {
        keyBoard.update();
        State.getCurrentState().update(dt);
    }

    private void draw() {
        BufferStrategy bs = canvas.getBufferStrategy();

        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        //-----------------------

        // Establecer el color de fondo
        g.setColor(Color.BLACK);

        // Rellenar todo el lienzo con el color de fondo
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);

        // Dibujar el estado actual del juego
        State.getCurrentState().draw(g);

        // Establecer el color para el texto
        g.setColor(Color.WHITE);

        // Dibujar el FPS promedio en la pantalla
        g.drawString(String.valueOf(AVERAGEFPS), 10, 20);

        //---------------------

        g.dispose();
        bs.show();
    }

    private void init() {
        // Inicializar los activos del juego en un hilo separado
        Thread loadingThread = new Thread(() -> Assets.init());

        // Cambiar el estado del juego al estado de carga
        State.changeState(new LoadingState(loadingThread));
    }

    @Override
    public void run() {

        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;

        init();

        while (running) {
            now = System.nanoTime();
            double TARGETTIME = 1000000000 / FPS;
            delta += (now - lastTime) / TARGETTIME;
            time += (now - lastTime);
            lastTime = now;

            if (delta >= 1) {
                // Actualizar el estado del juego
                update((float) (delta * TARGETTIME * 0.000001f));
                // Dibujar el estado del juego
                draw();
                delta--;
                frames++;
            }
            if (time >= 1000000000) {
                // Calcular el FPS promedio
                AVERAGEFPS = frames;
                frames = 0;
                time = 0;
            }
        }

        stop();
    }

    private void start() {
        // Crear y comenzar un nuevo hilo para ejecutar el juego
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    private void stop() {
        try {
            // Detener el hilo del juego y esperar a que termine
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
