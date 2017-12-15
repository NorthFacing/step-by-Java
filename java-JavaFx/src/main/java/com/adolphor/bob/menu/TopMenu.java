package com.adolphor.bob.menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TopMenu extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		final Menu menu1 = new Menu("File");
		final Menu menu2 = new Menu("Options");
		final Menu menu3 = new Menu("Help");

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu1, menu2, menu3);
		menuBar.setUseSystemMenuBar(true);

//		final String os = System.getProperty("os.name");
//		if (os != null && os.startsWith("Mac"))
//			menuBar.useSystemMenuBarProperty().set(true);

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(menuBar);

		primaryStage.setScene(new Scene(borderPane, 500, 300));
		primaryStage.show();
	}
}
