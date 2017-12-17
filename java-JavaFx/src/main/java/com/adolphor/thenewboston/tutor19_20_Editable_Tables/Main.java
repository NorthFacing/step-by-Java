package com.adolphor.thenewboston.tutor19_20_Editable_Tables;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;
	Scene scene;

	TextField nameInput;
	TextField priceInput;
	TextField quantityInput;

	TableView<Product> table;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("example");

		TableColumn<Product, String> nameCol = new TableColumn("Name"); // header
		nameCol.setMinWidth(200);
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name")); // 属性名称

		TableColumn<Product, String> priceCol = new TableColumn("Price");
		priceCol.setMinWidth(100);
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

		TableColumn<Product, String> quantityCol = new TableColumn("Quantity");
		quantityCol.setMinWidth(100);
		quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		table = new TableView<>();
		table.setItems(getItems());
		table.getColumns().addAll(nameCol, priceCol, quantityCol);

		// inputs
		nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(100);

		priceInput = new TextField();
		priceInput.setPromptText("Price");

		quantityInput = new TextField();
		quantityInput.setPromptText("Quantity");

		Button addButton = new Button("Add");
		addButton.setMinWidth(50);
		addButton.setOnAction(e -> addButtonClicked());
		Button delButton = new Button("Delete");
		delButton.setMinWidth(60);
		delButton.setOnAction(e -> delButtonClicked());

		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, delButton);

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(table, hBox);

		scene = new Scene(layout, 500, 300);
		window.setScene(scene);
		window.show();
	}

	private ObservableList<Product> getItems() {
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product("Laptop", 859.00, 20));
		products.add(new Product("Bouncy Ball", 2.49, 198));
		products.add(new Product("Corn", 1.49, 856));
		products.add(new Product("Toilet", 99.00, 74));
		return products;
	}


	private void addButtonClicked() {
		Product product = new Product();
		product.setName(nameInput.getText());
		product.setPrice(Double.parseDouble(priceInput.getText()));
		product.setQuantity(Integer.parseInt(quantityInput.getText()));
		table.getItems().add(product);

		nameInput.clear();
		priceInput.clear();
		quantityInput.clear();
	}

	private void delButtonClicked() {
		ObservableList<Product> allProducts = table.getItems();
		ObservableList<Product> selectedItems = table.getSelectionModel().getSelectedItems();
		selectedItems.forEach(allProducts::remove); // lambda表达式
	}


}
