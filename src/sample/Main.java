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

public class Main extends Application {

    public static final double SCENE_WIDTH = 300;
    public static final double SCENE_HEIGHT = 250;
    public static final double BALL_RADIUS = 10;
    public static double ballSpeed = 10;
    public static double ballSpeedY = 13;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        // Bola que se usará para la animación
        Circle ball = new Circle(BALL_RADIUS);
        //ball.setTranslateX(SCENE_WIDTH * 0.5);
        ball.setTranslateX((int) (Math.random() *SCENE_WIDTH));
        ball.setTranslateY((int) (Math.random() * SCENE_HEIGHT) );
        //ball.setTranslateY(SCENE_HEIGHT * 0.5);
        ball.setFill(Color.BLUE);
        root.getChildren().addAll(ball);

        Circle ball2 = new Circle(BALL_RADIUS);
        //ball.setTranslateX(SCENE_WIDTH * 0.5);
        ball2.setTranslateX((int) (Math.random() *SCENE_WIDTH));
        ball2.setTranslateY((int) (Math.random() * SCENE_HEIGHT) );
        //ball.setTranslateY(SCENE_HEIGHT * 0.5);
        ball2.setFill(Color.BLACK);
        root.getChildren().addAll(ball2);

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Game loop usando AnimationTimer
        AnimationTimer animationTimer = new AnimationTimer() {
            public void handle(long now) {
                // Mostrar la frecuencia de refresco FPS

                /*PerformanceTracker perfTracker = PerformanceTracker.getSceneTracker(scene);
                label.setText("FPS (AnimationTimer) = " + perfTracker.getInstantFPS());*/
                // Cambiar la dirección de la bola si llega a los extremos
                if(ball.getTranslateX() < 0 || ball.getTranslateX() > SCENE_WIDTH) {
                    ballSpeed *= -1;
                }
                ball.setTranslateX(ball.getTranslateX() + ballSpeed);
                if(ball.getTranslateY()<0 || ball.getTranslateY()>SCENE_HEIGHT){
                    ballSpeedY *= -1;
                }
                ball.setTranslateY(ball.getTranslateY() + ballSpeedY);
            }
        };
        animationTimer.start();
    }
    public void pelotitas(){

    }
    public static void main(String[] args) {
        launch(args);
    }

}