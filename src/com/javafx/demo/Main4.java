package com.javafx.demo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 移动来记录远离x y 坐标
 */
public class Main4 extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.xProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("窗口X坐标="+newValue);
            }
        });

        primaryStage.yProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("窗口Y坐标="+newValue);
            }
        });

        primaryStage.show();

        //多个窗口
        Stage s1 = new Stage();
        s1.initStyle(StageStyle.DECORATED);
        s1.show();

        Stage s2 = new Stage();
        //设置透明
        //s2.initStyle(StageStyle.TRANSPARENT);
        s2.show();
    }
}
