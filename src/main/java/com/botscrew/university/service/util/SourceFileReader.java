package com.botscrew.university.service.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicReference;
public class SourceFileReader {
  public static String read(String path) throws IOException {
    StringBuilder result = new StringBuilder("");
    Files.lines(Paths.get(path), StandardCharsets.UTF_8).forEach(s -> result.append(s).append("\n"));
    return String.valueOf(result);
  }
}
