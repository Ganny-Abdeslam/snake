package co.edu.uniquindio.parcial_ii;

import co.edu.uniquindio.parcial_ii.controller.GameController;
import co.edu.uniquindio.parcial_ii.logic.Snake;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

import static co.edu.uniquindio.parcial_ii.logic.utils.Keyboard.keyboardInput;

public class Main extends Application {

    private KeyCode actualKey = KeyCode.RIGHT;
    private ArrayList<Snake> snakes = new ArrayList<>();

    @Override
    public void start(Stage stage){
        this.snakes.add(new Snake());
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color:#2379a6");

        Scene scene = new Scene(pane, 600, 600);
        stage.setTitle("Snake");
        stage.setScene(scene);

        GameController gameController = new GameController(pane, stage);

        gameController.init(this.snakes);
        stage.show();

       control(scene);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(260), e -> run(gameController)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void run(GameController gameController){
        keyboardInput(gameController, this.actualKey, this.snakes);
    }

    public void control(Scene scene){
        scene.setOnKeyPressed(event -> {
            this.actualKey = event.getCode();
        });
    }

    public static void main(String[] args) {
        launch();
    }
}