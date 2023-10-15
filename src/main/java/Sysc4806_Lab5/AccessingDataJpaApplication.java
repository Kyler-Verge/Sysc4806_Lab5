package Sysc4806_Lab5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//Kyler Verge
//101114854
//Sysc 4806 Lab 5
//October 16th 2023

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository buddyRepository, AddressBookRepository bookRepository) {
        return (args) -> {
            // save a few BuddyInfos
            buddyRepository.save(new BuddyInfo("Jack", "613"));
            buddyRepository.save(new BuddyInfo("Chloe", "612"));
            buddyRepository.save(new BuddyInfo("Kim", "611"));
            buddyRepository.save(new BuddyInfo("David", "610"));
            buddyRepository.save(new BuddyInfo("Michelle", "609"));

            // fetch all BuddyInfos
            log.info("BuddyInfos found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddy : buddyRepository.findAll()) {
                log.info(buddy.toString());
            }
            log.info("");

            // fetch an individual BuddyInfo by ID
            BuddyInfo buddy = buddyRepository.findById(1);
            log.info("BuddyInfo found with findById(1):");
            log.info("--------------------------------");
            log.info(buddy.toString());
            log.info("");

            // fetch BuddyInfos by buddyName
            log.info("BuddyInfo found with findByBuddyName('Kim'):");
            log.info("--------------------------------------------");
            buddyRepository.findByBuddyName("Kim").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");


            //Save a AddressBook that contains a BuddyInfo
            AddressBook bookTest = new AddressBook();
            bookTest.addBuddy(buddyRepository.findById(1));
            bookRepository.save(bookTest);


            // fetch an individual AddressBook by ID
            AddressBook book = bookRepository.findById(1);
            log.info("AddressBook found with findById(1):");
            log.info("--------------------------------");
            log.info(book.getBuddyInfos().toString());
            log.info("");
        };
    }

}
