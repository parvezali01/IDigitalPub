package com.project.exception;

@SuppressWarnings("serial")
public class ProjectNotFoundException extends Exception{
	public ProjectNotFoundException(String msg){
		super(msg);
	}

	public ProjectNotFoundException() {
	}


}
