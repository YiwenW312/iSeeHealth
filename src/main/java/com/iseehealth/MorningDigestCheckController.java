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
 * This class is to create a morning digest check controller to handle the input of morning digest
 */
public class MorningDigestCheckController extends Controllers {

  /**
   * button to reset
   */
  public Button resetButton;//button to reset the input
  /**
   * button to next page
   */
  public Button nextButton;//button to go to the next page
  /**
   * button to previous page
   */
  public Button previousButton;//button to go back to the previous page
  /**
   * button to submit
   */
  public Button submitButton;//button to submit the input
  //Variables
  @FXML
  private CheckBox diarrheaCheckBox;
  @FXML
  private CheckBox stomachacheCheckBox;
  @FXML
  private CheckBox intestinalPainCheckBox;
  @FXML
  private CheckBox sourRegurgitationCheckBox;
  @FXML
  private CheckBox fetidBreathCheckBox;
  @FXML
  private CheckBox vomitCheckBox;
  @FXML
  private TextField otherDigestTextField;

  /**
   * This method is to handle the submit button action.
   */
  public void handleSubmitButtonAction() {
    //Validate input
    if (validateInput()) {
      showErrorMessage();
      return;
    }
    //Get input
    MorningDigestCheck morningDigestCheck = getMorningDigestCheck();
    //Update or append to csv file
    morningDigestCheck.updateOrAppendToCSV();
    //Clear input
    clearInput();
  }

  /**
   * This method is to get the morning digest check.
   *
   * @return morning digest check
   */
  private MorningDigestCheck getMorningDigestCheck() {
    boolean isDiarrhea = diarrheaCheckBox.isSelected();
    boolean isStomachache = stomachacheCheckBox.isSelected();
    boolean isIntestinalPain = intestinalPainCheckBox.isSelected();
    boolean isSourRegurgitation = sourRegurgitationCheckBox.isSelected();
    boolean isFetidBreath = fetidBreathCheckBox.isSelected();
    boolean isVomit = vomitCheckBox.isSelected();
    String otherSymptoms = otherDigestTextField.getText();

    //Create MorningDigestCheck object
    return new MorningDigestCheck(isDiarrhea, isStomachache, isIntestinalPain, isSourRegurgitation,
        isFetidBreath, isVomit, otherSymptoms);
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
    diarrheaCheckBox.setSelected(false);
    stomachacheCheckBox.setSelected(false);
    intestinalPainCheckBox.setSelected(false);
    sourRegurgitationCheckBox.setSelected(false);
    fetidBreathCheckBox.setSelected(false);
    vomitCheckBox.setSelected(false);
    otherDigestTextField.clear();
  }
}
