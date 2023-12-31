package graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Loader {

    // Método para cargar una imagen dado el path del archivo
    public static BufferedImage ImageLoader(String path) {
        try {
            return ImageIO.read(Objects.requireNonNull(Loader.class.getResource(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para cargar una fuente dado el path del archivo y el tamaño de la fuente
    public static Font loadFont(String path, int size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Loader.class.getResourceAsStream(path))).deriveFont(Font.PLAIN, size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para cargar un sonido dado el path del archivo
    public static Clip loadSound(String path) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Objects.requireNonNull(Loader.class.getResource(path))));
            return clip;
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        return null;
    }
}
