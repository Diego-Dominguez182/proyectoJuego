package gameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import graphics.Assets;
import graphics.Sound;
import math.Vector2D;
import states.GameState;
import ui.Action;

public class PowerUp extends MovingObject {

    private long duration;
    private final Action action; // Acción asociada al power-up
    private final Sound powerUpPick; // Sonido al recoger el power-up
    private final BufferedImage typeTexture; // Textura del power-up

    public PowerUp(Vector2D position, BufferedImage texture, Action action, GameState gameState) {
        super(position, new Vector2D(), 0, Assets.orb, gameState);

        this.action = action;
        this.typeTexture = texture;
        duration = 0;
        powerUpPick = new Sound(Assets.powerUp);
    }

    void executeAction() {
        action.doAction(); // Ejecutar la acción asociada al power-up
        powerUpPick.play(); // Reproducir el sonido de recogida del power-up
    }

    @Override
    public void update(float dt) {
        angle += 0.1; // Incrementar el ángulo de rotación
        duration += dt;

        if (duration > Constants.POWER_UP_DURATION) {
            this.Destroy(); // Destruir el power-up si ha alcanzado la duración máxima
        }

        collidesWith(); // Comprobar colisiones con otros objetos
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Crear una transformación de afinidad para la rotación y posición del power-up
        at = AffineTransform.getTranslateInstance(
                position.getX() + (double) Assets.orb.getWidth() / 2 - (double) typeTexture.getWidth() / 2,
                position.getY() + (double) Assets.orb.getHeight() / 2 - (double) typeTexture.getHeight() / 2);

        // Rotar la imagen del power-up alrededor de su centro
        at.rotate(angle,
                (double) typeTexture.getWidth() / 2,
                (double) typeTexture.getHeight() / 2);

        // Dibujar la imagen base del power-up (orbe)
        g.drawImage(Assets.orb, (int) position.getX(), (int) position.getY(), null);

        // Dibujar la imagen del tipo de power-up utilizando la transformación de afinidad
        g2d.drawImage(typeTexture, at, null);
    }
}
