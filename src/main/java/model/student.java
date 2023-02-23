package model;

import java.io.Serializable;

public class student implements Serializable{
	private String name;
	private String id;
	private String studentnumber;
	private String academy;
	private String subject;
	private String class1;
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	public String getId() {return id;}
	public void setId(String id) {this.id=id;}
	public String getStudentnumber() {return studentnumber;}
	public void setStudentnumber(String studentnumber) {this.studentnumber=studentnumber;}
	public String getAcademy() {return academy;}
	public void setAcademy(String academy) {this.academy=academy;}
	public String getSubject() {return subject;}
	public void setSubject(String subject) {this.subject=subject;}
	public String getClass1() {return class1;}
	public void setClass1(String class1) {this.class1=class1;}
}
