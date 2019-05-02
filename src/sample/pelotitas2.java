package sample;


//import com.sun.javafx.perf.PerformanceTracker;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class pelotitas2 extends AnimationTimer {

    private double scene_width = 300;
    private double scene_heigth = 250;
    private double radio = 10;
    private double ballSpeed = 10;
    private double ballSpeedY = 13;
    private Group areaDibujo;
    private Circle ball;

    public pelotitas2(double scene_width, double scene_heigth, double radio, double ballSpeed, double ballSpeedY, Group areaDibujo) {
        this.scene_width = scene_width;
        this.scene_heigth = scene_heigth;
        this.radio = radio;
        this.ballSpeed = ballSpeed;
        this.ballSpeedY = ballSpeedY;
        this.areaDibujo = areaDibujo;
        ball = new Circle(this.radio);
        ball.setFill(Color.rgb((int)(Math.random()*255),(int)(Math.random()*255),(int) (Math.random()*255)));
        ball.setTranslateX((int)(Math.random()*this.scene_width));
        ball.setTranslateY((int)(Math.random()*this.scene_heigth));
        this.areaDibujo.getChildren().add(ball);
    }

    public void handle(long now) {
        // Mostrar la frecuencia de refresco FPS

                /*PerformanceTracker perfTracker = PerformanceTracker.getSceneTracker(scene);
                label.setText("FPS (AnimationTimer) = " + perfTracker.getInstantFPS());*/
        // Cambiar la dirección de la bola si llega a los extremos
        if (ball.getTranslateX() < 0 || ball.getTranslateX() > scene_width) {
            ballSpeed *= -1;
        }
        ball.setTranslateX(ball.getTranslateX() + ballSpeed);
        if (ball.getTranslateY() < 0 || ball.getTranslateY() > scene_heigth) {
            ballSpeedY *= -1;
        }
        ball.setTranslateY(ball.getTranslateY() + ballSpeedY);
    }
}


