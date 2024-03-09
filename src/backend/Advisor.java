package backend;

import java.util.ArrayList;
import java.util.UUID;

public class Advisor extends User {
    private ArrayList<User> students;
    private User advising;

    public Advisor(String userName, String firstName, String lastName, String password, String userType) {
        super(userName, firstName, lastName, password, userType);
        this.students = null;
        this.advising = null;

    }
    public Advisor(String userName, String firstName, String lastName, String password, String userType, ArrayList<User> students, User advising) {
        super(userName,firstName, lastName, password, userType);
        this.advising = advising;
        this.students = students;

        
    }

    public Advisor(String username, UUID userID, String firstName, String lastName, String password, String userType, ArrayList<User> students) {
        super(userID, username, firstName, lastName, password, userType);
        this.students = students;

        
    }
}