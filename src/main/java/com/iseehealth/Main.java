/**
 * This program is to create a health management system including morning checks(basic, skin, pain,
 * allergy), diet check, mental check and fitness check.Diet check and fitness check's inputs will
 * be used to generate weekly reports and monthly reports. This project uses JavaFX, Gradle and
 * Intellij IDEA.
 *
 * @YiwenW312 Yiwen Wang
 * @since 2023-08-10
 */
package com.iseehealth;

import java.util.Objects;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is to create a main class to start the application.
 */
public class Main extends javafx.application.Application {

  @FXML
  public void start(Stage stage) {
    try {
      Parent root = FXMLLoader.load(
          Objects.requireNonNull(Main.class.getResource(Constants.DASHBOARD_FXML)));
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Yiwen, Welcome to iSeeHealth");
      stage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * This method is to launch the application.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
}
