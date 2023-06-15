package graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.sound.sampled.Clip;

public class Assets {

    public static boolean loaded = false; // Indica si los recursos han sido cargados
    public static float count = 0; // Contador de recursos cargados
    public static final float MAX_COUNT = 57; // Número máximo de recursos a cargar


    // Imágenes de los jugadores
    public static BufferedImage player;
    public static BufferedImage doubleGunPlayer;

    // Efectos
    public static BufferedImage speed;
    public static final BufferedImage[] shieldEffect = new BufferedImage[3];

    // Explosión
    public static final BufferedImage[] exp = new BufferedImage[9];

    // Láseres
    public static BufferedImage blueLaser, greenLaser, redLaser;

    // Meteoros
    public static final BufferedImage[] bigs = new BufferedImage[4];
    public static final BufferedImage[] meds = new BufferedImage[2];
    public static final BufferedImage[] smalls = new BufferedImage[2];
    public static final BufferedImage[] tinies = new BufferedImage[2];

    // Ovni
    public static BufferedImage ufo;

    // Números
    public static final BufferedImage[] numbers = new BufferedImage[11];

    // Vida
    public static BufferedImage life;

    // Fuentes
    public static Font fontBig;
    public static Font fontMed;

    // Sonidos
    public static Clip backgroundMusic, explosion, playerLoose, playerShoot, ufoShoot, powerUp;

    // Interfaz de usuario (UI)
    public static BufferedImage blueBtn;
    public static BufferedImage greyBtn;

    // Power-ups
    public static BufferedImage orb, doubleScore, doubleGun, fastFire, shield, star;

    public static void init() {
        // Cargar todas las imágenes, fuentes y sonidos aquí

        player = loadImage("/ships/player.png");
        doubleGunPlayer = loadImage("/ships/doubleGunPlayer.png");

        speed = loadImage("/effects/fire08.png");

        blueLaser = loadImage("/lasers/laserBlue01.png");
        greenLaser = loadImage("/lasers/laserGreen11.png");
        redLaser = loadImage("/lasers/laserRed01.png");

        ufo = loadImage("/ships/ufo.png");

        life = loadImage("/others/life.png");

        fontBig = loadFont("/fonts/futureFont.ttf", 42);
        fontMed = loadFont("/fonts/futureFont.ttf", 20);

        for (int i = 0; i < 3; i++)
            shieldEffect[i] = loadImage("/effects/shield" + (i + 1) + ".png");

        for (int i = 0; i < bigs.length; i++)
            bigs[i] = loadImage("/meteors/big" + (i + 1) + ".png");

        for (int i = 0; i < meds.length; i++)
            meds[i] = loadImage("/meteors/med" + (i + 1) + ".png");

        for (int i = 0; i < smalls.length; i++)
            smalls[i] = loadImage("/meteors/small" + (i + 1) + ".png");

        for (int i = 0; i < tinies.length; i++)
            tinies[i] = loadImage("/meteors/tiny" + (i + 1) + ".png");

        for (int i = 0; i < exp.length; i++)
            exp[i] = loadImage("/explosion/" + i + ".png");

        for (int i = 0; i < numbers.length; i++)
            numbers[i] = loadImage("/numbers/" + i + ".png");

        backgroundMusic = loadSound("/sounds/backgroundMusic.wav");
        explosion = loadSound("/sounds/explosion.wav");
        playerLoose = loadSound("/sounds/playerLoose.wav");
        playerShoot = loadSound("/sounds/playerShoot.wav");
        ufoShoot = loadSound("/sounds/ufoShoot.wav");
        powerUp = loadSound("/sounds/powerUp.wav");

        greyBtn = loadImage("/ui/grey_button.png");
        blueBtn = loadImage("/ui/blue_button.png");

        orb = loadImage("/powers/orb.png");
        doubleScore = loadImage("/powers/doubleScore.png");
        doubleGun = loadImage("/powers/doubleGun.png");
        fastFire = loadImage("/powers/fastFire.png");
        star = loadImage("/powers/star.png");
        shield = loadImage("/powers/shield.png");

        // =============================================

        loaded = true; // Indicar que todos los recursos han sido cargados
    }

    public static BufferedImage loadImage(String path) {
        count++;
        return Loader.ImageLoader(path);
    }

    public static Font loadFont(String path, int size) {
        count++;
        return Loader.loadFont(path, size);
    }

    public static Clip loadSound(String path) {
        count++;
        return Loader.loadSound(path);
    }
}
