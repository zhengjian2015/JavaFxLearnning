package com.javafx.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main10 extends Application {
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

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("单击事件");
            }
        });


        b1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /**
                 * //不管左右键
                if(event.getClickCount() == 2) {
                    System.out.println("双击事件");
                }
                 **/
                //只接受左键的双击事件
                if(event.getClickCount() == 2 && event.getButton().name().equals(MouseButton.PRIMARY.name())){
                    System.out.println("双击事件");
                }
            }
        });

        //键盘按下
        b1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("按下="+event.getCode().getName());
            }
        });

        //键盘释放
        b1.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("释放="+event.getCode().getName());
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
