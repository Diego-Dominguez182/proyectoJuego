package graphics;

import java.awt.image.BufferedImage;

import math.Vector2D;

public class Animation {

    private final BufferedImage[] frames; // Arreglo de imágenes que conforman la animación
    private final int velocity; // Velocidad de la animación
    private int index; // Índice del frame actual
    private boolean running; // Indica si la animación está en curso
    private final Vector2D position; // Posición asociada a la animación
    private long time; // Tiempo transcurrido

    public Animation(BufferedImage[] frames, int velocity, Vector2D position) {
        this.frames = frames;
        this.velocity = velocity;
        this.position = position;
        index = 0;
        running = true;
    }

    public void update(float dt) {
        time += dt;

        // Si el tiempo transcurrido es mayor que la velocidad de la animación,
        // avanzamos al siguiente frame
        if (time > velocity) {
            time = 0;
            index++;

            // Si hemos llegado al último frame, detenemos la animación
            if (index >= frames.length) {
                running = false;
                index = 0;
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public Vector2D getPosition() {
        return position;
    }

    public BufferedImage getCurrentFrame() {
        return frames[index];
    }
}
