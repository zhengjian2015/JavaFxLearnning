package com.javafx.demo;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 观察Application的生命周期
 */
public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init()" + Thread.currentThread().getName());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start() = "+ Thread.currentThread().getName());
        primaryStage.show();
    }

    /**
     * stop方法是在窗口关闭时调用的
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("stop()");
    }
}
