package application;

import java.sql.Date;

public class criminalData {
    private Integer criminalID;
    private String firstName;
    private String lastName;
    private String gender;
    private String due;
    private String image;
    private Date arresttime;
    private boolean arrested;
    private boolean setArrest;

    public criminalData(Integer criminalId, String firstName, String lastName, String gender, String due, Date arrestTime, boolean arrested, boolean setArrest) {
        this.criminalID = criminalId;
    	this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.arresttime = arrestTime;
        this.due = due;
        this.arrested = arrested;
        this.setArrest = setArrest;
    }

    public criminalData(Integer criminalId, String firstName, String lastName, String gender, String due, String image, Date arrestTime, boolean arrested, boolean setArrest) {
        this.criminalID = criminalId;
    	this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.image = image;
        this.arresttime = arrestTime;
        this.due = due;
        this.arrested = arrested;
        this.setArrest = setArrest;
    }

    public Integer getCriminalId() {
        return criminalID;
    }

    public void setCriminalId(Integer criminalId) {
        this.criminalID = criminalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getArrestTime() {
        return arresttime;
    }

    public void setArrestTime(Date arrestTime) {
        this.arresttime = arrestTime;
    }

    public boolean isArrested() {
        return arrested;
    }

    public void setArrested(boolean arrested) {
        this.arrested = arrested;
    }

    public boolean isSetArrest() {
        return setArrest;
    }

    public void setSetArrest(boolean setArrest) {
        this.setArrest = setArrest;
    }
}
