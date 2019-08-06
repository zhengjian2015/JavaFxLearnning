package com.javafx.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.stage.Stage;

/**
 * 设置快捷键
 */
public class Main11 extends Application {

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

        Group root = new Group();
        root.getChildren().add(b1);

        Scene scene = new Scene(root);

        //第一种 设置快捷键方式   ctrl+alt+c
        KeyCombination kc1 = new KeyCodeCombination(KeyCode.C,KeyCombination.ALT_DOWN,KeyCombination.CONTROL_DOWN);
        Mnemonic mnemonic = new Mnemonic(b1,kc1);
        scene.addMnemonic(mnemonic);

        //第二种
        KeyCombination kc2 = new KeyCharacterCombination("o",KeyCombination.ALT_DOWN);
        Mnemonic mnemonic2 = new Mnemonic(b1,kc2);
        scene.addMnemonic(mnemonic2);

        //第三种 不常用 不写了

        //第4种 最常用 ctrl+y 不是多线程
        KeyCombination kcb = new KeyCodeCombination(KeyCode.Y,KeyCombination.SHORTCUT_DOWN);
        scene.getAccelerators().put(kcb, new Runnable() {
            @Override
            public void run() {
                System.out.println("run方法");
                System.out.println(Thread.currentThread().getName());
                //加上单击的函数 或者b1.fire() 不太好
            }
        });

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
