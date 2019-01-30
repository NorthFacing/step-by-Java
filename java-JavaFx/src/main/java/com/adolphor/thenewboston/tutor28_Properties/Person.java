package com.adolphor.thenewboston.tutor28_Properties;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

  private StringProperty firstName = new SimpleStringProperty();

  public StringProperty firstNameProperty() {
    return firstName;
  }

  public String getFirstName() {
    return firstName.get();
  }

  public void setFirstName(String firstName) {
    this.firstName.set(firstName);
  }
}
