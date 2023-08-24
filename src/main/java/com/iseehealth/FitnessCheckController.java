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
import javafx.scene.control.TextField;

/**
 * This is Fitness Check controller class
 */
public class FitnessCheckController extends Controllers {

  /**
   * Buttons to reset
   */
  public Button resetButton;
  /**
   * Buttons to submit
   */
  public Button SubmitButton;
  //Variables
  @FXML
  private TextField aerobicMinsTextField;
  @FXML
  private TextField strengthMinsTextField;
  @FXML
  private TextField mobilityMinsTextField;

  /**
   * This method is to handle submit button action
   * @throws IOException IOException
   */
  @FXML
  public void handleSubmitButtonAction() throws IOException {
    if (validateInput()) {
      showErrorMessage();
      return;
    }

    String aerobicTime = aerobicMinsTextField.getText();
    String strengthTime = strengthMinsTextField.getText();
    String mobilityTime = mobilityMinsTextField.getText();

    int aerobicTimeInt = Integer.parseInt(aerobicTime);
    int strengthTimeInt = Integer.parseInt(strengthTime);
    int mobilityTimeInt = Integer.parseInt(mobilityTime);

    FitnessCheck fitnessCheck = new FitnessCheck(aerobicTimeInt, strengthTimeInt, mobilityTimeInt);
    fitnessCheck.updateOrAppendToCSV();

    clearInput();

  }

  /**
   * This method is to handle reset button action
   */
  @FXML
  public void handleResetButtonAction() {
    clearInput();
  }

  /**
   * This method is to clear input
   */
  @Override
  public void clearInput() {
    aerobicMinsTextField.clear();
    strengthMinsTextField.clear();
    mobilityMinsTextField.clear();
  }

  /**
   * This method is to validate input
   *
   * @return boolean
   */
  @Override
  public boolean validateInput() {
    return aerobicMinsTextField.getText().isEmpty() || isNumeric(aerobicMinsTextField.getText())
        || strengthMinsTextField.getText().isEmpty() || isNumeric(strengthMinsTextField.getText())
        || mobilityMinsTextField.getText().isEmpty() || isNumeric(mobilityMinsTextField.getText());
  }
}
