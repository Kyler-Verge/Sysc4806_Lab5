package Sysc4806_Lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//Kyler Verge
//101114854
//Sysc 4806 Lab 5
//October 16th 2023

@Controller
public class viewController {

    @Autowired
    AddressBookRepository repo;

    @GetMapping("/addressbooks/{id}")
    public String addressBook(Model model, @PathVariable Integer id) {
        model.addAttribute("addressBook", repo.findById(id));
        model.addAttribute("buddyInfo" , new BuddyInfo());
        return "addressbooks";
    }

    @GetMapping("/addressbooks")
    public String addressBooks(Model model) {
        model.addAttribute("addressBook", repo.findById(1));
        model.addAttribute("buddyInfo" , new BuddyInfo());
        return "addressbooks";
    }

    @PostMapping("/addressbooks/{id}/addBuddyfront")
    public String addBuddy(@PathVariable Integer id, @ModelAttribute BuddyInfo buddy){
        AddressBook addressBook = repo.findById(id).orElseThrow();
        addressBook.addBuddy(buddy);
        System.out.println("test add buddy");
        repo.save(addressBook);
        return "redirect:/addressbooks";
    }


}
