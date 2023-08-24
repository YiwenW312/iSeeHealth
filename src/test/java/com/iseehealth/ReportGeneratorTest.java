package com.iseehealth;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportGeneratorTest {

  // We're assuming you have sample CSV files in these locations:
  private final String dietCSVPath = "src/test/resources/testDiet.csv";
  private final String fitnessCSVPath = "src/test/resources/testFitness.csv";

  @BeforeEach
  void setUp() throws Exception {
    // Setup the test CSV files. You can write content to the files using Files.write or any other way.
    // If you already have static test CSV files, this step can be skipped.
  }

  @AfterEach
  void tearDown() throws Exception {
    // Clean up any files or resources if necessary. This might not be needed if you're using static test CSVs.
  }

  @Test
  void testFormatReportForDiet() {
    Map<String, Integer> testResult = new HashMap<>();
    testResult.put("ProteinGoalDays", 5);
    testResult.put("FatGoalDays", 4);
    testResult.put("CarbGoalDays", 6);
    testResult.put("NoVegetableDays", 2);
    testResult.put("TooMuchSugarDays", 3);
    testResult.put("TooMuchSnackDays", 1);

    String report = ReportGenerator.formatReport(testResult, "diet");
    String expectedReport = "Diet Goal Days:\n" +
        "Carbs: 6 days;\n" +
        "Fat: 4 days;\n" +
        "Protein: 5 days;\n" +
        "\nNo Vegetable Days 2 days;\n" +
        "Having too much Sugar! Total: 3 days;\n" +
        "Having too much Snack! Total: 1 days;\n";

    assertEquals(expectedReport, report);
  }

  @Test
  void testFormatReportForFitness() {
    Map<String, Integer> testResult = new HashMap<>();
    testResult.put("Aerobic", 5);
    testResult.put("Strength", 4);
    testResult.put("Mobility", 6);

    String report = ReportGenerator.formatReport(testResult, "fitness");
    String expectedReport = "Fitness Goal Days:\n" +
        "Aerobic: 5 days;\n" +
        "Mobility: 6 days;\n" +
        "Strength: 4 days;\n\n";

    assertEquals(expectedReport, report);
  }
}