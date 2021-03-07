package com.botscrew.university.service.executor;

import com.botscrew.university.service.util.SourceFileReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HelpExecutor implements CommandExecutor {

  @Value(value = "${reader.files.helpfile}")
  private String helpFileURI;

  @Override public String execute(String arg) throws IOException {
    return SourceFileReader.read(helpFileURI);
  }
}
