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
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * This class is to create a morning basic skin check controller to handle the input of morning
 * basic
 */
public class MorningBasicSkinCheckController extends Controllers {

  /**
   * This is a button to next page.
   */
  public Button nextButton;
  /**
   * This is a button to reset the input.
   */
  public Button resetButton;
  /**
   * This is a button to submit the input.
   */
  public Button submitButton;
  //Variables
  @FXML
  private TextField weightTextField;
  @FXML
  private TextField bloodPressureTextField;
  @FXML
  private CheckBox rednessCheckBox;
  @FXML
  private CheckBox swellingCheckBox;
  @FXML
  private CheckBox acneCheckBox;
  @FXML
  private CheckBox scarCheckBox;
  @FXML
  private CheckBox itchingCheckBox;
  @FXML
  private TextField otherSkinTextField;

  /**
   * This method is to handle the submit button action.
   *
   * @throws IOException IOException
   */
  @FXML
  public void handleSubmitButtonAction() throws IOException {
    if (validateInput()) {
      showErrorMessage();
      return;
    }
    //Get input
    String weight = weightTextField.getText();
    String bloodPressure = bloodPressureTextField.getText();
    boolean isRedness = rednessCheckBox.isSelected();
    boolean isSwelling = swellingCheckBox.isSelected();
    boolean isAcne = acneCheckBox.isSelected();
    boolean isScar = scarCheckBox.isSelected();
    boolean isItching = itchingCheckBox.isSelected();
    String isOtherSkin = otherSkinTextField.getText();

    int weightInt = Integer.parseInt(weight);

    //Create a morning basic skin check object
    MorningBasicSkinCheck morningBasicSkinCheck = new MorningBasicSkinCheck(weightInt,
        bloodPressure, isRedness, isSwelling, isAcne, isScar, isItching, isOtherSkin);
    //Add the morning basic skin check object to the morning basic skin check list
    morningBasicSkinCheck.updateOrAppendToCSV();

    clearInput();
  }

  /**
   * This method is to handle the reset button action.
   */
  @FXML
  public void handleResetButtonAction() {
    clearInput();
  }

  /**
   * This method is to validate the input.
   *
   * @return boolean
   */
  @Override
  public boolean validateInput() {
    return (weightTextField.getText() == null) || weightTextField.getText().isEmpty() || isNumeric(
        weightTextField.getText())
        || (bloodPressureTextField.getText() == null) || bloodPressureTextField.getText().isEmpty();
  }

  /**
   * This method is to clear input.
   */
  @Override
  public void clearInput() {
    weightTextField.clear();
    bloodPressureTextField.clear();
    rednessCheckBox.setSelected(false);
    swellingCheckBox.setSelected(false);
    acneCheckBox.setSelected(false);
    scarCheckBox.setSelected(false);
    itchingCheckBox.setSelected(false);
    otherSkinTextField.clear();
  }
}
