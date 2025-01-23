public class Person {
    //instance variables
    private String firstName;
    private String lastName;
    private int age;


    /*
    Constructor with no parameters
     */
    public Person() {
    }

    /*
    Constructor with 3 parameters. Throws an IllegalArgumentException and using a try catch. Initialising our instance
    variables within the constructor with IllegalArgumentException.
    NOTE: The arguments/exceptions here were not needed for assignment! I might have implemented this incorrectly but wanted to try.
     */
    public Person(String firstName, String lastName, int age) throws IllegalArgumentException{
        try {
            if (firstName == null || firstName.isEmpty()) {
                throw new IllegalArgumentException();
            } else {
                this.firstName = firstName;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("First name is empty. Please add a first name.");
        }

        try {
            if (lastName == null || lastName.isEmpty()) {
                throw new IllegalArgumentException();
            } else {
                this.lastName = lastName;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Last name is empty. Please add a last name.");
        }

        try {
            if (age <= 0 || age >= 120) {
                throw new IllegalArgumentException();
            } else {
                this.age = age;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Age must be between 1 and 119");
        }
    }


    /*
    Getter
     */
    public String getFirstName() {
        return firstName;
    }

    /*
    Setter. IllegalArgumentException using a try catch to check if the first name is null or empty. Prints a message if
    exception happens
     */
    public void setFirstName(String firstName){
        try {
            if (firstName == null || firstName.isEmpty()) {
                throw new IllegalArgumentException();
            } else {
                this.firstName = firstName;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("First name is empty. Please add a first name.");
        }
    }

    /*
    Getter
     */
    public String getLastName() {
        return lastName;
    }

    /*
    Setter. IllegalArgumentException using a try catch to check if the last name is null or empty. Prints a message if
    exception happens
     */
    public void setLastName(String lastName) {
        try {
            if (lastName == null || lastName.isEmpty()) {
                throw new IllegalArgumentException();
            } else {
                this.lastName = lastName;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Last name is empty. Please add a last name.");
        }
    }

    /*
    Getter
     */
    public int getAge() {
        return age;
    }

    /*
    Setter. IllegalArgumentException using a try catch to check if the age is 0 or less, or if age is greater or equal
    to 120. Prints a message if exception happens
     */
    public void setAge(int age) {
        try {
            if (age <= 0 || age >= 120) {
                throw new IllegalArgumentException();
            } else {
                this.age = age;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Age must be between 1 and 119");
        }
    }

    /*
    Overriding Object class via using toString() method (polymorphism)), so we can get the String values (and manipulate them). Will
    print everything. Prints the objects values, rather than printing the string representation of the object.
    */
    @Override
    public String toString(){
        return "First Name: " + firstName + " Last Name: " + lastName + " Age: " + age;
    }

    /*
    A method to print all utilising our toString() method above... aka prints everything in our toString method.
     */
    public static void printAll(Person person){
        System.out.println(person.toString());
    }
}