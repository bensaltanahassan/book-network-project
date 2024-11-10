package com.bensaltana.book.file;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.nio.file.Files;
import java.nio.file.Path;


@Slf4j
public class FileUtils {
    public static byte[] readFileFromLocation(String fileUrl) {
        if(StringUtils.isBlank(fileUrl)) {
            return null;
        }
        try {
            Path path = Path.of(fileUrl);
            return Files.readAllBytes(path);
        } catch (Exception e) {
            log.error("Failed to read file: {}", e.getMessage());
            return null;
        }

    }
}
