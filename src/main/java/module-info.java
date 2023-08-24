/**
 * This module is the main module of the application.
 */
module com.iseehealth {
  requires javafx.controls;
  requires javafx.fxml;
  requires kotlin.stdlib;

  opens com.iseehealth to javafx.fxml;
  exports com.iseehealth;
}