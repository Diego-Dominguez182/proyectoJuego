package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {

	private final boolean[] keys = new boolean[256];

	// Variables estáticas para representar el estado de las teclas
	public static boolean UP, LEFT, RIGHT, SHOOT;

	public KeyBoard() {
		// Inicializar las variables de estado de las teclas
		UP = false;
		LEFT = false;
		RIGHT = false;
		SHOOT = false;
	}

	public void update() {
		// Actualizar el estado de las teclas en función del arreglo de teclas
		UP = keys[KeyEvent.VK_W];
		LEFT = keys[KeyEvent.VK_A];
		RIGHT = keys[KeyEvent.VK_D];
		SHOOT = keys[KeyEvent.VK_SPACE];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Establecer la tecla correspondiente en el arreglo como presionada
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Establecer la tecla correspondiente en el arreglo como liberada
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}
