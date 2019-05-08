package com.javafx.demo;

import javafx.application.Application;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
       System.out.println("Hello World");
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("这是第1个Demo");
        primaryStage.show();
    }
}
