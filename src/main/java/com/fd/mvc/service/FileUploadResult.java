package com.fd.mvc.service;

import java.nio.file.Path;

/**
 * Represents the result of storing a file on disk.
 *
 * @param fileName original name of the uploaded file
 * @param location final storage location
 * @param fileSize size of the uploaded file in bytes
 */
public record FileUploadResult(String fileName, Path location, long fileSize) { }
