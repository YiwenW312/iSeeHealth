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
 * Class DietCheck is to create a pain check class
 */
public class MorningPainCheck implements Check {

  //Variables
  private final boolean isNeck;
  private final boolean isHeadache;
  private final boolean isTeeth;
  private final boolean isShoulder;
  private final boolean isJoint;
  private final String otherPain;


  /**
   * Constructor for MorningPainCheck
   *
   * @param isNeck     check neck pain
   * @param isHeadache check headache
   * @param isTeeth    check teeth pain
   * @param isShoulder check shoulder pain
   * @param isJoint    check joint pain
   * @param otherPain  other pain
   */
  public MorningPainCheck(boolean isNeck, boolean isHeadache, boolean isTeeth, boolean isShoulder,
      boolean isJoint, String otherPain) {
    this.isNeck = isNeck;
    this.isHeadache = isHeadache;
    this.isTeeth = isTeeth;
    this.isShoulder = isShoulder;
    this.isJoint = isJoint;
    this.otherPain = otherPain;
  }


  /**
   * This method is to update or append to csv file.
   */
  @Override
  public void updateOrAppendToCSV() {
    List<String> lines = new ArrayList<>();

    try {
      lines = Files.readAllLines(Paths.get(Constants.MORNING_PAIN_CHECK_CSV));
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

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(Constants.MORNING_PAIN_CHECK_CSV))) {
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
   * This method is to convert the input to csv format.
   *
   * @return the input in csv format.
   */
  @Override
  public String toCSV() {
    return String.join(",",
        LocalDate.now().toString(),
        String.valueOf(isNeck),
        String.valueOf(isHeadache),
        String.valueOf(isTeeth),
        String.valueOf(isShoulder),
        String.valueOf(isJoint),
        otherPain
    );
  }
}
