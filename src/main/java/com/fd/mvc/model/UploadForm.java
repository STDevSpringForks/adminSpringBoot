package com.fd.mvc.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
public class UploadForm implements Serializable {

	private static final long serialVersionUID = -16996515120545616L;
	
	private MultipartFile[] files;

}
