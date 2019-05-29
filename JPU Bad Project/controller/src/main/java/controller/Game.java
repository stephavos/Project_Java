package controller;

import contract.IKeyInput;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

    public class Game extends Canvas implements Runnable {

        private boolean Running = false;
        private Thread thread;
        private Handler handler;
        private Camera camera;


        public Game(){


            handler = new Handler();
            camera = new Camera(0,0);
            this.addKeyListener(new IKeyInput(handler) {
                @Override
                public void keyPressed() {

                }
            });



            handler.addObject(new Bobby(100,100, ID.Player, handler));
        }

        private void start(){
            Running = true;
            thread = new Thread(this);
            thread.start();
        }

        private void stop(){
            Running = false;
            try {
                thread.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {

        }
    }
