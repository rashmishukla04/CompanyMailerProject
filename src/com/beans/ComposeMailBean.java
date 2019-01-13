package com.beans;

public class ComposeMailBean 
{
	private String email; 
	private String receiver;
	private String subject;
	private String message;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ComposeMailBean(String email, String receiver, String subject, String message) {
		super();
		this.email = email;
		this.receiver = receiver;
		this.subject = subject;
		this.message = message;
	}
	@Override
	public String toString() {
		return "ComposeMailBean [email=" + email + ", receiver=" + receiver + ", subject=" + subject + ", message="
				+ message + "]";
	}
	

}
