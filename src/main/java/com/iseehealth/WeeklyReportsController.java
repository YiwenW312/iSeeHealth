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
import javafx.scene.layout.AnchorPane;

/**
 * This class is to create a weekly report controller.
 */
public class WeeklyReportsController extends Controllers {

  /**
   * Buttons.
   */
  public Button seeWeeklyReportButton;//button to see weekly report
  /**
   * Variables.
   */
  public AnchorPane weeklyReportPane;//pane for weekly report
  @FXML
  private TextArea weeklyReportTextArea;//text area for weekly report
  @FXML
  private Button weeklyReportButton;//button to generate weekly report

  /**
   * This method is to initialize the weekly report controller.
   */
  @FXML
  private void initialize() {
    weeklyReportButton.setOnAction(event -> generateWeeklyCombinedReport());
  }

  /**
   * This method is to generate the weekly combined report.
   */
  @FXML
  private void generateWeeklyCombinedReport() {
    try {
      String fitnessResult = ReportGenerator.formatReport(
          ReportGenerator.generateFitnessReport(Constants.WEEKLY_DAYS_COUNT), "fitness");
      String dietResult = ReportGenerator.formatReport(
          ReportGenerator.generate7DayDietReport(Constants.DIET_CHECK_CSV), "diet");

      String combinedReport = "Weekly Fitness Report: \n" + fitnessResult +
          "Weekly Diet Report: \n" + dietResult;

      weeklyReportTextArea.setText(combinedReport);
    } catch (Exception e) {
      weeklyReportTextArea.setText("Error generating report.");
      e.printStackTrace();
    }
  }
}
