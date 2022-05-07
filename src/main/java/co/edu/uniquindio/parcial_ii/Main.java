package co.edu.uniquindio.parcial_ii;

import co.edu.uniquindio.parcial_ii.controller.GameController;
import co.edu.uniquindio.parcial_ii.logic.Snake;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    private KeyCode actualKey = KeyCode.RIGHT;
    private ArrayList<Snake> snakes = new ArrayList<>();

    @Override
    public void start(Stage stage){
        this.snakes.add(new Snake());
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color:#2379a6");

        Scene scene = new Scene(pane, 600, 600);
        stage.setTitle("Culebrita");
        stage.setScene(scene);

        GameController gameController = new GameController(pane, stage);

        gameController.init(this.snakes);
        stage.show();

        control(gameController, scene);
    }

    public void control(GameController gameController, Scene scene){
        scene.setOnKeyPressed(event -> {
            this.actualKey = event.getCode();

            if(this.actualKey.equals(KeyCode.LEFT)){

                gameController.reload(this.snakes, -1, 0);

            }else if(this.actualKey.equals(KeyCode.RIGHT)){

                gameController.reload(this.snakes, 1, 0);

            }else if(this.actualKey.equals(KeyCode.UP)){

                gameController.reload(this.snakes, 0, -1);

            }else if(this.actualKey.equals(KeyCode.DOWN)){

                gameController.reload(this.snakes, 0, 1);

            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}