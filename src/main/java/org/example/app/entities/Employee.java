package org.example.app.entities;

import java.sql.Date;

public class Employee {

    private int id;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private int positionId;
    private String phone;
    private double salary;
    private String positionName;

    public Employee() {
    }

    public Employee(int id, String lastName, String firstName, Date birthDate, String phone, int positionId, double salary) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.positionId = positionId;
        this.phone = phone;
        this.salary = salary;

    }

    public Employee(int id, String lastName, String firstName, Date birthDate, String phone, String positionName, double salary) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.positionName = positionName;
        this.phone = phone;
        this.salary = salary;

    }

    public String getPositionName() {
        return positionName;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
