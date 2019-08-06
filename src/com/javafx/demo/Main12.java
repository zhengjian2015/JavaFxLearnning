package com.javafx.demo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * text标签 提示
 */
public class Main12 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

        TextField textField = new TextField();
       // textField.setText("这是个文本");

        textField.setLayoutX(100);
        textField.setLayoutY(100);
        textField.setPrefHeight(100);
        textField.setPrefWidth(100);

        textField.setFont(Font.font(14));

        Tooltip tip = new Tooltip("这是提示");
        tip.setFont(Font.font(40));
        textField.setTooltip(tip);

        textField.setPromptText("请输入7个字符以下");
        textField.setFocusTraversable(false);

        //监听字符串
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //System.out.println(newValue);
                System.out.println(newValue.length());
                System.out.println(oldValue);
                if(newValue.length() > 7){
                    textField.setText(oldValue);
                }
            }
        });

        //选择监听
        textField.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });

        textField.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("aaaaaaaaaaa");
            }
        });
        PasswordField ptext = new PasswordField();

        Label label = new Label("标签");
        label.setLayoutX(200);
        label.setLayoutY(200);

        group.getChildren().add(textField);
        group.getChildren().add(ptext);
        group.getChildren().add(label);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
