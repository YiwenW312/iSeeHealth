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
 * This class is to create a diet check controller to handle the input of diet check.
 */
public class DietCheckController extends Controllers {

  /**
   * This is a button to go back to the main page.
   */
    public Button iSeeHealthButton;
    /**
     * This is a button to go to morning check page.
   */
  public Button morningCheckButton;
  /**
   * This is a button to go to fitness check page.
   */
  public Button fitnessCheckButton;
  /**
   * This is a button to go to submit the input.
   */
  public Button submitButton;
  /**
   * This is a button to reset the input.
   */
  public Button resetButton;
  //Variables
  @FXML
  private TextField proteinTextField;
  @FXML
  private TextField fatTextField;
  @FXML
  private TextField carbsTextField;
  @FXML
  private CheckBox vegetableCheckbox;
  @FXML
  private CheckBox fruitCheckbox;
  @FXML
  private CheckBox sugarCheckBox;
  @FXML
  private CheckBox sugarBeverageCheckBox;
  @FXML
  private CheckBox iceCreamCheckBox;
  @FXML
  private CheckBox snackCheckBox;
  @FXML
  private TextField snackNameTextField;


  /**
   * This method is to handle the submit button action.
   */
  @FXML
  public void handleSubmitButtonAction() {
    //Validate input
    if (validateInput()) {
      showErrorMessage();
      return;
    }

    //Get input
    String protein = proteinTextField.getText();
    String fat = fatTextField.getText();
    String carbs = carbsTextField.getText();
    boolean vegetable = vegetableCheckbox.isSelected();
    boolean fruit = fruitCheckbox.isSelected();
    boolean sugar = sugarCheckBox.isSelected();
    boolean sugarBeverage = sugarBeverageCheckBox.isSelected();
    boolean iceCream = iceCreamCheckBox.isSelected();
    boolean snack = snackCheckBox.isSelected();
    String snackName = snackNameTextField.getText();

    //Convert input
    int proteinPercentage = Integer.parseInt(protein);
    int fatPercentage = Integer.parseInt(fat);
    int carbohydratePercentage = Integer.parseInt(carbs);

    //Check if the sum of percentage is 100
    if (proteinPercentage + fatPercentage + carbohydratePercentage != 100) {
      showErrorMessage();
      return;
    } else {
      DietCheck dietCheck = new DietCheck(proteinPercentage, fatPercentage, carbohydratePercentage,
          vegetable, fruit,
          sugar, sugarBeverage, iceCream, snack, snackName);
      dietCheck.updateOrAppendToCSV();
    }

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
   * @return true if the input is valid, false if the input is invalid.
   */
  @Override
  public boolean validateInput() {
    return proteinTextField.getText().isEmpty() || isNumeric(proteinTextField.getText())
        || fatTextField.getText().isEmpty() || isNumeric(fatTextField.getText())
        || carbsTextField.getText().isEmpty() || isNumeric(carbsTextField.getText());
  }

  /**
   * This method is to clear the input.
   */
  @Override
  public void clearInput() {
    proteinTextField.setText("");
    fatTextField.setText("");
    carbsTextField.setText("");
    vegetableCheckbox.setSelected(false);
    fruitCheckbox.setSelected(false);
    sugarCheckBox.setSelected(false);
    sugarBeverageCheckBox.setSelected(false);
    iceCreamCheckBox.setSelected(false);
    snackCheckBox.setSelected(false);
    snackNameTextField.setText("");
  }
}
