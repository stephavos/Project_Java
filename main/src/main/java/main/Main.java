package main;

import java.sql.SQLException;

import controller.Controller;
import model.Model;
import view.*;


public abstract class Main {

    public static void main(final String[] args) throws SQLException {
        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);

        view.setController(controller);
        controller.gameLoop();

    }

}
