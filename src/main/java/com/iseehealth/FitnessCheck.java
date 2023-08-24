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
 * This class is to create a fitness check object and write the data to the csv file.
 */
public class FitnessCheck implements Check {

  //Variables
  private final int aerobicMinutes;
  private final int strengthMinutes;
  private final int mobilityMinutes;

  /**
   * This method is to get the aerobic minutes.
   *
   * @param aerobicMinutes  the aerobic minutes.
   * @param strengthMinutes the weight lifting minutes.
   * @param mobilityMinutes the mobility minutes.
   */
  public FitnessCheck(int aerobicMinutes, int strengthMinutes, int mobilityMinutes) {
    this.aerobicMinutes = aerobicMinutes;
    this.strengthMinutes = strengthMinutes;
    this.mobilityMinutes = mobilityMinutes;
  }

  /**
   * This method is to update or append the data to the csv file.
   */
  @Override
  public void updateOrAppendToCSV() {
    List<String> lines = new ArrayList<>();

    try {
      lines = Files.readAllLines(Paths.get(Constants.FITNESS_CHECK_CSV));
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

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(Constants.FITNESS_CHECK_CSV))) {
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
   * This method is to convert the data to csv format.
   *
   * @return the data in csv format.
   */
  @Override
  public String toCSV() {
    return String.join(",", LocalDate.now().toString(),
        String.valueOf(aerobicMinutes),
        String.valueOf(strengthMinutes),
        String.valueOf(mobilityMinutes));
  }
}
