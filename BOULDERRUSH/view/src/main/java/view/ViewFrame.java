package view;

import contract.controller.IController;
import contract.model.IModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

class ViewFrame extends JFrame implements KeyListener{

	private IModel model;

	/** The controller. */
	private IController controller;
	/** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6900100437818927999L;


	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}

	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

	private IController getController() {
		return this.controller;
	}

	protected void setController(final IController controller) {
		this.controller = controller;
	}

	protected IModel getModel() {
		return this.model;
	}


	private void setModel(final IModel model) {
		this.model = model;
	}


	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
        this.addKeyListener(this);
 		this.setContentPane(new ViewPanel(this));
		this.setSize(1000 + this.getInsets().left + this.getInsets().right, 1000 + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);
	}


	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

    @Override
    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(final KeyEvent e) {
	    this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
