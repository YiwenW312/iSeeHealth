package com.iseehealth;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.*;
import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MentalCheckTest {

  private Path tempPath;

  @BeforeEach
  public void setUp() throws Exception {
    tempPath = Files.createTempFile("testMental", ".csv");
    Constants.MENTAL_CHECK_CSV = tempPath.toString();
  }

  @Test
  public void testUpdateOrAppendToCSV() throws IOException {
    MentalCheck mentalCheck = new MentalCheck(true, false, true, false, false, true, true, false, "Today was a good day.");
    mentalCheck.updateOrAppendToCSV();

    List<String> lines = Files.readAllLines(tempPath);

    assertFalse(lines.isEmpty(), "CSV file should not be empty");

    String[] values = lines.get(0).split(",");
    assertEquals(LocalDate.now().toString(), values[0]);
    assertEquals("true", values[1]);
    assertEquals("false", values[2]);
    assertEquals("true", values[3]);
    assertEquals("false", values[4]);
    assertEquals("false", values[5]);
    assertEquals("true", values[6]);
    assertEquals("true", values[7]);
    assertEquals("false", values[8]);
    assertEquals("Today was a good day.", values[9]);
  }

  @AfterEach
  public void tearDown() throws Exception {
    Files.deleteIfExists(tempPath);
  }
}
