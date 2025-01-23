//import java.util.Collections;

import java.io.File;
import java.util.LinkedList;

public class AssignmentTwo {
    public static void main(String[] args) {
        // Creating an object of AssignmentTwo called assignment
        AssignmentTwo assignment = new AssignmentTwo();

        // calling a method
        assignment.partOne();

        // calling a method
        assignment.partTwo();

        // calling a method
        assignment.partThree();

        // calling a method
        assignment.partFour();

        // calling a method
        assignment.partFive();

        // calling a method
        assignment.partSix();
    }

    /*
     * Method called partOne that has no parameters
     */
    public void partOne() {
        // Creating a Staff object called personalTrainer1
        Staff personalTrainer1 = new Staff("Annika", "Belmount", 30, 23.45, 1);

        // Creating a GymClass object called gymClass1
        GymClass gymClass1 = new GymClass("Yoga", 1000, personalTrainer1);

        // Creating 5 Member objects
        Member mem1 = new Member("Snape", "Hydle", 50, 1, 90);
        Member mem2 = new Member("Plazzo", "King", 12, 4444, 105);
        Member mem3 = new Member("Astoria", "Ethel", 21, 378, 90);
        Member mem4 = new Member("Draconis", "Eta", 22, 42, 105);
        Member mem5 = new Member("Rhys", "Zavance", 77, 3421, 30);

        // Assigning/adding the 5 Member objects to our LinkedList called gymClass1
        // (using our addToListOfMembers() method originating from GymClass).
        gymClass1.addToListOfMembers(mem1);
        gymClass1.addToListOfMembers(mem2);
        gymClass1.addToListOfMembers(mem3);
        gymClass1.addToListOfMembers(mem4);
        gymClass1.addToListOfMembers(mem5);

        // Checking if a Member is in our LinkedList/gymClass1 (using our
        // checkForAMember() method originating from GymClass).
        gymClass1.checkForAMember(mem2);

        // Deleting our Member from our LinkedList/gymClass1 (using our
        // removeListMember() method originating from GymClass)
        gymClass1.removeListMember(mem2);

        // Printing the number of Members in gymClass1 (using our listMemberSize()
        // method originating from GymClass)
        gymClass1.listMemberSize();

        // Printing/iterating through all our Members within out LinkedList called
        // gymClass1 (using our printAllMembers() method originating from GymClass).
        gymClass1.iteratorPrintAllMembers();
    }

    /*
     * Method called partTwo that has no parameters
     */
    public void partTwo() {
        // Creating a Staff object called personalTrainer2
        Staff personalTrainer2 = new Staff("Scooby", "Doo", 11, 23.45, 2);

        // Creating a GymClass object called gymClass1
        GymClass gymClass2 = new GymClass("Pilates", 1000, personalTrainer2);

        // Creating 5 Member objects.
        Member mem1 = new Member("Apple", "Pear", 20, 11, 30);
        Member mem2 = new Member("Apple", "Orange", 23, 123, 60);
        Member mem3 = new Member("Pitaya", "Carambola", 33, 4123, 90);
        Member mem4 = new Member("Lychee", "Mango", 45, 4657, 120);
        Member mem5 = new Member("Grape", "Watermelon", 33, 1111, 2);

        // Adding our members to the GymClass list called gymClass2.
        gymClass2.addToListOfMembers(mem1);
        gymClass2.addToListOfMembers(mem2);
        gymClass2.addToListOfMembers(mem3);
        gymClass2.addToListOfMembers(mem4);
        gymClass2.addToListOfMembers(mem5);

        // Printing/iterating though our LinkedList of gymClass2 members
        gymClass2.iteratorPrintAllMembers();

        // sorting our gymClass2 LinkedList of members
        gymClass2.sortLinkedList();

        // Printing/iterating though our gymClass2 LinkedList of members to see if
        // previous sorting method worked
        gymClass2.iteratorPrintAllMembers();
    }

    /*
     * Method called partThree that has no parameters
     */
    public void partThree() {
        // Creating a Staff object called personalTrainer3
        Staff personalTrainer3 = new Staff("Naruto", "Uzumaki", 25, 26.45, 3);

        // Creating a GymClass object called gymClass3
        GymClass gymClass3 = new GymClass("Boxing", 497, personalTrainer3);

        // Creating 5 Member objects.
        Member mem10 = new Member("Sasuke", "Uchiha", 25, 134, 3);
        Member mem11 = new Member("Hinata", "Hyuga", 26, 20, 100);
        Member mem12 = new Member("Kakashi", "Hatake", 40, 1425, 6);
        Member mem13 = new Member("Rock", "Lee", 27, 123, 150);
        Member mem14 = new Member("Sakura", "Haruno", 25, 532, 60);

        // Adding our gymClass3 members to a Queue.
        gymClass3.addMemberToQueue(mem10);
        gymClass3.addMemberToQueue(mem11);
        gymClass3.addMemberToQueue(mem12);
        gymClass3.addMemberToQueue(mem13);
        gymClass3.addMemberToQueue(mem14);

        // Removing the first gymClass3 member from the queue
        gymClass3.removeFirstMemberFromQueue();

        // Printing (and also deleting) through our gymClass3 queue
        gymClass3.printAllQueueMembers();
    }

    /*
     * Method called partFour that has no parameters
     */
    public void partFour() {
        // Creating a new Person object called person
        Person person = new Person();
        // Setting person first name
        person.setFirstName("Sally");
        // Setting person last name
        person.setLastName("Smith");
        // Setting the person age
        person.setAge(5);
        // printing person to the console
        Person.printAll(person);

        // Trying to set the person first name with an IllegalArgumentException
        person.setFirstName("");
        // Trying to set the person last name with an IllegalArgumentException
        person.setLastName(null);
        // Trying to set the person age with an IllegalArgumentException
        person.setAge(0);
        // Printing out the person object to see if the IllegalArgumentException did
        // what it was supposed to... not accept it!
        Person.printAll(person);
    }

    /*
     * Method called partFive that has no parameters
     */
    public void partFive() {
        // Creating as file object called file and giving it a pathname/directory.
        File file = new File("C:\\Users\\best sister\\OneDrive\\Desktop\\test1.csv");

        // Creating a Staff object called personalTrainer2
        Staff personalTrainer2 = new Staff("Esmay", "Potter", 11, 23.45, 2);

        // Creating a GymClass object called gymClass2
        GymClass gymClass2 = new GymClass("Pilates", 1000, personalTrainer2);

        // Creating 5 Member objects.
        Member mem1 = new Member("Theodore", "Edith", 20, 11, 30);
        Member mem2 = new Member("Eleanor", "Amos", 23, 123, 60);
        Member mem3 = new Member("Silas", "Emma", 33, 4123, 90);
        Member mem4 = new Member("Rosemary", "Walter", 45, 4657, 120);
        Member mem5 = new Member("Ida", "Lucinda", 33, 1111, 2);

        // Adding our members to the GymClass called gymClass2.
        gymClass2.addToListOfMembers(mem1);
        gymClass2.addToListOfMembers(mem2);
        gymClass2.addToListOfMembers(mem3);
        gymClass2.addToListOfMembers(mem4);
        gymClass2.addToListOfMembers(mem5);

        // exporting the gymClass2 members to a file
        gymClass2.writeGymClassMembers(file);
    }

    /*
     * Method called partSix that has no parameters
     */
    public void partSix() {
        // Creating as file object called file and giving it a pathname/directory.
        File file = new File("C:\\Users\\best sister\\OneDrive\\Desktop\\test1.csv");

        // Creating a Staff object called personalTrainer2
        Staff personalTrainer2 = new Staff("Esmay", "Potter", 11, 23.45, 2);

        // Creating a GymClass object called gymClass
        GymClass gymClass = new GymClass("Crossfit", 1000, personalTrainer2);

        // reading our exported file from partFive and importing our gymClass members
        // from the file
        gymClass.readGymClassMembers(file);

        // Counting how many gymClass members were on the file that we imported
        gymClass.listMemberSize();
    }
}