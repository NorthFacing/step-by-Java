package com.adolphor.thenewboston.tutor17_18_TableView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  Stage window;
  Scene scene;

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

    TableView<Product> table = new TableView<>();
    table.setItems(getItems());
    table.getColumns().addAll(nameCol, priceCol, quantityCol);

    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20, 20, 20, 20));
    layout.getChildren().addAll(table);

    scene = new Scene(layout, 500, 300);
    window.setScene(scene);
    window.show();
  }

  private ObservableList<Product> getItems() {
    ObservableList<Product> products = FXCollections.observableArrayList();
    products.add(new Product("Laptop", 859.00, 20));
    products.add(new Product("Bouncy Ball", 2.49, 198));
    products.add(new Product("Toilet", 99.00, 74));
    products.add(new Product("Corn", 1.49, 856));
    return products;
  }


}
