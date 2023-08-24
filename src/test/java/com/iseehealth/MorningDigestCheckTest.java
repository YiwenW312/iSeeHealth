package com.iseehealth;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.*;
import java.io.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MorningDigestCheckTest {

  private Path tempPath;

  @BeforeEach
  public void setUp() throws Exception {
    tempPath = Files.createTempFile("testDigest", ".csv");
    Constants.MORNING_DIGEST_CHECK_CSV = tempPath.toString();
  }

  @Test
  public void testUpdateOrAppendToCSV() throws IOException {
    MorningDigestCheck digestCheck = new MorningDigestCheck(true, false, true, false, true, false, "Nausea");
    digestCheck.updateOrAppendToCSV();

    List<String> lines = Files.readAllLines(tempPath);

    assertFalse(lines.isEmpty(), "CSV file should not be empty");

    String[] values = lines.get(0).split(",");
    assertEquals(LocalDate.now().toString(), values[0]);
    assertEquals("true", values[1]);
    assertEquals("false", values[2]);
    assertEquals("true", values[3]);
    assertEquals("false", values[4]);
    assertEquals("true", values[5]);
    assertEquals("false", values[6]);
    assertEquals("Nausea", values[7]);
  }

  @AfterEach
  public void tearDown() throws Exception {
    Files.deleteIfExists(tempPath);
  }
}
