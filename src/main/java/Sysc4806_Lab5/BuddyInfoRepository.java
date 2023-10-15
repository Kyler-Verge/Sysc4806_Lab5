package Sysc4806_Lab5;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Kyler Verge
//101114854
//Sysc 4806 Lab 5
//October 16th 2023

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {

    List<BuddyInfo> findByBuddyName(String buddyName);

    BuddyInfo findById(int id);

}
