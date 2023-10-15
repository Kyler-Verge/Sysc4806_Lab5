package Sysc4806_Lab5;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import jakarta.persistence.*;

//Kyler Verge
//101114854
//September 18th 2023

public class BuddyInfoTest {

    @Test
    public void testGetBuddyName() {
        //Make a buddy, checks if getBuddyName outputs the correct name
        BuddyInfo bud1 = new BuddyInfo("Kyler", "613-888-8888");
        assertEquals("Kyler", bud1.getBuddyName());
    }

    @Test
    public void testSetBuddyName() {
        //Make a buddy, change its name, and checks if the name successfully changed
        BuddyInfo bud1 = new BuddyInfo("Kyler", "613-888-8888");
        bud1.setBuddyName("Test");
        assertEquals("Test", bud1.getBuddyName());
    }

    @Test
    public void testGetBuddyPhoneNumber() {
        //Make a buddy, checks if getBuddyPhoneNumber outputs the correct phone number
        BuddyInfo bud1 = new BuddyInfo("Kyler", "613-888-8888");
        assertEquals("613-888-8888", bud1.getBuddyPhoneNumber());
    }

    @Test
    public void testSetBuddyPhoneNumber() {
        //Make a buddy, change its phone number, and checks if the phone number successfully changed
        BuddyInfo bud1 = new BuddyInfo("Kyler", "613-888-8888");
        bud1.setBuddyPhoneNumber("613-111-1111");
        assertEquals("613-111-1111", bud1.getBuddyPhoneNumber());
    }

    @Test
    public void testPersistBuddyInfo(){
        //Test persist a BuddyInfo object
        //Create 2 new BuddyInfo objects
        BuddyInfo bud1 = new BuddyInfo();
        bud1.setBuddyName("Persi");
        bud1.setBuddyPhoneNumber("613-222-2222");

        BuddyInfo bud2 = new BuddyInfo();
        bud2.setBuddyName("Pom");
        bud2.setBuddyPhoneNumber("613-333-3333");

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

        tx.commit();

        //Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of BuddyInfo objects\n-------");

        for(BuddyInfo b : results){

            System.out.println("(Name = " + b.getBuddyName() +") " + "(Phone Number = " + b.getBuddyPhoneNumber() + ") "+ "(id= " + b.getId() + ")");
        }

        //Closing connection
        em.close();

        emf.close();

    }
}