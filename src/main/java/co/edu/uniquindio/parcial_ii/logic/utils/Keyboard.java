package co.edu.uniquindio.parcial_ii.logic.utils;

import co.edu.uniquindio.parcial_ii.controller.GameController;
import co.edu.uniquindio.parcial_ii.logic.Snake;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class Keyboard {

    public static void keyboardInput(GameController gameController, KeyCode keyCode, ArrayList<Snake> snakes) {
        if (keyCode.equals(KeyCode.LEFT)) {

            gameController.reload(snakes, -1, 0);

        } else if (keyCode.equals(KeyCode.RIGHT)) {

            gameController.reload(snakes, 1, 0);

        } else if (keyCode.equals(KeyCode.UP)) {

            gameController.reload(snakes, 0, -1);

        } else if (keyCode.equals(KeyCode.DOWN)) {

            gameController.reload(snakes, 0, 1);

        }
    }
}
