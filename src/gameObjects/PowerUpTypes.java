package gameObjects;

import java.awt.image.BufferedImage;

import graphics.Assets;

// Enumeración que define los tipos de Power-Up
public enum PowerUpTypes {
    SHIELD("SHIELD", Assets.shield), // Power-Up de escudo
    LIFE("+1 LIFE", Assets.life), // Power-Up de vida adicional
    SCORE_X2("SCORE x2", Assets.doubleScore), // Power-Up de multiplicador de puntuación
    FASTER_FIRE("FAST FIRE", Assets.fastFire), // Power-Up de disparo rápido
    SCORE_STACK("+1000 SCORE", Assets.star), // Power-Up de pila de puntuación
    DOUBLE_GUN("DOUBLE GUN", Assets.doubleGun); // Power-Up de doble arma

    public final String text; // Texto asociado al Power-Up
    public final BufferedImage texture; // Textura asociada al Power-Up

    PowerUpTypes(String text, BufferedImage texture) {
        this.text = text;
        this.texture = texture;
    }
}
