package co.edu.uniquindio.parcial_ii.logic;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Snake {
    private int positionX;
    private int positionY;

    public Snake(){
        this.positionX = 1;
        this.positionY = 1;
    }

    public Snake(int x, int y){
        this.positionX = x;
        this.positionY = y;
    }

    public int getPositionX(){
        return this.positionX;
    }

    public int getPositionY(){
        return this.positionY;
    }

    public void setPosition(int positionX, int positionY){
        positionX = check(positionX);
        positionY = check(positionY);
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int check(int position){
        if (position < 0){
            position = 15;
        }else if(position > 15){
            position = 0;
        }

        return position;
    }

    public boolean toEat(Text text){
        if(text.getFill().equals(Color.RED)){
            return true;
        }
        return false;
    }

    public void defeat(Text text){
        if(text.getFill().equals(Color.BLACK)){
            System.out.println("DEFEAT");
            System.exit(0);
        }
    }
}
