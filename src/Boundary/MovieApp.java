package Boundary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class MovieApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage primaryStage; 

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setScene(scene1View());
        primaryStage.show();
        this.primaryStage = primaryStage;
    }


    public void switchView(Scene s){
        primaryStage.setScene(s);
    }

    public Scene scene1View(){

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                switchView(scene2View());
            }
        });


        StackPane root = new StackPane();
        root.getChildren().add(btn);
        return new Scene(root, 900, 550);
    }

    public Scene scene2View(){
        Button btn = new Button();
        btn.setText("Hola!");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hola world!");
                switchView(scene1View());
            }
        });


        StackPane root = new StackPane();
        root.getChildren().add(btn);
        return new Scene(root, 800, 550);
    }




 }