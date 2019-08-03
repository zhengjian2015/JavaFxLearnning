package com.javafx.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * 对应b站 lesson9
 */
public class Main9  extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Button b1 = new Button("b1");
        b1.setText("这是按钮");
        //按钮的坐标
        b1.setLayoutX(100);
        b1.setLayoutY(100);

        //按钮的长宽
        b1.setPrefHeight(200);
        b1.setPrefWidth(400);

        //按钮的字体型号
        b1.setFont(Font.font("sans-serif",40));
        //改变字体的颜色
        b1.setTextFill(Paint.valueOf("red"));

        /**
        //背景 颜色 拐角半径 就是圆角 The insets：离border的上下左右距离
        BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#8FBC8F"),new CornerRadii(40),new Insets(10));
        Background bg = new Background(bgf);
        b1.setBackground(bg);

        //border边界的设置
        BorderStroke bos = new BorderStroke(Paint.valueOf("#8A2BE2"), BorderStrokeStyle.SOLID,new CornerRadii(20),new BorderWidths(5));
        Border bo = new Border(bos);
        b1.setBorder(bo);
        **/

        //另一种设置样式的方式  https://docs.oracle.com/javase/8/javafx/api/toc.htm

        b1.setStyle("-fx-background-color:#7CCD7C;"+
                "-fx-background-radius: 20;"+
                "-fx-text-fill: blue"
        );

        //设置单击事件
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button bt = (Button) event.getSource();
                System.out.println("this is "+bt.getText());
            }
        });

        Group root = new Group();
        root.getChildren().add(b1);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

    }
}
