package backend;

import java.util.ArrayList;
import java.util.UUID;

public class Advisor extends User {
    private ArrayList<User> students;
    private User advising;

    public Advisor(String firstName, String lastName, String password, String userType, ArrayList<User> students, User advising) {
        super(firstName, lastName, password, userType);
        this.advising = advising;
        this.students = students;

        
    }

    public Advisor(UUID userID, String username, String firstName, String lastName, String password, String userType, ArrayList<User> students, User advising) {
        super(userID, username, firstName, lastName, password, userType);
        this.advising = advising;
        this.students = students;

        
    }
}