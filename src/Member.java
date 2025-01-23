public class Member extends Person{
    //instance variables
    private int membershipID;
    private int daysLeft;


    /*
    Constructor with no parameters
     */
    public Member() {
    }

    /*
    Constructor with 5 parameters. Initialising our instance variables within the constructor.
     */
    public Member(String firstName, String lastName, int age, int membershipID, int daysLeft) {
        super(firstName, lastName, age);
        this.membershipID = membershipID;
        this.daysLeft = daysLeft;
    }


    /*
    Getter
     */
    public int getMembershipID() {
        return membershipID;
    }

    /*
    Setter. Using a try catch to check for an IllegalArgumentException of membershipID being less or equal to 0, OR greater
    or equal to 2147483647. Prints a message if exception happens
     */
    public void setMembershipID(int membershipID) {
        try {
            if (membershipID <= 0 || membershipID >= 2147483647) {
                throw new IllegalArgumentException();
            } else {
                this.membershipID = membershipID;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Membership ID must be between 1 and 2147483646.");
        }
    }

    /*
    Getter
     */
    public int getDaysLeft() {
        return daysLeft;
    }

    /*
    Setter. Using a try catch to check for an IllegalArgumentException of datsLeft being less or equal to 0, OR greater
    or equal to 366. Prints a message if exception happens
     */
    public void setDaysLeft(int daysLeft) {
        try {
            if (daysLeft <= 0 || daysLeft >= 366) {
                throw new IllegalArgumentException();
            } else {
                this.daysLeft = daysLeft;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Days left of an annual membership can only be between 1 and 365 days");
        }
    }

    /*
    Overriding Object class via using toString() method (polymorphism)), so we can get the String values (and manipulate them). Will
    print everything. Prints the objects values, rather than printing the string representation of the object. Our parent
    class is called (super.toString()) as I don't want to modify what's originally written there.
    */
    @Override
    public String toString() {
        return super.toString() + " Membership ID: " + membershipID +  " Days Until Membership Expires: " + daysLeft;
    }
}