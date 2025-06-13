package com.fd.mvc.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileStorageService {

    List<FileUploadResult> storeFiles(MultipartFile[] files);
}
