package view;

import entity.GameObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Observable;
import java.util.Observer;

class ViewPanel extends JPanel implements Observer {

    private static final long serialVersionUID = 6900100437818927999L;
    private ViewFrame					viewFrame;

	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getMap();
	}

	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		GameObject[] temp = this.getViewFrame().getModel().getMap();
		Image tempImage = null;

		for(int i = 0; i < 256; i++) {

			switch (temp[i].getName()){
				case "W":
					try {
						tempImage = ImageIO.read(new File("./textures/Wall.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "d":
					try {
						tempImage = ImageIO.read(new File("./textures/Dirt.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "X":
					try {
						tempImage = ImageIO.read(new File("./textures/Enemy.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "o":
					try {
						tempImage = ImageIO.read(new File("./textures/Digged.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "@":
					try {
						tempImage = ImageIO.read(new File("./textures/Rock.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "H":
					try {
						tempImage = ImageIO.read(new File("./textures/Player.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "g":
					try {
						tempImage = ImageIO.read(new File("./textures/Diamond.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;

			}

			graphics.drawImage(tempImage, temp[i].getPosX()  * 16 * 3, temp[i].getPosY() * 16 * 3, 48, 48, null);
		}

        this.repaint();
	}
}
