package com.fd.mvc.admin.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * 
 * @author Muguruza
 *
 */
public class UploadForm implements Serializable {

	private static final long serialVersionUID = -16996515120545616L;
	
	private MultipartFile[] files;

	    public MultipartFile[] getFiles() {
	        return files;
	    }

	    public void setFiles(MultipartFile[] files) {
	        this.files = files;
	    }
	
}