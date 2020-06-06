package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import models.Assessment;

@Entity
public class Member extends Model {
    public String firstname;
    public String lastname;
    public String email;
    public String password;
    public String address;
    public String gender;
    public double height;
    public double CurrentBMI;
    private double startingWeight;
    public Assessment assessment;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Assessment> assessmentList = new ArrayList<Assessment>();

    public Member(String firstname, String lastname, String email, String password, String address,
                  String gender, double height, float startingWeight) {
        setFirstname(firstname);
        setLastname(lastname);
        setEmail(email);
        setPassword(password);
        setAddress(address);
        setGender(gender);
        setHeight(height);
        setStartingWeight(startingWeight);
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setStartingWeight(double startingWeight) {
        this.startingWeight = startingWeight;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }

    public double getStartingWeight() {
        return startingWeight;
    }

    public double getCurrentBMI() {
        return CurrentBMI;
    }

    public double calculateBMI() {
        return CurrentBMI;
    }

    public static Member findByEmail(String email) {
        return find("email", email).first();
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }


}
