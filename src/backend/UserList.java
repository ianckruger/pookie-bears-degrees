package backend;

import java.util.ArrayList;


public class UserList {

    private static UserList users;
    private ArrayList<User> userList;
    private User ActiveUser;

    private UserList() {
        this.ActiveUser = null;
        userList = DataLoader.readUsers();
    }

    public static UserList getInstance() {
        if(users == null) {
            users = new UserList();
            users.userList = DataLoader.readUsers();
        }
        return users;
    }
    
    public ArrayList<User> getUsers() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public boolean login(String username, String password) {
        for(User user : userList) {
            if(user.getUserName().equals(username) && user.getPassword().equals(password)) {
                this.ActiveUser = user;
                return true;
            }
         }
    return false;
    }

    public boolean registerStudent(String firstName, String lastName, String password, String userType, double gpa, String year, String currentMajor, int earnedCreditHours, int totalCurrentCredits, int degreeCredits, ArrayList<User> parents, ArrayList<User> advisors) {
        UserList userlist = UserList.getInstance();
        if ( userType.equals("student")) {
            Student student = new Student(firstName, lastName, password, userType, gpa, year, currentMajor, earnedCreditHours, totalCurrentCredits,   degreeCredits,  parents, advisors);
            userList.add(ActiveUser);
            //save user
            return true;
        }
        return false;
    }

    public boolean registerParent(String firstName, String lastName, String password, String userType, ArrayList<User> children, User child) {
        UserList userlist = UserList.getInstance();
        if(userType.equals("parent")) {
            Parent parent = new Parent(firstName, lastName, password, userType, children, child );
            userList.add(ActiveUser);
            //save user
            return true;
        }
        return false;
    }

    public boolean registerAdvisor(String firstName, String lastName, String password, String userType, ArrayList<User> students, User advising) {
        UserList userlist = UserList.getInstance();
        if(userType.equals("advisor")) {
            Advisor advisor = new Advisor(firstName, lastName, password, userType, students, advising);
            userList.add(ActiveUser);
            //save user
            return true;

        }
        return false;
    }




}