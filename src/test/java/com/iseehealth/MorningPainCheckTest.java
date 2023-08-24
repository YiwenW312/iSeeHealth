package com.iseehealth;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.nio.file.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class MorningPainCheckTest {
  private Path tempPath;

  @BeforeEach
  public void setUp() throws Exception {
    tempPath = Files.createTempFile("test", ".csv");
    Constants.MORNING_PAIN_CHECK_CSV = tempPath.toString();
  }

  @Test
  public void testUpdateOrAppendToCSV() throws IOException {
    MorningPainCheck painCheck = new MorningPainCheck(true, true, false, false, false, "None");
    painCheck.updateOrAppendToCSV();

    List<String> lines = Files.readAllLines(tempPath);

    assertFalse(lines.isEmpty(), "CSV file should not be empty");

    String[] values = lines.get(0).split(",");
    assertEquals(LocalDate.now().toString(), values[0]);
    assertEquals("true", values[1]);
    assertEquals("true", values[2]);
    assertEquals("false", values[3]);
    assertEquals("false", values[4]);
    assertEquals("false", values[5]);
    assertEquals("None", values[6]);
  }

  @AfterEach
  public void tearDown() throws Exception {
    Files.deleteIfExists(tempPath);
  }
}
