package edu.jspiders.mycontacts.dto;

public class MyContacts
{
	private String name;
	private long number;
	private String emailId;
	private String DOB;
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) 
	{
		this.number = number;
	}
	public String getEmailId() 
	{
		return emailId;
	}
	public void setEmailId(String emailId) 
	{
		this.emailId = emailId;
	}
	public String getDOB() 
	{
		return DOB;
	}
	public void setDOB(String i)
	{
		DOB = i;
	}
}
