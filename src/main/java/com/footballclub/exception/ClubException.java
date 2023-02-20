package com.footballclub.exception;

public class ClubException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String massage;
	String details;

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public ClubException(String massage, String details) {
		this.massage = massage;
		this.details = details;
	}

	public ClubException() {
		super();
	}

}
