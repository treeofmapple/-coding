package application;

import java.util.Date;

public class policeData {
    private int id;
    private String username;
    private String password;
    private String position;
    private char gender;
    private int timeWorked;
    private int peopleArrested;
    private Date startedTime;
    private boolean active;
    private Date accessDate;

    public policeData() {
    }

    public policeData(String username, String password, String position, char gender, Date startedTime) {
        this.username = username;
        this.password = password;
        this.position = position;
        this.gender = gender;
        this.timeWorked = 0; // Default value
        this.peopleArrested = 0; // Default value
        this.startedTime = startedTime;
        this.active = true; // Default value
        this.accessDate = null; // Default value
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getTimeWorked() {
        return timeWorked;
    }

    public void setTimeWorked(int timeWorked) {
        this.timeWorked = timeWorked;
    }

    public int getPeopleArrested() {
        return peopleArrested;
    }

    public void setPeopleArrested(int peopleArrested) {
        this.peopleArrested = peopleArrested;
    }

    public Date getStartedTime() {
        return startedTime;
    }

    public void setStartedTime(Date startedTime) {
        this.startedTime = startedTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
    }
}
