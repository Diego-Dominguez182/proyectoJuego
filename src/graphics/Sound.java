package graphics;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {

    private final Clip clip;
    private final FloatControl volume;

    public Sound(Clip clip) {
        this.clip = clip;
        volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    }

    // Método para reproducir el sonido desde el principio
    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

    // Método para reproducir el sonido en bucle continuo
    public void loop() {
        clip.setFramePosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    // Método para detener la reproducción del sonido
    public void stop() {
        clip.stop();
    }

    // Método para obtener la posición actual del sonido en cuadros (frames)
    public int getFramePosition() {
        return clip.getFramePosition();
    }

    // Método para cambiar el volumen del sonido
    public void changeVolume(float value) {
        volume.setValue(value);
    }

}
