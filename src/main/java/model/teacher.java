package model;

import java.io.Serializable;

public class teacher implements Serializable{
private String name;
private String id;
private String jobnumber;
private String academy;
private String role;
public String getName() {return name;}
public void setName(String name) {this.name=name;}
public String getId() {return id;}
public void setId(String id) {this.id=id;}
public String getJobnumber() {return jobnumber;}
public void setJobnumber(String jobnumber) {this.jobnumber=jobnumber;}
public String getAcademy() {return academy;}
public void setAcademy(String academy) {this.academy=academy;}
public String getRole() {return role;}
public void setRole(String role) {this.role=role;}
}
