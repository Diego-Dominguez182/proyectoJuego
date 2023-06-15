package input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

	// Variables estáticas para almacenar la posición del mouse y el estado del botón izquierdo
	public static int X, Y;
	public static boolean MLB;

	@Override
	public void mousePressed(MouseEvent e) {
		// Verificar si se presionó el botón izquierdo del mouse
		if (e.getButton() == MouseEvent.BUTTON1) {
			MLB = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Verificar si se liberó el botón izquierdo del mouse
		if (e.getButton() == MouseEvent.BUTTON1) {
			MLB = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// Actualizar la posición del mouse cuando se arrastra
		X = e.getX();
		Y = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// Actualizar la posición del mouse cuando se mueve sin presionar ningún botón
		X = e.getX();
		Y = e.getY();
	}
}
