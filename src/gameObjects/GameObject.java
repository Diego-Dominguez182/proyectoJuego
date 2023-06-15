package gameObjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import math.Vector2D;

public abstract class GameObject {
    protected final BufferedImage texture;
    protected Vector2D position;

    public GameObject(Vector2D position, BufferedImage texture) {
        this.position = position; // Inicializa la posición del objeto con el valor recibido
        this.texture = texture; // Inicializa la textura del objeto con la imagen recibida
    }

    public abstract void update(float dt); // Método abstracto para actualizar el objeto en función del tiempo transcurrido

    public abstract void draw(Graphics g); // Método abstracto para dibujar el objeto en pantalla utilizando un objeto Graphics

    // Obtiene la posición actual del objeto
    public Vector2D getPosition() {
        return position;
    }

    // Establece la posición del objeto con el valor recibido
    public void setPosition(Vector2D position) {
        this.position = position;
    }

}
