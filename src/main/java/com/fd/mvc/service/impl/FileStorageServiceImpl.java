package com.fd.mvc.service.impl;

import com.fd.mvc.service.FileStorageService;
import com.fd.mvc.service.FileUploadResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation that stores files in a directory on the local file system.
 */
@Service("fileStorageService")
public class FileStorageServiceImpl implements FileStorageService {

    private static final Logger log = LoggerFactory.getLogger(FileStorageServiceImpl.class);

    private final Path uploadDir;

    public FileStorageServiceImpl(@Value("${upload.directory:${java.io.tmpdir}}") String uploadDir) {
        this.uploadDir = Paths.get(uploadDir);
    }

    @Override
    public List<FileUploadResult> storeFiles(MultipartFile[] files) {
        List<FileUploadResult> results = new ArrayList<>();
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            try {
                Files.createDirectories(uploadDir);
                Path destination = uploadDir.resolve(file.getOriginalFilename());
                Files.write(destination, file.getBytes());
                results.add(new FileUploadResult(
                        file.getOriginalFilename(),
                        destination,
                        file.getSize()));
            } catch (IOException e) {
                log.error("Error saving file {}", file.getOriginalFilename(), e);
            }
        }
        return results;
    }
}
