package edu.mum.finalexam.model.dto;

public class DomainError {
	private String field;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	private String message;
 
    public DomainError() {}
	public DomainError(String message) {
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage( ) {
		return message;
	}
  	}
	
 
