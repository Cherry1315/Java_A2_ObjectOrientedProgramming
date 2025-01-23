import java.io.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GymClass {
    //instance variables
    private String className;
    private int classID;
    private Staff personalTrainer;
    private LinkedList<Member> listOfMembers;
    private Queue<Member> queue;
    private Lock lock;


    /*
    Constructor with no parameters
     */
    public GymClass() {
    }

    /*
    Constructor with 3 parameters. Initialising our instance variables within the constructor.
     */
    public GymClass(String className, int classID, Staff personalTrainer) {
        //initialising the instance variables
        this.className = className;
        this.classID = classID;
        this.personalTrainer = personalTrainer;
        this.listOfMembers = new LinkedList<>(); //This is not in the GymClass parameter as I don't want it as an argument/requirement
        // when creating a GymClass object (not every member wants to do a class)
        this.queue = new LinkedList<Member>(); //This is not in the GymClass parameter as I don't want it as an argument/requirement
        // when creating a GymClass object (not every member wants to do/queue up for a class)
        this.lock = new ReentrantLock();
    }


    /*
    Getter
     */
    public String getClassName() {
        return className;
    }

    /*
    Setter. Using a try catch to check for an IllegalArgumentException of className being null or empty. Prints a
    message if exception happens
     */
    public void setClassName(String className) {
        try {
            if (className == null || className.isEmpty()) {
                throw new IllegalArgumentException();
            } else {
                this.className = className;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Class name is empty. Please add the name of the class being taught eg. Crossfit.");
        }
    }

    /*
    Getter
     */
    public int getClassID() {
        return classID;
    }

    /*
    Setter. Using a try catch to check for an IllegalArgumentException of classID being less or equal to 0, OR greater or
    equal to 2147483647. Prints a message if exception happens
     */
    public void setClassID(int classID) {
        try {
            if (classID <= 0 || classID > 2147483646) {
                throw new IllegalArgumentException();

            } else {
                this.classID = classID;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Class ID must be between 1 and 2147483646.");
        }
    }

    /*
    Getter
     */
    public Staff getPersonalTrainer() {
        return personalTrainer;
    }

    /*
    Setter. Using a try catch to check for an IllegalArgumentException of personalTrainer being null. Prints a message if exception happens
     */
    public void setPersonalTrainer(Staff personalTrainer) {
        try {
            if (personalTrainer == null) {
                throw new IllegalArgumentException();
            } else {
                this.personalTrainer = personalTrainer;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Personal Trainer is empty! Please add a personal trainer!");
        }
    }

    /*
    A method called addToListOfMembers that takes a parameter of Member called member. Method adds a member to our
    LinkedList called listOfMembers. Has a try catch to throw an IllegalArgumentException if member is null. Prints a
    message if exception happens. Has a lock to protect from threads -- finally makes the lock unlock no matter what!
     */
    public void addToListOfMembers(Member member) {
        lock.lock();
        try {
            if (member == null) {
                throw new IllegalArgumentException();
            } else {
                System.out.println(member + " Has been added to the list!");
                listOfMembers.add(member);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("No member has been added! Please add a member to join the list!");
        } finally {
            lock.unlock();
        }
    }

    /*
    A method called removeListMember that takes a parameter of Member called member. Method deletes a member from our
    LinkedList called listOfMembers. Prints the member deleted and a message saying so.
     */
    public void removeListMember(Member member) {
        System.out.println(member + " Has been removed from the list!");
        listOfMembers.remove(member);
    }

    /*
    A method called checkForAMember that takes a parameter of Member called member. Checks if a member is in
    listOfMembers/linkedList with the boolean return type.
     */
    public boolean checkForAMember(Member member) {
            System.out.println(member + " Is on the list!");
            return listOfMembers.contains(member);
    }

    /*
    A method called listMemberSize. Gets the size of listOfMembers/LinkedList. Has a lock to make it thread safe.
     */
    public void listMemberSize() {
        lock.lock();
        System.out.println("The gym class list size is: " + listOfMembers.size());
        lock.unlock();
    }

    /*
    A method with no parameters called iteratorPrintAllMembers. Uses an Iterator called iterator with a Member (object)
    type. This iterator wraps our LinkedList called listOfMembers that's returning an instance of iterator(). A while loop
    is used to loop through our iterator until there is no next object and then stops printing. The while loop has been
    locked to protect against threads.
    Note: The toString() method is printing the objects values, rather than printing the string representation of the object
     */
    public void iteratorPrintAllMembers() {

        //initialise the iterator
        Iterator<Member> iterator = listOfMembers.iterator();
        //loop through collection (listOfMembers) with the iterator with a while loop -- while loop will stop when there is no next object
        lock.lock();
        //message
        System.out.println("List of all members:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        lock.unlock();
    }

    /*
    A method with no parameters to sort the LinkedList. Sorts the list (listOfMember) induced by the GymClassSorter class
    comparator. This method is locked to protect against threads.
     */
    public void sortLinkedList(){
        lock.lock();
        Collections.sort(listOfMembers, new GymClassSorter());
        lock.unlock();
    }

    /*
    A method called addMemberToQueue that takes a parameter of Member called member. This method adds a member to our
    Queue list called queue. Has a try catch to throw an IllegalArgumentException if member is null. Prints a
    message if exception happens. Has a lock to protect from threads  -- finally makes the lock unlock no matter what!
     */
    //A method with a Member parameter to add members to our Queue called queue.
    public void addMemberToQueue(Member member){
        lock.lock();
        try {
            if (member == null) {
                throw new IllegalArgumentException();
            } else {
                System.out.println(member + " Has been added to the queue!");
                queue.add(member);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("No member has been added! Please add a member to join the queue!");
        } finally {
            lock.unlock();
        }
    }

    /*
    A method called removeFirstMemberFromQueue with no parameters to remove the first member from our Queue called queue
    by calling poll(). Has a lock to protect against threads
     */
    public void removeFirstMemberFromQueue(){
        lock.lock();
        System.out.println( "The first member has been removed from the queue!");
        queue.poll();
        lock.unlock();
    }

    /*
    A method called printAllQueueMembers with no parameters to print all of our queue members using peek(). A while loop
    is used to loop through the members and then deletes that member with poll(). This loop repeats until empty. Has a
    lock to protect against threads
     */
    public void printAllQueueMembers() {
        lock.lock();
        System.out.println("Members in the queue:");
        while (queue.peek() != null) {
            System.out.println(queue.poll());
        }
        lock.unlock();
    }

    /*
    A method called writeGymClassMembers that has a File parameter called fileName. Local variable BufferedWriter
    called bufferedWriter wraps fileWriter local variable (fileWriter calls the method File parameter - fileName).
    This method writes members from listOfMembers to a file using a for loop. Members information is written to a new
    line in the file with each variable separated by a comma.
    This method has a lock to protect against threads. A try and catch is used to intercept/handle any exceptions such as
    FileNotFoundException, IOException. Finally makes the bufferReader shut down and unlocks the lock no matter what
    happens with the try and catch.
     */
    public void writeGymClassMembers(File fileName) {
        BufferedWriter bufferedWriter = null; //local variable declaration
        FileWriter fileWriter = null; //local variable declaration
        lock.lock();
        try {
            fileWriter = new FileWriter(fileName); //variable initialisation
            bufferedWriter = new BufferedWriter(fileWriter); //variable initialisation
            for (Member member : listOfMembers) {
                bufferedWriter.write(member.getFirstName() + "," + member.getLastName() + "," + member.getAge() + "," + member.getMembershipID() + "," + member.getDaysLeft());
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found!");
        } catch (IOException e) {
            System.out.println("Oh no! Something went wrong when trying to write the file!");
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                System.out.println("Oh no! Something went wrong when trying to close the writing file!");
            }
            lock.unlock();
        }
    }

    /*
    A method with a return type of LinkedList<Member>. The method is called readGymClassMembers that has a File parameter
    called fileName. Local variable BufferedReader called bufferedReader wraps fileReader local variable (fileReader calls
    the readGymClassMembers File parameter - fileName). This method reads a file line by line as long as it's not 
    null/empty using a while loop. A String array called bits gets elements split by a comma. These elements remove (trim)
    any spaces. The 5 elements are indexed from 0-4 to a set value/variable (eg String firstName), and then a new Member
    object called member is created using the value/variable. Our LinkedList called listOfMembers adds our member object
    that has been extracted. Returns the LinkedList called listOfMembers.
    This method has a lock to protect against threads. A try and catch is used to intercept/handle any exceptions such as
    FileNotFoundException, IOException. Finally makes the bufferReader shut down and unlocks the lock no matter what
    happens with the try and catch.
     */
    public LinkedList<Member> readGymClassMembers(File fileName) {
        BufferedReader bufferedReader = null; //local variable declaration
        FileReader fileReader = null; //local variable declaration
        lock.lock();
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            String line; //local variable declaration
            while ((line = bufferedReader.readLine()) != null) {
                String[] bits = line.split(",");
                String firstName = bits[0].trim();
                String lastName = bits[1].trim();
                Integer age = Integer.valueOf(bits[2].trim());
                Integer membershipID = Integer.valueOf(bits[3].trim());
                Integer daysLeft = Integer.valueOf(bits[4].trim());
                Member member = new Member(firstName, lastName, age, membershipID, daysLeft);
                listOfMembers.add(member);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found!");
        } catch (IOException e) {
            System.out.println("Oh no! Something went wrong when trying to read the file!");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("Oh no! Something went wrong when trying to close reading file!");
            }
            lock.unlock();
        }
        return listOfMembers;
    }
}