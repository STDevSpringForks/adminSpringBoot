package com.fd.adminHome.data_service.gastos.service;

/**
 * 
 * @author Muguruza
 *
 */
public class StorageException extends RuntimeException {

    private static final long serialVersionUID = 2318252734368058061L;

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
