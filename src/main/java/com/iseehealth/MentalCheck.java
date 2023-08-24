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
 * Class MentalCheck is to create a mental check class which extends ReportableCheck and implements
 */
public class MentalCheck implements Check {

  //Variables
  private final boolean isDepressed;
  private final boolean isAnxious;
  private final boolean isSad;
  private final boolean isAngry;
  private final boolean isFear;
  private final boolean isJoy;
  private final boolean isHopeful;
  private final boolean isSatisfaction;
  private final String journal;

  /**
   * Constructor for MentalCheck
   *
   * @param isDepressed    is depressed boolean
   * @param isAnxious      is anxious boolean
   * @param isSad          is sad boolean
   * @param isAngry        is angry boolean
   * @param isFear         is fear boolean
   * @param isJoy          is joy boolean
   * @param isHopeful      is hopeful boolean
   * @param isSatisfaction is satisfaction boolean
   * @param journal        journal String
   */
  public MentalCheck(boolean isDepressed, boolean isAnxious, boolean isSad, boolean isAngry,
      boolean isFear, boolean isJoy, boolean isHopeful, boolean isSatisfaction, String journal) {
    this.isDepressed = isDepressed;
    this.isAnxious = isAnxious;
    this.isSad = isSad;
    this.isAngry = isAngry;
    this.isFear = isFear;
    this.isJoy = isJoy;
    this.isHopeful = isHopeful;
    this.isSatisfaction = isSatisfaction;
    this.journal = journal;
  }

  /**
   * Update or append to csv
   */
  @Override
  public void updateOrAppendToCSV() {
    List<String> lines = new ArrayList<>();

    try {
      lines = Files.readAllLines(Paths.get(Constants.MENTAL_CHECK_CSV));
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

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(Constants.MENTAL_CHECK_CSV))) {
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
    return String.join(",", LocalDate.now().toString(),
        String.valueOf(isDepressed),
        String.valueOf(isAnxious),
        String.valueOf(isSad),
        String.valueOf(isAngry),
        String.valueOf(isFear),
        String.valueOf(isJoy),
        String.valueOf(isHopeful),
        String.valueOf(isSatisfaction),
        journal);
  }
}
