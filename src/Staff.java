public class Staff extends Person{
    //instance variables
    private double hourlyPay;
    private int staffID;


    /*
    Constructor with no parameters
     */
    public Staff() {
    }

    /*
    Constructor with 5 parameters. Initialising our instance variables within the constructor.
     */
    public Staff(String firstName, String lastName, int age, double hourlyPay, int staffID) {
        super(firstName, lastName, age);
        this.hourlyPay = hourlyPay;
        this.staffID = staffID;
    }


    /*
    Getter
     */
    public double getHourlyPay() {
        return hourlyPay;
    }

    /*
    Setter. Using a try catch to check for an IllegalArgumentException of hourly pay being less or equal to 0, or greater
    or equal to 80. Prints a message if exception happens
     */
    public void setHourlyPay(double hourlyPay) {
        try {
            if (hourlyPay <= 0 || hourlyPay >= 80.00) {
                throw new IllegalArgumentException();
            } else {
                this.hourlyPay = hourlyPay;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Hourly wage cannot be zero or less, nor greater than $80.00");
        }
    }

    /*
    Getter
     */
    public int getStaffID() {
        return staffID;
    }

    /*
    Setter. Using a try catch to check for an IllegalArgumentException of staffID being less or equal to 0, or greater or
     equal to 2147483647. Prints a message if exception happens
     */
    public void setStaffID(int staffID) {
        try {
            if (staffID <= 0 || staffID >= 2147483647) {
                throw new IllegalArgumentException();
            } else {
                this.staffID = staffID;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Staff ID must be between 1 and 2147483646.");
        }
    }

    /*
    Overriding Object class via using toString() method (polymorphism)), so we can get the String values (and manipulate them). Will
    print everything. Prints the objects values, rather than printing the string representation of the object. Our parent
    class is called (super.toString()) as I don't want to modify what's originally written there.
    */
    @Override
    public String toString() {
        return super.toString() + " Hourly Pay: " + hourlyPay +  " Staff ID: " + staffID;
    }
}