package com.devglan.exception;

public class FileStorageException extends RuntimeException {

	private static final long serialVersionUID = -8203533810636671743L;

	public FileStorageException(String message) {
		super(message);
	}

	public FileStorageException(String message, Throwable cause) {
		super(message, cause);
	}
}
