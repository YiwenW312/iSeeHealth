package com.iseehealth;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.*;
import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DietCheckTest {

  private Path tempPath;

  @BeforeEach
  public void setUp() throws Exception {
    tempPath = Files.createTempFile("testDiet", ".csv");
    Constants.DIET_CHECK_CSV = tempPath.toString();
  }

  @Test
  public void testUpdateOrAppendToCSV() throws IOException {
    DietCheck dietCheck = new DietCheck(30, 40, 30, true, false, true, false, true, false, "Potato Chips");
    dietCheck.updateOrAppendToCSV();

    List<String> lines = Files.readAllLines(tempPath);

    assertFalse(lines.isEmpty(), "CSV file should not be empty");

    String[] values = lines.get(0).split(",");
    assertEquals(LocalDate.now().toString(), values[0]);
    assertEquals("30", values[1]);
    assertEquals("40", values[2]);
    assertEquals("30", values[3]);
    assertEquals("true", values[4]);
    assertEquals("false", values[5]);
    assertEquals("true", values[6]);
    assertEquals("false", values[7]);
    assertEquals("true", values[8]);
    assertEquals("false", values[9]);
    assertEquals("Potato Chips", values[10]);
  }

  @AfterEach
  public void tearDown() throws Exception {
    Files.deleteIfExists(tempPath);
  }
}
