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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class is to generate reports.
 */
public class ReportGenerator {

  /**
   * This method is formatting report.
   *
   * @param result result
   * @param type   type
   * @return report
   */
  public static String formatReport(Map<String, Integer> result, String type) {
    StringBuilder combinedReport = new StringBuilder();
    if ("fitness".equals(type)) {
      combinedReport.append("Fitness Goal Days:\n");
      combinedReport.append("Aerobic: ").append(result.getOrDefault("Aerobic", 0))
          .append(" days;\n");
      combinedReport.append("Mobility: ").append(result.getOrDefault("Mobility", 0))
          .append(" days;\n");
      combinedReport.append("Strength: ").append(result.getOrDefault("Strength", 0))
          .append(" days;\n\n");
    } else if ("diet".equals(type)) {
      combinedReport.append("Diet Goal Days:\n");
      combinedReport.append("Carbs: ").append(result.getOrDefault("CarbGoalDays", 0))
          .append(" days;\n");
      combinedReport.append("Fat: ").append(result.getOrDefault("FatGoalDays", 0))
          .append(" days;\n");
      combinedReport.append("Protein: ").append(result.getOrDefault("ProteinGoalDays", 0))
          .append(" days;\n");
      combinedReport.append("\nNo Vegetable Days ")
          .append(result.getOrDefault("NoVegetableDays", 0)).append(" days;\n");
      combinedReport.append("Having too much Sugar! Total: ")
          .append(result.getOrDefault("TooMuchSugarDays", 0)).append(" days;\n");
      combinedReport.append("Having too much Snack! Total: ")
          .append(result.getOrDefault("TooMuchSnackDays", 0)).append(" days;\n");
    }
    return combinedReport.toString();
  }

  /**
   * This method is to generate weekly diet report.
   *
   * @param csvData csvData
   * @return report
   * @throws Exception exception
   */
  public static Map<String, Integer> generate7DayDietReport(String csvData) throws Exception {
    return generateDietReport(csvData, 7);
  }

  /**
   * This method is to generate monthly diet report.
   *
   * @param csvData csvData
   * @return report
   * @throws Exception exception
   */
  public static Map<String, Integer> generate30DayDietReport(String csvData) throws Exception {
    return generateDietReport(csvData, 30);
  }

  /**
   * This method is to generate diet report.
   *
   * @param filepath filepath
   * @param days     days
   * @return report
   * @throws Exception exception
   */
  private static Map<String, Integer> generateDietReport(String filepath, int days)
      throws Exception {
    List<String> lines = Files.readAllLines(Paths.get(filepath));

    //String line;
    LocalDate endDate = LocalDate.now();
    LocalDate startDate = endDate.minusDays(days - 1);

    int proteinGoalDays = 0;
    int fatGoalDays = 0;
    int carbGoalDays = 0;
    int noVegetableDays = 0;
    int sugarDays = 0;
    int snackDays = 0;

    for (int i = 1; i < lines.size(); i++) {
      String line = lines.get(i);
      String[] columns = line.split(",");
      LocalDate date = LocalDate.parse(columns[Constants.DATE_COLUMN]);

      if (date.isAfter(endDate) || date.isBefore(startDate)) {
        continue;
      }

      double protein = Double.parseDouble(columns[Constants.PROTEIN_COLUMN]);
      double fat = Double.parseDouble(columns[Constants.FAT_COLUMN]);
      double carbs = Double.parseDouble(columns[Constants.CARBOHYDRATE_COLUMN]);
      boolean isVegetable = columns[Constants.VEGETABLE_COLUMN].equalsIgnoreCase("true");
      boolean isSugar = columns[Constants.SUGAR_COLUMN].equalsIgnoreCase("true");
      boolean isSugarBeverage = columns[Constants.SUGAR_BEVERAGE_COLUMN].equalsIgnoreCase("true");
      boolean isIceCream = columns[Constants.ICE_CREAM_COLUMN].equalsIgnoreCase("true");
      boolean isSnack = columns[Constants.SNACK_COLUMN].equalsIgnoreCase("true");

      if (protein >= Constants.PROTEIN_GOAL) {
        proteinGoalDays++;
      }
      if (fat <= Constants.FAT_GOAL) {
        fatGoalDays++;
      }
      if (carbs <= Constants.CARBOHYDRATE_GOAL) {
        carbGoalDays++;
      }
      if (!isVegetable) {
        noVegetableDays++;
      }
      if (isSugar || isSugarBeverage || isIceCream) {
        sugarDays++;
      }
      if (isSnack) {
        snackDays++;
      }
    }

    Map<String, Integer> report = new HashMap<>();
    report.put("ProteinGoalDays", proteinGoalDays);
    report.put("FatGoalDays", fatGoalDays);
    report.put("CarbGoalDays", carbGoalDays);
    report.put("NoVegetableDays", noVegetableDays);
    if (days == Constants.WEEKLY_DAYS_COUNT) {
      report.put("TooMuchSugarDays", sugarDays > Constants.WEEKLY_TOO_MUCH_SUGAR ? sugarDays : 0);
      report.put("TooMuchSnackDays", snackDays > Constants.WEEKLY_TOO_MUCH_SNACK ? snackDays : 0);
    } else if (days == Constants.MONTHLY_DAYS_COUNT) {
      report.put("TooMuchSugarDays", sugarDays > Constants.MONTHLY_TOO_MUCH_SUGAR ? sugarDays : 0);
      report.put("TooMuchSnackDays", snackDays > Constants.MONTHLY_TOO_MUCH_SNACK ? snackDays : 0);
    }

    return report;
  }

  /**
   * This method is to generate fitness report.
   *
   * @param days days
   * @return report
   * @throws IOException exception
   */
  public static Map<String, Integer> generateFitnessReport(int days) throws IOException {
    Map<LocalDate, List<Integer>> data = fitnessCSVData();
    LocalDate today = LocalDate.now();

    int aerobicGoalDaysCount = 0;
    int strengthGoalDaysCount = 0;
    int mobilityGoalDaysCount = 0;

    for (int i = 0; i < days; i++) {
      LocalDate dayToCheck = today.minusDays(i);
      List<Integer> dayData = data.getOrDefault(dayToCheck, List.of(0, 0, 0));

      if (dayData.get(0) >= Constants.AEROBIC_GOAL) {
        aerobicGoalDaysCount++;
      }
      if (dayData.get(1) >= Constants.STRENGTH_GOAL) {
        strengthGoalDaysCount++;
      }
      if (dayData.get(2) >= Constants.MOBILITY_GOAL) {
        mobilityGoalDaysCount++;
      }
    }

    Map<String, Integer> goalDayCounts = new HashMap<>();
    goalDayCounts.put("Aerobic", aerobicGoalDaysCount);
    goalDayCounts.put("Strength", strengthGoalDaysCount);
    goalDayCounts.put("Mobility", mobilityGoalDaysCount);

    return goalDayCounts;
  }

  /**
   * This method is to get fitness csv data.
   *
   * @return data
   * @throws IOException exception
   */
  private static Map<LocalDate, List<Integer>> fitnessCSVData() throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(Constants.FITNESS_CHECK_CSV));
    if (lines.isEmpty()) {
      throw new IllegalArgumentException("CSV file is empty or not formatted correctly.");
    }

    return lines.stream()
        .skip(1)
        .map(line -> line.split(","))
        .collect(Collectors.toMap(
            tokens -> LocalDate.parse(tokens[0]),
            tokens -> List.of(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[3]))
        ));
  }
}
