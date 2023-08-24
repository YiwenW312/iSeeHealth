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
 * Interface Check is to create a check interface for all the checks.
 */
public interface Check {

  /**
   * This method is to update or append to CSV file.
   */
  void updateOrAppendToCSV();

  /**
   * This method is to convert the check to CSV format.
   *
   * @return String
   */
  String toCSV();
}
