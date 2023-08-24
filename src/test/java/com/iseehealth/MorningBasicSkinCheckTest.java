package com.iseehealth;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.*;
import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MorningBasicSkinCheckTest {

  private Path tempPath;

  @BeforeEach
  public void setUp() throws Exception {
    tempPath = Files.createTempFile("testSkin", ".csv");
    Constants.MORNING_BASIC_SKIN_CHECK_CSV = tempPath.toString();
  }

  @Test
  public void testUpdateOrAppendToCSV() throws IOException {
    MorningBasicSkinCheck skinCheck = new MorningBasicSkinCheck(60, "120/80", true, false, true, false, true, "Dryness");
    skinCheck.updateOrAppendToCSV();

    List<String> lines = Files.readAllLines(tempPath);

    assertFalse(lines.isEmpty(), "CSV file should not be empty");

    String[] values = lines.get(0).split(",");
    assertEquals(LocalDate.now().toString(), values[0]);
    assertEquals("60", values[1]);
    assertEquals("120/80", values[2]);
    assertEquals("true", values[3]);
    assertEquals("false", values[4]);
    assertEquals("true", values[5]);
    assertEquals("false", values[6]);
    assertEquals("true", values[7]);
    assertEquals("Dryness", values[8]);
  }

  @AfterEach
  public void tearDown() throws Exception {
    Files.deleteIfExists(tempPath);
  }
}
