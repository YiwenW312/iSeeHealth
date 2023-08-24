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

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * This class is to create a mental check controller to handle the input of mental check.
 */
public class MentalCheckController extends Controllers {

  /**
   * Button to go back to morning check.
   */
  public Button MorningCheckButton;
  /**
   * Button to reset.
   */
  public Button resetButton;
  /**
   * Button to submit.
   */
  public Button submitButton;
  //Variables
  @FXML
  private CheckBox depressionCheckBox;
  @FXML
  private CheckBox anxietyCheckBox;
  @FXML
  private CheckBox sadnessCheckBox;
  @FXML
  private CheckBox angryCheckBox;
  @FXML
  private CheckBox fearCheckBox;
  @FXML
  private CheckBox joyCheckBox;
  @FXML
  private CheckBox hopefulCheckBox;
  @FXML
  private CheckBox satisfactionCheckBox;
  @FXML
  private TextField journalTextField;

  /**
   * This method is to handle the submit button action.
   */
  @FXML
  public void handleSubmitButtonAction() {
    if (validateInput()) {
      showErrorMessage();
      return;
    }

    MentalCheck mentalCheck = getMentalCheck();
    //Update or append to csv
    mentalCheck.updateOrAppendToCSV();
    //Clear input
    clearInput();
  }

  /**
   * This method is to get mental check.
   *
   * @return mental check
   */
  private MentalCheck getMentalCheck() {
    boolean isDepressed = depressionCheckBox.isSelected();
    boolean isAnxious = anxietyCheckBox.isSelected();
    boolean isSad = sadnessCheckBox.isSelected();
    boolean isAngry = angryCheckBox.isSelected();
    boolean isFear = fearCheckBox.isSelected();
    boolean isJoy = joyCheckBox.isSelected();
    boolean isHopeful = hopefulCheckBox.isSelected();
    boolean isSatisfaction = satisfactionCheckBox.isSelected();
    String journal = journalTextField.getText();
    //Create a mental check object
    return new MentalCheck(isDepressed, isAnxious, isSad, isAngry, isFear, isJoy, isHopeful,
        isSatisfaction, journal);
  }

  /**
   * This method is to handle the reset button action.
   */
  @FXML
  public void handleResetButtonAction() {
    clearInput();
  }

  /**
   * This method is to validate input.
   *
   * @return true if input is valid, false otherwise
   */
  @Override
  public boolean validateInput() {
    return false;
  }

  /**
   * This method is to clear input.
   */
  @Override
  public void clearInput() {
    depressionCheckBox.setSelected(false);
    anxietyCheckBox.setSelected(false);
    sadnessCheckBox.setSelected(false);
    angryCheckBox.setSelected(false);
    fearCheckBox.setSelected(false);
    joyCheckBox.setSelected(false);
    hopefulCheckBox.setSelected(false);
    satisfactionCheckBox.setSelected(false);
    journalTextField.clear();
  }

  /**
   * This method is to show error message.
   */
  @Override
  public void showErrorMessage() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText("Invalid Input");
    alert.setContentText("Please enter valid input");
    alert.showAndWait();
  }
}
