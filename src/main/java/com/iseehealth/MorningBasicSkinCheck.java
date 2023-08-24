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
 * Class MorningBasicSkinCheck is to create a morning basic skin check class
 */
public class MorningBasicSkinCheck implements Check {

  //Variables
  private final int weight;
  private final String bloodPressure;
  private final boolean isRedness;
  private final boolean isSwelling;

  private final boolean isAcne;

  private final boolean isScar;
  private final boolean isItching;
  private final String isOtherSkin;
  /**
   * Buttons
   */
  public Button iSeeHealthButton;


  /**
   * Constructor for MorningBasicSkinCheck
   *
   * @param weight        weight kg
   * @param bloodPressure blood pressure ###/##
   * @param isRedness     is redness
   * @param isSwelling    is swelling
   * @param isAcne        is acne
   * @param isScar        is scar
   * @param isItching     is itching
   * @param isOtherSkin   is other skin
   */
  public MorningBasicSkinCheck(int weight, String bloodPressure, boolean isRedness,
      boolean isSwelling, boolean isAcne, boolean isScar, boolean isItching, String isOtherSkin) {
    this.weight = weight;
    this.bloodPressure = bloodPressure;
    this.isRedness = isRedness;
    this.isSwelling = isSwelling;
    this.isAcne = isAcne;
    this.isScar = isScar;
    this.isItching = isItching;
    this.isOtherSkin = isOtherSkin;
  }


  /**
   * This method is to update or append to csv file.
   */
  @Override
  public void updateOrAppendToCSV() {
    List<String> lines = new ArrayList<>();

    try {
      lines = Files.readAllLines(Paths.get(Constants.MORNING_BASIC_SKIN_CHECK_CSV));
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
        new FileWriter(Constants.MORNING_BASIC_SKIN_CHECK_CSV))) {
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
        String.valueOf(weight),
        bloodPressure,
        String.valueOf(isRedness),
        String.valueOf(isSwelling),
        String.valueOf(isAcne),
        String.valueOf(isScar),
        String.valueOf(isItching),
        isOtherSkin);
  }
}
