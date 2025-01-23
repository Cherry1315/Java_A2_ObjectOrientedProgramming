import java.util.*;
public class GymClassSorter implements Comparator<Member>{
    /*
    A method to alphabetically order Members. Compares members to members within the parameter. Checks/compares first
    names (member1 and member 2) regardless of camelcase to see if they are the same. If they are the same then it
    compares the last names regardless of camelcase.
     */
    @Override
    public int compare(Member member1, Member member2) {
        if (member1 == null || member2 == null) {
            throw new NullPointerException("One or both members are empty. Cannot sort an empty list!" );
        } else {
            if (member1.getFirstName().equalsIgnoreCase(member2.getFirstName()))
                return member1.getLastName().compareToIgnoreCase(member2.getLastName());
            else
                return member1.getFirstName().compareToIgnoreCase(member2.getFirstName());
        }
    }
}