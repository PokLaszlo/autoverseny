package com.example;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class mainController {

    @FXML
    private Button backButton;

    Timeline time;
    ArrayList<Car> carlist=new ArrayList<>();

    @FXML
    void initialize(){
        //System.out.println("műkszik");
        carlist.add(new Car("Wolkswagen",Color.DARKBLUE,100));
        carlist.add(new Car("Ferrari",Color.RED,150));
        carlist.add(new Car("Lamborgini",Color.YELLOW,200));
        carlist.add(new Car("Lexus",Color.PINK,250));
        carlist.add(new Car("Opel",Color.BROWN,300));
        carlist.add(new Car("Mclaren",Color.ORANGERED,350));
        
        pane1.getChildren().addAll(carlist);
        this.time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);;
        KeyFrame frame = new KeyFrame(Duration.millis(20), (e)->{
           for(Car car:carlist){
                if(car.getX()+car.getWidth()>448){
                    if(!scoretable.getItems().contains(car.name)){
                        scoretable.getItems().add(car.name);
                        break;
                    }
                    
                }

                if(car.getX()<pane1.getWidth()-190){
                    car.moving();
                }
           }
        });
        time.getKeyFrames().add(frame);
    }

    @FXML
    private Pane pane1;

    @FXML
    private ListView<String> scoretable;

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    @FXML
    void onClick_backButton(ActionEvent event) {
        for(Car car:carlist){
            car.back_to_start();
            this.time.stop();
            scoretable.getItems().clear();
        }
    }

    @FXML
    void onClick_startButton(ActionEvent event) {
        this.time.play();
    }

    @FXML
    void onClick_stopButton(ActionEvent event) {
        this.time.pause();
    }

}
