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

import java.io.IOException;
import java.util.Objects;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This class is to create a controller for all the scenes.
 */
public class Controllers {

  /**
   * This is a button to go back to the main page.
   */
  public Button iSeeHealthButton;
  /**
   * This is a button to morning check page.
   */
  public Button morningCheckButton;
  /**
   * This is a button to fitness check page.
   */
  public Button fitnessCheckButton;
  /**
   * This is a button to diet check page.
   */
  public Button dietCheckButton;
  /**
   * This is a button to mental check page.
   */
  public Button mentalCheckButton;
  /**
   * This is a button to go to exit program.
   */
  public Button exitButton;
  /**
   * This is a button to go to weekly report.
   */
  public Button weeklyReportButton;
  /**
   * This is a button to go to monthly report.
   */
  public Button monthlyReportButton;
  /**
   * This is stage
   */
  protected Stage stage;
  /**
   * This is scene
   */
  protected Scene scene;

  /**
   * This method is to validate the input.
   *
   * @return boolean
   */
  boolean validateInput() {
    return true;
  }

  /**
   * This method is to clear the input.
   */
  void clearInput() {

  }

  /**
   * This method is to show the error message.
   */
  public void showErrorMessage() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText("Invalid Input");
    alert.setContentText("Please enter valid input");
    alert.showAndWait();
  }

  /**
   * This method is to check if the string is numeric.
   *
   * @param str the string to be checked
   * @return boolean
   */
  boolean isNumeric(String str) {
    return str == null || str.isEmpty() || !str.matches("\\d*");
  }

  /**
   * This method is to switch to the dashboard2 scene.
   *
   * @param event the event of clicking the button iSeeHealth
   * @throws IOException the exception to input and output
   */
  public void switchToDashboard2(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource(Constants.DASHBOARD2_FXML)));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * This method is to switch to the morning check scene.
   * @param event2 the event of clicking the button Morning Check
   * @throws IOException the exception to input and output
   */
  public void switchToMorningCheck(ActionEvent event2) throws IOException {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource(Constants.MORNING_BASIC_SKIN_CHECK_FXML)));
    stage = (Stage) ((Node) event2.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * This method is to switch to the fitness check scene.
   *
   * @param event3 the event of clicking the button Fitness Check
   * @throws IOException the exception to input and output
   */
  public void switchToFitnessCheck(ActionEvent event3) throws IOException {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource(Constants.FITNESS_CHECK_FXML)));
    stage = (Stage) ((Node) event3.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * This method is to switch to the diet check scene.
   *
   * @param event4 the event of clicking the button Diet Check
   * @throws IOException the exception to input and output
   */
  public void switchToDietCheck(ActionEvent event4) throws IOException {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource(Constants.DIET_CHECK_FXML)));
    stage = (Stage) ((Node) event4.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * This method is to switch to the mental check scene.
   *
   * @param event5 the event of clicking the button Mental Check
   * @throws IOException the exception to input and output
   */
  public void switchToMentalCheck(ActionEvent event5) throws IOException {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource(Constants.MENTAL_CHECK_FXML)));
    stage = (Stage) ((Node) event5.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * This method is to switch to the weekly report scene.
   *
   * @param event6 the event of clicking the button Weekly Report
   * @throws IOException the exception to input and output
   */
  public void switchToWeeklyReport(ActionEvent event6) throws IOException {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource(Constants.WEEKLY_REPORT_FXML)));
    stage = (Stage) ((Node) event6.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * This method is to switch to the monthly report scene.
   *
   * @param event7 the event of clicking the button Monthly Report
   * @throws IOException the exception to input and output
   */
  public void switchToMonthlyReport(ActionEvent event7) throws IOException {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource(Constants.MONTHLY_REPORT_FXML)));
    stage = (Stage) ((Node) event7.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * This method is to switch to the morning pain check scene.
   *
   * @param event8 the event of clicking the button next
   * @throws IOException the exception to input and output
   */
  public void switchToMorningPainCheck(ActionEvent event8) throws IOException {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource(Constants.MORNING_PAIN_CHECK_FXML)));
    stage = (Stage) ((Node) event8.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * This method is to switch to the morning digest check scene.
   *
   * @param event8 the event of clicking the button next
   * @throws IOException the exception to input and output
   */
  public void switchToMorningDigestCheck(ActionEvent event8) throws IOException {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource(Constants.MORNING_DIGEST_CHECK_FXML)));
    stage = (Stage) ((Node) event8.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * This method is to close the window.
   *
   * @param e the event of clicking the button exit
   * @throws IOException the exception to input and output
   */
  public void closeWindow(ActionEvent e) throws IOException {
    System.exit(0);
  }
}
