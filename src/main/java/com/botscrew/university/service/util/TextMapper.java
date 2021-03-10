package com.botscrew.university.service.util;

import com.botscrew.university.service.ids.Describable;

import java.util.List;
import java.util.stream.Collectors;

import static com.botscrew.university.config.TemplateConfig.NOT_FOUND;

public class TextMapper {
  public static String map(String text, String oldSequence, List<? extends Describable> items) {
    return text.replace(oldSequence,
        items.isEmpty() ?
            NOT_FOUND :
            items.stream().map(Describable::desc).collect(Collectors.joining("\n\t")));
  }
}
