package gameObjects;

import java.awt.image.BufferedImage;

import graphics.Assets;

public enum Size {
    BIG(2, Assets.meds), // Tamaño grande con 2 elementos en el arreglo de texturas
    MED(2, Assets.smalls), // Tamaño mediano con 2 elementos en el arreglo de texturas
    SMALL(2, Assets.tinies), // Tamaño pequeño con 2 elementos en el arreglo de texturas
    TINY(0, null); // Tamaño diminuto sin textura asociada

    public final int quantity; // Cantidad de elementos de este tamaño
    public final BufferedImage[] textures; // Arreglo de texturas asociadas a este tamaño

    Size(int quantity, BufferedImage[] textures) {
        this.quantity = quantity;
        this.textures = textures;
    }
}
