package com.adolphor.thenewboston.tutor31_32_33_FXML;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public void handleButtonClicked(){
		System.out.println("handleButtonClicked...");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("View is now loaded!");
	}

}