package com.javafx.demo;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;

public class Main7 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HostServices host = getHostServices();
        host.showDocument("www.baidu.com"); //运行到这里打开个网页

        URL url = getClass().getClassLoader().getResource("icon/mails.png");
        String path = url.toExternalForm();

        Button button = new Button("按钮");
        button.setPrefHeight(200);
        button.setPrefWidth(200);

        Group group = new Group();
        group.getChildren().add(button);

        Scene scene = new Scene(group);
        //变为手
        //scene.setCursor(Cursor.CLOSED_HAND);
        //scene.setCursor(Cursor.CROSSHAIR);
        scene.setCursor(Cursor.cursor(path)); //变为图片

        primaryStage.setScene(scene);

        primaryStage.setTitle("javafx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
