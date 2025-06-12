package com.fd.mvc.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Service responsible for storing multipart files in the configured directory.
 */
public interface FileStorageService {

    /**
     * Stores the provided files and returns the results of each operation.
     *
     * @param files files to store
     * @return list with the result for each stored file
     */
    List<FileUploadResult> storeFiles(MultipartFile[] files);
}
