package com.javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.lang.Math;

public class DrawApp extends Application {

    private GraphicsContext g;

    private double t = 0.0;
    private double oldX = 400,oldY = 300;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContext()));
        stage.show();
    }

    private Parent createContext() {
        Pane root = new Pane();
        root.setPrefSize(800,600);

        Canvas canvas = new Canvas(800,600);
        g = canvas.getGraphicsContext2D();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                t += 0.017;
                draw();
            }
        };
        timer.start();

        root.getChildren().add(canvas);
        return root;
    }

    private void draw() {
        Point2D p = curveFunction();

        g.setStroke(Color.BLUE);

        double newX = 400 + p.getX();
        double newY = 300 + p.getY();

        if(oldX != 400 && oldY != 300)
            g.strokeLine(oldX,oldY,newX,newY);

        g.strokeOval(newX, newY, 1, 1);
        oldX = newX;
        oldY = newY;
    }

    private Point2D curveFunction() {
        double x = Math.sin(t) * (Math.pow(Math.E, Math.cos(t)) - 2 * Math.cos(4 * t) - Math.pow(Math.sin(t / 12), 5));
        double y = Math.cos(t) * (Math.pow(Math.E, Math.cos(t)) - 2 * Math.cos(4 * t) - Math.pow(Math.sin(t / 12), 5));

        return new Point2D(x, y).multiply(50);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
