package model;

import java.io.Serializable;

public class dayclock implements Serializable{
	private String date;
	private String number;
	private String academy;
	private String result;
	private String code;
	public String getDate() {return date;}
	public void setDate(String date) {this.date=date;}
	public String getNumber() {return number;}
	public void setNumber(String number) {this.number=number;}
	public String getResult() {return result;}
	public void setResult(String result) {this.result=result;}
	public String getAcademy() {return academy;}
	public void setAcademy(String academy) {this.academy=academy;}
	public String getCode() {return code;}
	public void setCode(String code) {this.code=code;}
}
