package com.javafx.demo;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main6 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Screen screen = Screen.getPrimary();

        double dpi = screen.getDpi();
        System.out.println("当前屏幕dpi = "+dpi);

        Rectangle2D rec1 = screen.getBounds();
        Rectangle2D rec2 = screen.getVisualBounds();

        System.out.println("左上角 = "+rec1.getMinX()+ " "+rec1.getMinY());
        System.out.println("右上角X ="+rec1.getMaxX()+ " "+rec2.getMaxY());

        primaryStage.show();
    }
}
