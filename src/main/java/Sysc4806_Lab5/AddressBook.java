package Sysc4806_Lab5;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import jakarta.persistence.*;

//Kyler Verge
//101114854
//Sysc 4806 Lab 5
//October 16th 2023

@Entity
public class AddressBook implements Serializable{

    @Id
    private Integer id = null;

    private Collection<BuddyInfo> buddyInfos;

    //Create new instance of AddressBook
    public AddressBook(){
        buddyInfos = new HashSet();
    }

    //Gets the id of this AddressBook
    @Id
    @GeneratedValue
    public Integer getId(){
        return this.id;
    }

    //Sets the id of this AddressBook to the specified value
    public void setId(Integer id){
        this.id = id;
    }

    //Connection to BuddyInfo, One AddressBook to Many BuddyInfos

    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    public Collection<BuddyInfo> getBuddyInfos(){
        return buddyInfos;
    }

    public void setBuddyInfos(Collection<BuddyInfo> buddyInfos) {
        this.buddyInfos = buddyInfos;
    }

    //Adds a Buddy object to the given Address Book
    public void addBuddy(BuddyInfo buddy) {
        buddyInfos.add(buddy);
    }


    //Removes a Buddy object from the specified index of the given Address Book
    public void removeBuddy(BuddyInfo buddy){
        if (buddyInfos.isEmpty()) {
            System.out.print("The Address Book is empty!" + "\n");
        }
        buddyInfos.remove(buddy);
    }

    @Override
    public String toString() {
        return String.format(
                "AddressBook[id=%d, buddyInfos='%s']",
                id, buddyInfos);
    }

    //Prints out all the Buddy object names and phone numbers of the given Address Book
    public void getAddressBook(){
        if (buddyInfos.isEmpty()){
            System.out.print("The Address Book is empty!" + "\n");
        }
        else{
            for (BuddyInfo buddyInfo : buddyInfos){
                System.out.println("Name= " + buddyInfo.getBuddyName() + " Phone Number= " + buddyInfo.getBuddyPhoneNumber() + " Id= " + buddyInfo.getId());
            }
        }
    }
}


