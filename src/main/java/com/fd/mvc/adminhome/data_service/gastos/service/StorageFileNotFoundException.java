package com.fd.mvc.adminhome.data_service.gastos.service;

/**
 * 
 * @author Muguruza
 *
 */
public class StorageFileNotFoundException extends StorageException {

    private static final long serialVersionUID = -7617168370656316719L;

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
