package com.fd.mvc.service;

import java.nio.file.Path;

public record FileUploadResult(String fileName, Path location, long fileSize) { }
