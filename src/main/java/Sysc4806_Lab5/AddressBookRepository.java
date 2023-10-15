package Sysc4806_Lab5;

import org.springframework.data.repository.CrudRepository;

//Kyler Verge
//101114854
//Sysc 4806 Lab 5
//October 16th 2023

public interface AddressBookRepository extends CrudRepository<AddressBook, Integer>{

    AddressBook findById(int id);
}
