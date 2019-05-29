package view;
import com.sun.xml.internal.bind.v2.model.core.ID;
import contract.IHandler;

import java.awt.event.KeyAdapter;
import contract.IGameObject;
import contract.IKeyInput;

import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter implements IKeyInput {

    IHandler handler;

    public KeyInput(IHandler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            IGameObject tempObject = handler.object.get(i);

            if (IGameObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_Z) handler.setUp(true);
                if (key == KeyEvent.VK_S) handler.setDown(true);
                if (key == KeyEvent.VK_Q) handler.setLeft(true);
                if (key == KeyEvent.VK_D) handler.setRight(true);

            }
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            IGameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_Z) handler.setUp(false);
                if (key == KeyEvent.VK_S) handler.setDown(false);
                if (key == KeyEvent.VK_Q) handler.setLeft(false);
                if (key == KeyEvent.VK_D) handler.setRight(false);


            }
        }


    }
}
