package view;

import contract.controller.ControllerOrder;
import contract.controller.IController;
import contract.model.IModel;
import contract.view.IView;

import javax.swing.*;
import java.awt.event.KeyEvent;

public final class View implements Runnable, IView {

	private final ViewFrame viewFrame;


	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		System.out.println("keyCOdeto order");
		switch (keyCode) {
			case KeyEvent.VK_Z:
				return ControllerOrder.UP;
			case KeyEvent.VK_S:
				return ControllerOrder.DOWN;
			case KeyEvent.VK_Q:
				return ControllerOrder.LEFT;
			case KeyEvent.VK_D:
				return ControllerOrder.RIGHT;
			default:
				return ControllerOrder.NUL;
		}
	}

	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}
	public void run() {
		this.viewFrame.setVisible(true);
	}
	public void setController(IController controller) {
		this.viewFrame.setController(controller);
	}
}
