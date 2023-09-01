package com.project.exception;

@SuppressWarnings("serial")
public class ProjectExistsException extends Exception {
	public ProjectExistsException(String msg) {
		super(msg);
	}
	public ProjectExistsException() {
	}


}
