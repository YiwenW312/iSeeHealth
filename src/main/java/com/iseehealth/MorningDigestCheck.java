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
import javafx.scene.control.Button;

/**
 * Class MorningDigestCheck is to create a morning digest check class
 */
public class MorningDigestCheck implements Check {

  //Variables
  private final boolean isDiarrhea;
  private final boolean isStomachache;
  private final boolean isIntestinalPain;
  private final boolean isSourRegurgitation;
  private final boolean isFetidBreath;
  private final boolean isVomit;
  private final String otherSymptoms;
  /**
   * This is a button to go back to the main page.
   */
  public Button iSeeHealthButton;
  /**
   * This is a button to submit the input.
   */
  public Button submitButton;
  /**
   * This is a button to reset the input.
   */
  public Button resetButton;


  /**
   * This is a constructor for MorningDigestCheck.
   *
   * @param isDiarrhea          is a boolean value.
   * @param isStomachache       is a boolean value.
   * @param isIntestinalPain    is a boolean value.
   * @param isSourRegurgitation is a boolean value.
   * @param isFetidBreath       is a boolean value.
   * @param isVomit             is a boolean value.
   * @param otherSymptoms       is a string value.
   */
  public MorningDigestCheck(boolean isDiarrhea, boolean isStomachache, boolean isIntestinalPain,
      boolean isSourRegurgitation, boolean isFetidBreath, boolean isVomit, String otherSymptoms) {
    this.isDiarrhea = isDiarrhea;
    this.isStomachache = isStomachache;
    this.isIntestinalPain = isIntestinalPain;
    this.isSourRegurgitation = isSourRegurgitation;
    this.isFetidBreath = isFetidBreath;
    this.isVomit = isVomit;
    this.otherSymptoms = otherSymptoms;
  }


  /**
   * This method is to update or append to csv file.
   */
  @Override
  public void updateOrAppendToCSV() {
    List<String> lines = new ArrayList<>();

    try {
      lines = Files.readAllLines(Paths.get(Constants.MORNING_DIGEST_CHECK_CSV));
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

    try (BufferedWriter bw = new BufferedWriter(
        new FileWriter(Constants.MORNING_DIGEST_CHECK_CSV))) {
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
   * @return string with above data
   */
  @Override
  public String toCSV() {
    return String.join(",",
        LocalDate.now().toString(),
        Boolean.toString(isDiarrhea),
        Boolean.toString(isStomachache),
        Boolean.toString(isIntestinalPain),
        Boolean.toString(isSourRegurgitation),
        Boolean.toString(isFetidBreath),
        Boolean.toString(isVomit),
        otherSymptoms
    );
  }
}
