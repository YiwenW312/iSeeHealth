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

/**
 * Constants for the program
 */
public class Constants {
  /**
   * Constants for the CSV files dietCheck.csv
   */
  public static String DIET_CHECK_CSV = "dietCheck.csv";
  /**
   * Constants for the CSV files painCheck.csv
   */
  public static String MORNING_PAIN_CHECK_CSV = "painCheck.csv";
  /**
   * Constants for the CSV files digestCheck.csv
   */
  public static String MORNING_DIGEST_CHECK_CSV = "digestCheck.csv";
  /**
   * Constants for the CSV files basicSkinCheck.csv
   */
  public static String MORNING_BASIC_SKIN_CHECK_CSV = "basicSkinCheck.csv";
  /**
   * Constants for the CSV files mentalCheck.csv
   */
  public static String MENTAL_CHECK_CSV = "mentalCheck.csv";
  /**
   * Constants for the CSV files fitnessCheck.csv
   */
  public static String FITNESS_CHECK_CSV = "fitnessCheck.csv";

  /**
   * Constants for the FXML files dashboard
   */
  public static final String DASHBOARD_FXML = "Dashboard.fxml";
  /**
   * Constants for the FXML files dashboard2
   */
  public static final String DASHBOARD2_FXML = "Dashboard2.fxml";
  /**
   * Constants for the FXML files morning check
   */
  public static final String MORNING_PAIN_CHECK_FXML = "MorningCheck-Pain.fxml";
  /**
   * Constants for the FXML files morning check
   */
  public static final String MORNING_DIGEST_CHECK_FXML = "MorningCheck-Digest.fxml";
  /**
   * Constants for the FXML files morning check
   */
  public static final String MORNING_BASIC_SKIN_CHECK_FXML = "MorningCheck-BasicSkin.fxml";
  /**
   * Constants for the FXML files diet check
   */
  public static final String DIET_CHECK_FXML = "DietCheck.fxml";
  /**
   * Constants for the FXML files mental check
   */
  public static final String MENTAL_CHECK_FXML = "MentalCheck.fxml";
  /**
   * Constants for the FXML files fitness check
   */
  public static final String FITNESS_CHECK_FXML = "FitnessCheck.fxml";
  /**
   * Constants for the FXML files weekly report
   */
  public static final String WEEKLY_REPORT_FXML = "WeeklyReport.fxml";
  /**
   * Constants for the FXML files monthly report
   */
  public static final String MONTHLY_REPORT_FXML = "MonthlyReport.fxml";
  /**
   * Constants for goals
   */
  public static final int PROTEIN_GOAL = 30;
  /**
   * Constants for goals FAT
   */
  public static final int FAT_GOAL = 30;
  /**
   * Constants for goals CARBS
   */
  public static final int CARBOHYDRATE_GOAL = 40;
  /**
   * Constants for goals SUGAR weekly
   */
  public static final int WEEKLY_TOO_MUCH_SUGAR = 3;
  /**
   * Constants for goals SNACK weekly
   */
  public static final int WEEKLY_TOO_MUCH_SNACK = 3;
  /**
   * Constants for goals SUGAR Monthly
   */
  public static final int MONTHLY_TOO_MUCH_SUGAR = 10;
  /**
   * Constants for goals SNACK Monthly
   */
  public static final int MONTHLY_TOO_MUCH_SNACK = 10;


  /**
   * Constants for the fitness report AEROBIC GOAL
   */
  public static final int AEROBIC_GOAL = 20;
  /**
   * Constants for the fitness report STRENGTH GOAL
   */
  public static final int STRENGTH_GOAL = 20;
  /**
   * Constants for the fitness report MOBILITY GOAL
   */
  public static final int MOBILITY_GOAL = 10;

  /**
   * Days count week
   */
  public static final int WEEKLY_DAYS_COUNT = 7;
  /**
   * Days count month
   */
  public static final int MONTHLY_DAYS_COUNT = 30;

  /**
   * Constants for the CSV columns DATE
   */
  public static final int DATE_COLUMN = 0;
  /**
   * Constants for the CSV columns PROTEIN
   */
  public static final int PROTEIN_COLUMN = 1;
  /**
   * Constants for the CSV columns FAT
   */
  public static final int FAT_COLUMN = 2;
  /**
   * Constants for the CSV columns
   */
  public static final int CARBOHYDRATE_COLUMN = 3;
  /**
   * Constants for the CSV columns VEGETABLE
   */
  public static final int VEGETABLE_COLUMN = 4;
  /**
   * Constants for the CSV columns FRUIT
   */
  public static final int FRUIT_COLUMN = 5;
  /**
   * Constants for the CSV columns SUGAR
   */
  public static final int SUGAR_COLUMN = 6;
  /**
   * Constants for the CSV columns SUGAR BEVERAGE
   */
  public static final int SUGAR_BEVERAGE_COLUMN = 7;
  /**
   * Constants for the CSV columns ICE CREAM
   */
  public static final int ICE_CREAM_COLUMN = 8;
  /**
   * Constants for the CSV columns SNACK
   */
  public static final int SNACK_COLUMN = 9;
  /**
   * Constants for the CSV columns SNACK NAME
   */
  public static final int SNACK_NAME_COLUMN = 10;
}
