package com.bensaltana.book.file;

import com.bensaltana.book.book.Book;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileStorageService {
    @Value("${application.file.upload.photos-output-path}")
    private String fileUploadPath;
    public String saveFile(@Nonnull MultipartFile sourceFile,
                           @Nonnull Integer userId) {
        final String fileUploadSubPath="users" + File.separator+ userId;
        return uploadFile(sourceFile, fileUploadSubPath);
    }

    private String uploadFile(@Nonnull MultipartFile sourceFile,
                              @Nonnull String fileUploadSubPath) {
        final String finalUploadPath = fileUploadPath + File.separator + fileUploadSubPath;
        File targetFolder = new File(finalUploadPath);
        if (!targetFolder.exists()) {
            boolean created = targetFolder.mkdirs();
            if (!created) {
                log.warn("Failed to create directory: {}", finalUploadPath);
                return null;
            }
        }

        final String fileExtension = getFileExtension(sourceFile.getOriginalFilename());
        String targetFilePath = finalUploadPath + File.separator
                + System.currentTimeMillis() + "." + fileExtension;
        Path targetPath = Path.of(targetFilePath);
        try {
            Files.write(targetPath, sourceFile.getBytes());
            log.info("File saved: {}", targetFilePath);
            return targetFilePath;
        } catch (Exception e) {
            log.error("Failed to save file: {}", e.getMessage());
            return null;
        }
    }

    private String getFileExtension(String originalFilename) {
        if (originalFilename == null || originalFilename.isEmpty()) {
            return null;
        } else {
            return originalFilename
                    .substring(originalFilename.lastIndexOf("."))
                    .toLowerCase();
        }
    }
}
