package com.botscrew.university.service.executor;

import javax.management.InvalidAttributeValueException;
import javax.persistence.EntityNotFoundException;
import java.io.IOException;

public interface CommandExecutor {
  String execute(String arg) throws IOException, EntityNotFoundException, InvalidAttributeValueException;
}
