package gameObjects;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import graphics.Text;
import math.Vector2D;

public class Message {
    private float alpha;
    private final String text;
    private final Vector2D position;
    private final Color color;
    private final boolean center;
    private boolean fade;
    private final Font font;
    private boolean dead;

    /**
     * Constructor de la clase Message.
     *
     * @param position la posición del mensaje.
     * @param fade     indica si el mensaje se desvanecerá gradualmente.
     * @param text     el texto del mensaje.
     * @param color    el color del mensaje.
     * @param center   indica si el texto se centrará en la posición.
     * @param font     la fuente del texto del mensaje.
     */
    public Message(Vector2D position, boolean fade, String text, Color color,
                   boolean center, Font font) {
        this.font = font;
        this.text = text;
        this.position = new Vector2D(position);
        this.fade = fade;
        this.color = color;
        this.center = center;
        this.dead = false;

        if (fade)
            alpha = 1;
        else
            alpha = 0;

    }

    public void draw(Graphics2D g2d) {

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha)); // Establece la transparencia del mensaje

        Text.drawText(g2d, text, position, center, color, font); // Dibuja el texto del mensaje

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1)); // Restaura la transparencia por defecto

        position.setY(position.getY() - 1); // Desplaza la posición del mensaje hacia arriba

        float deltaAlpha = 0.01f;
        if (fade)
            alpha -= deltaAlpha; // Reduce gradualmente la transparencia del mensaje
        else
            alpha += deltaAlpha; // Aumenta gradualmente la transparencia del mensaje

        if (fade && alpha < 0) {
            dead = true; // Si el mensaje se desvanece por completo, se marca como "muerto"
        }

        if (!fade && alpha > 1) {
            fade = true; // Si el mensaje alcanza su transparencia máxima, se activa el desvanecimiento
            alpha = 1;
        }

    }

    public boolean isDead() {
        return dead;
    } // Devuelve si el mensaje está "muerto"


}
