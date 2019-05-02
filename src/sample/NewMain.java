package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class NewMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Group gruu = new Group();

        //pelotitas2 pelota2 = new pelotitas2(300, 250, 11, 12, 13, root);
        root.setCenter(gruu);
        Scene scene = new Scene(root, 400, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
        Button agregar = new Button("Agregar");
        root.setBottom(agregar);
        agregar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pelotitas2 pelota = new pelotitas2(300, 190, 10, 11, 12, gruu);
                pelota.start();
            }
        });
        //pelota2.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

}