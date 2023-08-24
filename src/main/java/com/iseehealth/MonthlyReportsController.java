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
import javafx.scene.control.TextArea;

/**
 * This class is to create a weekly report controller.
 */
public class MonthlyReportsController extends Controllers {

  /**
   * Buttons.
   */
  public Button seeMonthlyReportButton;
  @FXML
  private TextArea monthlyReportTextArea;
  @FXML
  private Button monthlyReportButton;

  /**
   * This method is to initialize the controller.
   */
  @FXML
  private void initialize() {
    monthlyReportButton.setOnAction(event -> generateMonthlyCombinedReport());
  }

  /**
   * This method is to generate monthly combined report.
   */
  @FXML
  private void generateMonthlyCombinedReport() {
    try {
      String fitnessResult = ReportGenerator.formatReport(
          ReportGenerator.generateFitnessReport(Constants.MONTHLY_DAYS_COUNT), "fitness");
      String dietResult = ReportGenerator.formatReport(
          ReportGenerator.generate30DayDietReport(Constants.DIET_CHECK_CSV), "diet");

      String combinedReport = "Weekly Fitness Report: \n" + fitnessResult +
          "Weekly Diet Report: \n" + dietResult;

      monthlyReportTextArea.setText(combinedReport);
    } catch (Exception e) {
      monthlyReportTextArea.setText("Error generating report.");
      e.printStackTrace();
    }
  }
}
