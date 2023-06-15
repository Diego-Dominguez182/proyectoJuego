package gameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import math.Vector2D;
import states.GameState;

public class Laser extends MovingObject {

    /**
     * Constructor de la clase Laser.
     *
     * @param position  la posición inicial del láser.
     * @param velocity  la velocidad del láser.
     * @param maxVel    la velocidad máxima del láser.
     * @param angle     el ángulo de rotación del láser.
     * @param texture   la textura del láser.
     * @param gameState el estado de juego actual.
     */
    public Laser(Vector2D position, Vector2D velocity, double maxVel, double angle, BufferedImage texture, GameState gameState) {
        super(position, velocity, maxVel, texture, gameState);
        this.angle = angle; // Establece el ángulo de rotación del láser
        this.velocity = velocity.scale(maxVel); // Calcula la velocidad del láser en función de la velocidad máxima
    }

    @Override
    public void update(float dt) {
        position = position.add(velocity); // Actualiza la posición del láser en función de su velocidad

        // Si el láser sale de los límites del juego, se destruye
        if (position.getX() < 0 || position.getX() > Constants.WIDTH ||
                position.getY() < 0 || position.getY() > Constants.HEIGHT) {
            Destroy();
        }

        collidesWith(); // Comprueba las colisiones con otros objetos en el juego
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Crea una transformación afín para aplicar la posición y rotación al dibujar el láser
        at = AffineTransform.getTranslateInstance(position.getX() - (double) width / 2, position.getY());

        at.rotate(angle, (double) width / 2, 0);

        g2d.drawImage(texture, at, null); // Dibuja el láser con la transformación aplicada
    }

    @Override
    public Vector2D getCenter() {
        return new Vector2D(position.getX() + (double) width / 2, position.getY() + (double) width / 2); // Obtiene el centro del láser
    }

}
