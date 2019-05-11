package com.javafx.demo;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
       System.out.println("Hello World");
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("这是第1个Demo");
        //设置标题图标
        primaryStage.getIcons().add(new Image("/icon/mails.png"));
        //设置透明度
        //primaryStage.setOpacity(0.5);
        //primaryStage.setAlwaysOnTop(true);
        //设置离左上角的距离
        /*
        primaryStage.setX(500);
        primaryStage.setY(500);
        */
        //设置宽高
        /*primaryStage.setHeight(500);
        primaryStage.setWidth(100);*/
        primaryStage.show();
    }
}
