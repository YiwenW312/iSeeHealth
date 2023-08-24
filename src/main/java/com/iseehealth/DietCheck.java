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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class DietCheck is to create a diet check class which extends ReportableCheck and implements
 * Check.
 */
public class DietCheck implements Check {

  //Variables
  private final int proteinPercentage;
  private final int fatPercentage;
  private final int carbohydratePercentage;
  private final boolean isVegetable;
  private final boolean isFruit;
  private final boolean isSugar;
  private final boolean isSugarBeverage;
  private final boolean isIceCream;
  private final boolean isSnack;
  private final String snackName;


  /**
   * Constructor for DietCheck
   *
   * @param proteinPercentage      protein percentage
   * @param fatPercentage          fat percentage
   * @param carbohydratePercentage carbohydrate percentage
   * @param isVegetable            is vegetable
   * @param isFruit                is fruit
   * @param isSugar                is sugar
   * @param isSugarBeverage        is sugar beverage
   * @param isIceCream             is ice cream
   * @param isSnack                is snack
   * @param snackName              snack name
   */
  public DietCheck(int proteinPercentage, int fatPercentage, int carbohydratePercentage,
      boolean isVegetable,
      boolean isFruit, boolean isSugar, boolean isSugarBeverage, boolean isIceCream,
      boolean isSnack,
      String snackName) {
    this.proteinPercentage = proteinPercentage;
    this.fatPercentage = fatPercentage;
    this.carbohydratePercentage = carbohydratePercentage;
    this.isVegetable = isVegetable;
    this.isFruit = isFruit;
    this.isSugar = isSugar;
    this.isSugarBeverage = isSugarBeverage;
    this.isIceCream = isIceCream;
    this.isSnack = isSnack;
    this.snackName = snackName;
  }

  /**
   * Update or append to csv
   */
  @Override
  public void updateOrAppendToCSV() {
    List<String> lines = new ArrayList<>();

    try {
      lines = Files.readAllLines(Paths.get(Constants.DIET_CHECK_CSV));
    } catch (IOException e) {
      System.out.println("Error reading from file");
      e.printStackTrace();
    }

    String newEntry = toCSV();
    boolean updated = false;

    for (int i = 0; i < lines.size(); i++) {
      String[] values = lines.get(i).split(",");
      if (values[0].equals(LocalDate.now().toString())) { // assuming date is the first value in csv
        lines.set(i, newEntry); // replace old data
        updated = true;
        break;
      }
    }

    if (!updated) {
      lines.add(newEntry); // if no entry was found for today's date, append new data
    }

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(Constants.DIET_CHECK_CSV))) {
      for (String line : lines) {
        bw.write(line);
        bw.newLine();
      }
    } catch (IOException e) {
      System.out.println("Error writing to file");
      e.printStackTrace();
    }
  }

  /**
   * To csv
   *
   * @return string with above data
   */
  @Override
  public String toCSV() {
    return String.join(",",
        LocalDate.now().toString(),
        String.valueOf(proteinPercentage),
        String.valueOf(fatPercentage),
        String.valueOf(carbohydratePercentage),
        String.valueOf(isVegetable),
        String.valueOf(isFruit),
        String.valueOf(isSugar),
        String.valueOf(isSugarBeverage),
        String.valueOf(isIceCream),
        String.valueOf(isSnack),
        snackName
    );
  }
}
