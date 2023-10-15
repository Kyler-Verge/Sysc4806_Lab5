package Sysc4806_Lab5;

import org.junit.Test;

import jakarta.persistence.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

//Kyler Verge
//101114854
//September 18th 2023

public class AddressBookTest {

    @Test
    public void testAddBuddy() {
        //Test AddressBooks addBuddy method with one buddy
        AddressBook book1 = new AddressBook();
        BuddyInfo bud1 = new BuddyInfo("Kyler", "613-888-8888");
        book1.addBuddy(bud1);
        assertEquals(1, book1.getAddressBookSize());

        //Test with three buddies
        BuddyInfo bud2 = new BuddyInfo("Kyler", "613-888-8888");
        BuddyInfo bud3 = new BuddyInfo("Kyler", "613-888-8888");
        book1.addBuddy(bud2);
        book1.addBuddy(bud3);
        assertEquals(3, book1.getAddressBookSize());
    }

    @Test
    public void testRemoveBuddy() {
        //Test AddressBooks removeBuddy method with one buddy
        AddressBook book1 = new AddressBook();
        BuddyInfo bud1 = new BuddyInfo("Kyler", "613-888-8888");
        book1.addBuddy(bud1);
        assertEquals(1, book1.getAddressBookSize());
        book1.removeBuddy(bud1);
        assertEquals(0, book1.getAddressBookSize());

        //Test with three buddies
        BuddyInfo bud2 = new BuddyInfo("Rex", "613-222-2222");
        BuddyInfo bud3 = new BuddyInfo("Lance", "613-333-3333");
        book1.addBuddy(bud1);
        book1.addBuddy(bud2);
        book1.addBuddy(bud3);
        assertEquals(3, book1.getAddressBookSize());
        book1.removeBuddy(bud1);
        assertEquals(2, book1.getAddressBookSize());
        book1.removeBuddy(bud2);
        assertEquals(1, book1.getAddressBookSize());
        book1.removeBuddy(bud3);
        assertEquals(0, book1.getAddressBookSize());
    }

    @Test
    public void testGetAddressBookSize() {
        //Test AddressBooks getAddressBookSize method with one buddy
        AddressBook book1 = new AddressBook();
        BuddyInfo bud1 = new BuddyInfo("Kyler", "613-888-8888");
        assertEquals(0, book1.getAddressBookSize());

        book1.addBuddy(bud1);
        assertEquals(1, book1.getAddressBookSize());

    }

    @Test
    public void testGetAddressBook() {
        //Test AddressBooks getAddressBook method
        AddressBook book1 = new AddressBook();
        BuddyInfo bud1 = new BuddyInfo("Kyler", "613-888-8888");
        //Test for if the Address Book is empty, output should be a warning message
        book1.getAddressBook();
        //Test for when a buddy is in the Address Book, output should display bud1 info
        book1.addBuddy(bud1);
        book1.getAddressBook();
    }

    @Test
    public void testPersistAddressBook(){
        //Test persist a BuddyInfo object
        //Create 2 new BuddyInfo objects
        BuddyInfo bud1 = new BuddyInfo();
        bud1.setBuddyName("Persi");
        bud1.setBuddyPhoneNumber("613-222-2222");

        BuddyInfo bud2 = new BuddyInfo();
        bud2.setBuddyName("Pom");
        bud2.setBuddyPhoneNumber("613-333-3333");

        //Create new AddressBook
        AddressBook bookTest = new AddressBook();
        bookTest.setId(1);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test-lab2");
        EntityManager em = emf.createEntityManager();

        //Creating a new transaction
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Persisting the BuddyInfo entity objects
        em.persist(bud1);
        em.persist(bud2);

        //Adding persisted BuddyInfos to AddressBook
        bookTest.addBuddy(bud1);
        bookTest.addBuddy(bud2);

        em.persist(bookTest);

        tx.commit();

        //Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT a FROM AddressBook a");

        List<AddressBook> results = q.getResultList();

        System.out.println("List of BuddyInfo objects\n-------");

        for(AddressBook a : results){

            a.getAddressBook();
        }

        //Closing connection
        em.close();

        emf.close();
    }
}