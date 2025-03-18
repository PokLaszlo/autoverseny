package com.example;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Car extends Rectangle {
    String name;
    Random random = new Random();
    Text text=new Text();
    public Car(String name, Color color, int y){
        this.name=name;
        this.text.setText(name);
        this.setFill(color);
        this.setY(y);
        this.setX(20);
        this.setHeight(30);
        this.setWidth(50);
    }
    public void moving(){
        double x=this.getX()+random.nextInt(8);
        this.setX(x);
    }
    public void back_to_start(){
        this.setX(20);
    }
}
