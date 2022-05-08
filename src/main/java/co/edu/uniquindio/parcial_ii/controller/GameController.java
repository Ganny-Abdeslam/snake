package co.edu.uniquindio.parcial_ii.controller;

import co.edu.uniquindio.parcial_ii.logic.Snake;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

import static co.edu.uniquindio.parcial_ii.logic.utils.RandomFunction.generateRandomNumbers;

public class GameController {
    private Stage stage;
    final private Pane pane;
    private ArrayList<ArrayList<Text>> texts;
    private int count = 1;

    public GameController(Pane pane, Stage stage) {
        this.pane = pane;
        this.stage = stage;
        this.texts = new ArrayList<>();
    }

    public void init(ArrayList<Snake> snakes){

        for(int i=0; i<16; i++){
            ArrayList<Text> texts = new ArrayList<>();
            for (int j=0; j<16; j++){
                Text text = new Text( 40+30*(j+1), 30+30*(i+1), "x");
                text.setId("prueba");
                text.setFill(Color.WHITE);

                this.pane.getChildren().add(text);
                texts.add(text);
            }
            this.texts.add(texts);
        }

        reload(snakes);
        food();

    }

    public void reload(ArrayList<Snake> snakes){
        for (Snake snake: snakes) {
            int positionX = snake.getPositionX();
            int positionY = snake.getPositionY();
            generateSnake(positionX, positionY, this.count);
        }
    }

    public void reload(ArrayList<Snake> snakes, int x, int y){
        int positionAnteriorX = 0, positionAnteriorY = 0;
        int positionX, positionY;
        int i = 1;
        boolean condition = true;
        boolean aux = false;

        for (Snake snake: snakes) {
            if(condition){
                positionAnteriorX = snake.getPositionX();
                positionAnteriorY = snake.getPositionY();

                positionX = snake.getPositionX();
                positionY = snake.getPositionY();

                remove(positionX, positionY);

                positionX+=x;
                positionY+=y;
                snake.setPosition(positionX, positionY);
                positionX = snake.getPositionX();
                positionY = snake.getPositionY();

                aux = snake.toEat(this.texts.get(positionY).get(positionX));
                snake.defeat(this.texts.get(positionY).get(positionX));

                generateSnake(positionX, positionY, i);
                this.texts.get(positionY).get(positionX).setFill(Color.RED);

                condition = false;
            }else{
                remove(snake.getPositionX(), snake.getPositionY());

                positionX = snake.getPositionX();
                positionY = snake.getPositionY();

                snake.setPosition(positionAnteriorX, positionAnteriorY);
                generateSnake(positionAnteriorX, positionAnteriorY, i);

                positionAnteriorX = positionX;
                positionAnteriorY = positionY;

            }

            i++;
        }

        if(aux){
            this.count += 1;
            snakes.add(new Snake(positionAnteriorX, positionAnteriorY));
            generateSnake(positionAnteriorX, positionAnteriorY, this.count);
            food();
        }
    }

    public void food(){
        int a = generateRandomNumbers(0, 16);
        int b = generateRandomNumbers(0, 16);

        if(!this.texts.get(b).get(a).getFill().equals(Color.BLACK) && !this.texts.get(b).get(a).getFill().equals(Color.RED)){
            this.texts.get(b).get(a).setText("-1");
            this.texts.get(b).get(a).setFill(Color.RED);

            return;
        }
        food();
    }

    public void generateSnake(int x, int y, int count){
        this.texts.get(y).get(x).setText(""+count);
        this.texts.get(y).get(x).setFill(Color.BLACK);
    }

    public void remove(int x, int y){
        this.texts.get(y).get(x).setText("x");
        this.texts.get(y).get(x).setFill(Color.WHITE);
    }

    public int getCount(){
        return this.count;
    }
}