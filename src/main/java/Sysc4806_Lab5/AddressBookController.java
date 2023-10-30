package Sysc4806_Lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Kyler Verge
//101114854
//Sysc 4806 Lab 5
//October 16th 2023

@RestController
public class AddressBookController {

    @Autowired
    AddressBookRepository repo;

    @PostMapping("/addressbooks")
    public AddressBook createAddressBook(){
        return repo.save(new AddressBook());
    }

    @PostMapping(path = "/addressbooks/{id}/addBuddyback")
    public AddressBook addBuddy(@PathVariable Integer id, @RequestBody BuddyInfo buddy){
        AddressBook addressBook = repo.findById(id).orElseThrow();
        addressBook.addBuddy(buddy);
        System.out.println("test add buddy");
        return repo.save(addressBook);
    }

    @PostMapping("/addressbooks/{id}/removeBuddy")
    public AddressBook removeBuddy(@PathVariable Integer id, @RequestBody BuddyInfo buddy){
        AddressBook addressBook = repo.findById(id).orElseThrow();
        addressBook.removeBuddy(buddy);
        return repo.save(addressBook);
    }

}
