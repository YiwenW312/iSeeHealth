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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * This class is to create a morning pain check controller to handle the input of morning pain
 * check.
 */
public class MorningPainCheckController extends Controllers {

  /**
   * Button to go back to the previous page.
   */
  public Button previousButton;
  /**
   * Button to submit the input.
   */
  public Button submitButton;
  /**
   * Button to reset the input.
   */
  public Button resetButton;
  //Variables
  @FXML
  private CheckBox neckCheckBox;
  @FXML
  private CheckBox headacheCheckBox;
  @FXML
  private CheckBox teethCheckBox;
  @FXML
  private CheckBox shoulderCheckBox;
  @FXML
  private CheckBox jointsCheckBox;
  @FXML
  private TextField otherPainTextField;

  /**
   * This method is to handle the submit button action.
   */
  @FXML
  public void handleSubmitButtonAction() {
    //Validate input
    if (validateInput()) {
      super.showErrorMessage();
      return;
    }
    //Get input
    MorningPainCheck morningPainCheck = getMorningPainCheck();
    //Update or append to csv file
    morningPainCheck.updateOrAppendToCSV();
    //Clear input
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
   * This method is to handle the previous button action.
   *
   * @return morning pain check
   */
  private MorningPainCheck getMorningPainCheck() {
    boolean isNeck = neckCheckBox.isSelected();
    boolean isHeadache = headacheCheckBox.isSelected();
    boolean isTeeth = teethCheckBox.isSelected();
    boolean isShoulder = shoulderCheckBox.isSelected();
    boolean isJoint = jointsCheckBox.isSelected();
    String otherPain = otherPainTextField.getText();

    //Create a morning pain check object
    return new MorningPainCheck(isNeck, isHeadache, isTeeth, isShoulder, isJoint, otherPain);
  }

  /**
   * This method is to validate input.
   *
   * @return true
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
    neckCheckBox.setSelected(false);
    headacheCheckBox.setSelected(false);
    teethCheckBox.setSelected(false);
    shoulderCheckBox.setSelected(false);
    jointsCheckBox.setSelected(false);
    otherPainTextField.setText("");
  }

}
