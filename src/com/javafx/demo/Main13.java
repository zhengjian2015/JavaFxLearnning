package com.javafx.demo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * 绝对布局
 */
public class Main13 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("Button1");
        b1.setLayoutX(100);
        b1.setLayoutY(200);

        Button b2 = new Button("Button2");

        AnchorPane ap = new AnchorPane();

        //让b1 距离上边10个像素
        ap.setTopAnchor(b1,10.0);
       // ap.setLeftAnchor(b1,15.0);

        ap.getChildren().addAll(b1,b2);

        ap.setStyle("-fx-background-color:#FF3E96");

        ap.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("1111");
            }
        });

        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
