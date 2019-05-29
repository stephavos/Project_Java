package view;
import java.util.Observer;

import contract.IController;

import contract.IWindow;

public class Window implements IWindow {


        private WindowFrame frame;
        public Window()
        {
            this.frame = new WindowFrame();
        }

        /**
         * update methode from IView inteface
         */
        public void repaint()
        {

        }


        public void openWindow()
        {
            this.frame.setVisible(true);
        }


        /**
         * methode to close the current frame
         */
        public void closeWindow()
        {
            this.frame.setVisible(false);
        }


        /**
         * methode to get the observer from the patern
         */
        public Observer getObserver()
        {
            return this.frame.getGamePanel();
        }


    }
