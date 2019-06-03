package controller;


import contract.controller.ControllerOrder;
import contract.controller.IController;
import contract.view.IView;
import contract.model.IModel;


public class Controller implements IController {

    private final IView  view;

    private final IModel model;

    public Controller(final IView view, final IModel model) {
        this.view = view;
        this.model = model;
    }

    public IView getView() {
        return this.view;
    }

    public IModel getModel() {
        return this.model;
    }

    public void gameLoop(){
        while(true) {
            this.getModel().monsterMove();
            this.getModel().fallingRockDia();
            System.out.println(this.getModel().isAlive());
        }
    }


    public void orderPerform(final ControllerOrder controllerOrder) {
        switch (controllerOrder) {
            case UP:
                this.model.Move("UP");
                break;
            case DOWN:
                this.model.Move("DOWN");
                break;
            case RIGHT:
                this.model.Move("RIGHT");
                break;
            case LEFT:
                this.model.Move("LEFT");
                break;
            default:
                break;
        }
    }



}

