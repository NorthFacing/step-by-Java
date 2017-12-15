package com.adolphor.genuineCoder.tutor01;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// 按钮
		JFXButton btn1 = new JFXButton("默认");
		btn1.setRipplerFill(Color.BLUE); // 触摸反馈(波纹效果Ripple)

		btn1.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));

		StackPane layout = new StackPane();
		layout.getChildren().add(btn1);

		Scene scene = new Scene(layout, 300, 200);
		primaryStage.setScene(scene);

		primaryStage.show();


	}
}
