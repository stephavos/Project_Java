package contract.controller;


import contract.model.IModel;
import contract.view.IView;

public interface IController {

    void orderPerform(final ControllerOrder controllerOrder);
    IModel getModel();
    IView getView();
}
