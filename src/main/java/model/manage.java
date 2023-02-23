package model;

import java.io.Serializable;

public class manage implements Serializable{
private String jobnumber;
private String password;
public void setJobnumber(String jobnumber) {this.jobnumber=jobnumber;}
public String getJobnumber() {return jobnumber;}
public void setPassword(String password) {this.password=password;}
public String getPassword() {return password;}
}
