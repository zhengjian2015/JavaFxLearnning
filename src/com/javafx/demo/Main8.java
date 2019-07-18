package com.javafx.demo;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * group容器的使用
 */
public class Main8 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");

        b1.setLayoutX(0);
        b1.setLayoutY(10);

        b2.setLayoutX(200);
        b2.setLayoutY(10);

        b3.setLayoutX(400);
        b3.setLayoutY(10);
        b3.setPrefWidth(50);
        b3.setPrefHeight(50);

        Group group = new Group();
        group.getChildren().addAll(b1,b2,b3);
        group.getChildren().remove(b1);
        //group.setAutoSizeChildren(false);
        //group.getChildren().clear();

        //单击时间
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button b4 = new Button("b4");
                group.getChildren().add(b4);
            }
        });

        group.getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> c) {
                System.out.println("当前组件数量"+c.getList().size());
            }
        });


        Object[] obj = group.getChildren().toArray();
        System.out.println(obj.length);

        Scene scene = new Scene(group);

        primaryStage.setScene(scene);

        primaryStage.setTitle("javafx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

    }
}
