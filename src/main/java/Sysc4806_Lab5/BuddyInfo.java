package Sysc4806_Lab5;

import jakarta.persistence.*;

import java.io.Serializable;

//Kyler Verge
//101114854
//Sysc 4806 Lab 5
//October 16th 2023

@Entity
public class BuddyInfo implements Serializable {
    //BuddyInfo Attributes

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String buddyName;
    private String buddyPhoneNumber;


    //BuddyInfo Constructor
    public BuddyInfo(String buddyName, String buddyPhoneNumber){
        this.buddyName = buddyName;
        this.buddyPhoneNumber = buddyPhoneNumber;
    }

    public BuddyInfo() {

    }

    @Override
    public String toString() {
        return String.format(
                "BuddyInfo[id=%d, buddyName='%s', phoneNumber='%s']",
                id, buddyName, buddyPhoneNumber);
    }

    public Integer getId(){
        return id;
    }

    //Returns specified Buddy Name
    public String getBuddyName(){
        return buddyName;
    }

    //Set a Buddy's Name
    public void setBuddyName(String buddyName){
        this.buddyName = buddyName;
    }

    //Returns specified Buddy Phone Number
    public String getBuddyPhoneNumber(){
        return buddyPhoneNumber;
    }

    //Set a Buddy's phone number
    public void setBuddyPhoneNumber(String buddyPhoneNumber){
        this.buddyPhoneNumber = buddyPhoneNumber;
    }

}
